/*
 * Created by JFormDesigner on Thu Apr 14 23:09:35 TRT 2022
 */

package views;

import java.awt.event.*;
import models.UserImpl;
import utils.Util;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Login extends JFrame {
    UserImpl user = new UserImpl();

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    public Login() {
        initComponents();
    }

    public void usersLogin() {
        String user_email = txtEmail.getText().trim().toLowerCase();
        String password = String.valueOf(txtPassword.getPassword());
        if (user_email.equals("")) {
            txtEmail.requestFocus();
            lblError.setText("Please Entry E-Mail!");
        }else if (!Util.isValidEmailAddress(user_email)) {
            lblError.setText("E-Mail Format Error!");
        }else if (password.length() == 0) {
            lblError.setText("Please Entry Password");
            txtPassword.requestFocus();
        }else {
            lblError.setText("");
            boolean status = user.usersLogin(user_email, password);
            if (status) {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                dispose();
            }else {
                lblError.setText("E-Mail or Password False!");
            }
        }
    }

    private void btnUsersLogin(ActionEvent e) {
        usersLogin();
    }

    private void txtEmailKeyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            usersLogin();
        }
    }

    private void txtPasswordKeyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            usersLogin();
        }
    }

    private void btnSignInClick(ActionEvent e) {
        new SingIn().setVisible(true);
    }

    private void btnForgotPasswordClick(ActionEvent e) {
        new ForgotPassword().setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton();
        lblError = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Email:");

        //---- label2 ----
        label2.setText("Password:");

        //---- txtEmail ----
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtEmailKeyReleased(e);
            }
        });

        //---- txtPassword ----
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtPasswordKeyReleased(e);
            }
        });

        //---- btnLogin ----
        btnLogin.setText("Login");
        btnLogin.addActionListener(e -> btnUsersLogin(e));

        //---- lblError ----
        lblError.setText("Error:");

        //---- button1 ----
        button1.setText("SINGIN");
        button1.addActionListener(e -> btnSignInClick(e));

        //---- button2 ----
        button2.setText("Forgot Password");
        button2.addActionListener(e -> btnForgotPasswordClick(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap(139, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(txtEmail)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                    .addGap(26, 26, 26)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblError;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
