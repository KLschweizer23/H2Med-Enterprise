package inventorysystem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 *
 * @author KL_Schweizer
 */
public class MonthlyBarGraph extends JComponent
{
    //Single rect
    ArrayList<Rectangle2D.Double> rects;

    //Multiple rects
    ArrayList<Rectangle2D.Double[]> rectsMulti;


    //Bar color
    private Color[] colorPerBar = {Color.ORANGE};
    //Background Color
    private Color backgroundColor = new Color(242, 239, 233);

    //Label on the right side of graph
    private String verticalLabel = "Label A";
    //Bar names
    private String[] barNames = {"Bar 1"};
    //Months
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    //Maximum value a bar can reach
    private double maxValue = 100.0;

    //Bar per month
    private int barPerMonth = 1;
    //Height of Month Labels
    private final int stringHeight = 10;
    //Height Graph Space
    private int spaceHeight = 0;
    //Top Margin
    private final int topMargin = 20;
    //Left Margin
    private final int leftMargin = 60;
    //Number of lines
    private int numberOfRowLabel = 5;

    /**
     * 
     * @param       verticalLabel           Label on the right side of Bar
     * @param       maxValueOfBar           Highest value of Bar
     * @param       height                  Height of Component
     * @param       width                   Width of Component
     */
    public MonthlyBarGraph(String verticalLabel, double maxValueOfBar, int height, int width) {
        if(verticalLabel != null)
            this.verticalLabel = verticalLabel;
        this.maxValue = maxValueOfBar < 10 ? maxValue : maxValueOfBar;
        rects = new ArrayList<>();
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * 
     * @param       barPerMonth             Set number of bars per month Max of 3
     * @param       barNames                Name for each bars
     * @param       colorPerBar             Color for each  bars
     */
    public void setMultipleBars(int barPerMonth, String[] barNames, Color[] colorPerBar)
    {
        this.barPerMonth = barPerMonth > 4 ? 4 : barPerMonth;
        this.barNames = barNames;
        this.colorPerBar = colorPerBar;
        rectsMulti = new ArrayList<>();
    }

    /**
     * method to generate multi-bars per month
     * @param       map                     Hashmap of values for every bars and months in Sentence case are keys ("January")
     */
    public void generateMultiBars(HashMap<String, double[]> map)
    {
        map = map == null || map.size() < 1 ? getDefaultMap() : map;
        setupRects(map);
        repaint();
    }
    private HashMap<String, double[]> getDefaultMap()
    {
        HashMap<String, double[]> map = new HashMap();
        double[] vals = new double[barPerMonth];
        for(int i = 0; i < barPerMonth; i++)
            vals[i] = 0;
        for (String month : months)
                map.put(month, vals);
        return map;
    }
    private void setupRects(HashMap<String, double[]> map)
    {
        double w = getBarWidth();
        for(int i = 0, k = 0; i < map.size() && map.size() == months.length; i++, k++)
        {
            if(map.get(months[i]).length == barPerMonth)
            {
                Rectangle2D.Double[] rectsArray = new Rectangle2D.Double[barPerMonth];
                for(int j = 0; j < barPerMonth; j++, k++)
                {
                    double x = leftMargin + ((w / 2) + (w * k));
                    int y = (int)getPreferredSize().getHeight() - (stringHeight + 10);
                    double h = getBarHeight(map.get(months[i])[j], y);
                    Rectangle2D.Double rect = new Rectangle2D.Double(
                         x, y, w, h
                    );
                    rectsArray[j] = rect;
                }
                rectsMulti.add(rectsArray);
            }
        }
        repaint();
    }
    private void generateGraph(Graphics2D g2)
    {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.white);//((months.length * barPerMonth) + (here))
        g2.fillRect(leftMargin, topMargin, ((int)rectsMulti.get(months.length - 1)[barPerMonth - 1].x + (int)getBarWidth()) - (leftMargin), spaceHeight - (stringHeight * 2));

        //draw line surrounding the graph
        g2.setColor(Color.lightGray);
        int cornerPoint = (int)rectsMulti.get(0)[0].y;
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(leftMargin, topMargin, leftMargin, cornerPoint);
        g2.drawLine(leftMargin, cornerPoint, (int)rectsMulti.get(months.length - 1)[barPerMonth - 1].x + (int)getBarWidth(), cornerPoint);
        g2.setStroke(new BasicStroke(1));

        //create backgrounds
        g2.setColor(Color.lightGray);
        int numberOfLines = numberOfRowLabel - 1;
        int interval = (spaceHeight - (stringHeight * 2)) / numberOfLines;

        for(int i = 0; i < (int)rectsMulti.get(months.length - 1)[barPerMonth - 1].x / 10.5; i++)
        {
            int left = (i * 10) + leftMargin;
            int left1 = ((i + 1) * 10) + leftMargin;
            for(int j = 0; j < numberOfLines; j++)
                g2.drawLine(left, topMargin + (j * interval), left1, topMargin + (j * interval));
            i++;
        }

        //create amount
        g2.setColor(Color.black);
        g2.setFont(new Font("Times Roman", Font.PLAIN, 12));
        FontMetrics fontMetrics = g2.getFontMetrics();
        for(int i = 0; i < numberOfRowLabel; i++)
        {
            int left = leftMargin - 5;
            String b = Math.abs(maxValue - Math.round((maxValue / numberOfLines) * i)) + "";
            g2.drawString(b, left - fontMetrics.stringWidth(b), (i * interval) + topMargin + 5);
        }
    }
    private double getBarHeight(double value, int point0)
    {
        double finalHeight;

        int height = (int)getPreferredSize().getHeight();
        spaceHeight = height - (height - point0);

        double percentEquiVal = value / maxValue;
        finalHeight = (spaceHeight - topMargin) * percentEquiVal;
        return 0 - finalHeight;
    }
    private double getBarWidth()
    {
        double numberOfBars = (months.length * barPerMonth) + (months.length + 4);
        double widthSize = (int)getPreferredSize().getWidth();
        double widthOfBars = widthSize / numberOfBars;

        return widthOfBars;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        generateGraph(g2);
        for(int i = 0; i < rectsMulti.size(); i++)
        {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            for(int j = 0; j < rectsMulti.get(i).length; j++)
            {
                g2.setColor(colorPerBar[j]);
                g2.fillRect(
                        (int)rectsMulti.get(i)[j].x, 
                        (int)rectsMulti.get(i)[j].y, 
                        (int)rectsMulti.get(i)[j].width, 
                        (int)rectsMulti.get(i)[j].height
                );
            }
            g2.setColor(Color.black);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Font f = new Font("TimesRoman", Font.PLAIN, (int)(getBarWidth() * 0.6));
            FontMetrics metrics = g.getFontMetrics(f);
            String text = months[i];
            double x = rectsMulti.get(i)[0].x + ((int)(getBarWidth() * 3) - metrics.stringWidth(text)) / 2;
            double y = rectsMulti.get(i)[0].y + (((stringHeight + 10) - metrics.getHeight()) / 2) + metrics.getAscent();
            g2.setFont(f);
            g2.drawString(text, (float)x, (float)y);
        }
    }
}