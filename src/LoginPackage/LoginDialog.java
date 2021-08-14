package LoginPackage;

import inventorysystem.MainFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import myUtilities.MessageHandler;

/**
 *
 * @author KL_Schweizer
 */
public class LoginDialog extends javax.swing.JDialog {

    private MainFrame main;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textField_username = new javax.swing.JTextField();
        passField_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_login = new javax.swing.JButton();
        button_exit = new javax.swing.JButton();
        label_register = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Username");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Password");
        jLabel2.setFocusable(false);

        button_login.setText("Login");
        button_login.setFocusable(false);
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        button_exit.setText("Exit");
        button_exit.setFocusable(false);
        button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exitActionPerformed(evt);
            }
        });

        label_register.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_register.setText("Register New Account!");
        label_register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_registerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_registerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField_username)
                    .addComponent(passField_password)
                    .addComponent(button_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_register, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_register)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button_exitActionPerformed

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
        login();
    }//GEN-LAST:event_button_loginActionPerformed

    private void label_registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_registerMouseEntered
        label_register.setForeground(Color.red);
    }//GEN-LAST:event_label_registerMouseEntered

    private void label_registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_registerMouseExited
        label_register.setForeground(Color.black);
    }//GEN-LAST:event_label_registerMouseExited

    private void label_registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_registerMousePressed
        register();
    }//GEN-LAST:event_label_registerMousePressed
    private void register()
    {
        setAlwaysOnTop(false);
        MessageHandler mh = new MessageHandler();
        mh.warning("Feature not yet available!");
        setAlwaysOnTop(true);
    }
    private void login()
    {
        LoginDatabaseManager logObj = new LoginDatabaseManager();
        MessageHandler mh = new MessageHandler();
        
        LoginObject lo = logObj.checkAccount(textField_username.getText(), passField_password.getPassword());
        
        String pass = "";
        
        for(char x : passField_password.getPassword())
            pass+= x;
        if(textField_username.getText().equals("admin") && pass.equals("kladmin"))
        {
            lo = new LoginObject();
            lo.setId("0");
            lo.setUsername("Admin");
            lo.setPassword("kladmin");
            lo.setRole("ADMIN");
            main.grantedAccess = true;
            main.setLogObj(lo);
            setAlwaysOnTop(false);
            mh.message("Admin successfully logged in!");
            dispose();
        }
        else if(lo != null)
        {
            main.grantedAccess = true;
            main.setLogObj(lo);
            setAlwaysOnTop(false);
            mh.message("You have successfully logged in!");
            dispose();
        }
        else
        {
            setAlwaysOnTop(false);
            mh.error("Credentials not found!", false);
        }
    }
    private void setupCommands()
    {
        int property = JComponent.WHEN_IN_FOCUSED_WINDOW;
        
        jPanel1.registerKeyboardAction(e -> {
            System.exit(0);
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), property);
        
        textField_username.registerKeyboardAction(e -> {
            login();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        
        passField_password.registerKeyboardAction(e -> {
            login();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
        
        getRootPane().registerKeyboardAction(e -> {
            login();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), property);
    }
    public LoginDialog(MainFrame main, boolean modal)
    {
        super(main, modal);
        this.main = main;
        initComponents();
        setAlwaysOnTop(true);
        setupCommands();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_register;
    private javax.swing.JPasswordField passField_password;
    private javax.swing.JTextField textField_username;
    // End of variables declaration//GEN-END:variables
}
