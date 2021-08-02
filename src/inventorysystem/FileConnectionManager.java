
package inventorysystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KL_Schweizer
 */
public class FileConnectionManager {
    
    private String connectionAddress = "localhost";
    
    public FileConnectionManager()
    {
        try {
            File myObj = new File("connection.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                if(data.length() > 9 && data.charAt(0) == '1')
                {
                    connectionAddress = data;
                    break;
                }
                else
                {
                    connectionAddress = "localhost";
                    break;
                }
            }
            System.out.println(connectionAddress);
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }

    public String getConnectionAddress() {
        return connectionAddress;
    }
}
