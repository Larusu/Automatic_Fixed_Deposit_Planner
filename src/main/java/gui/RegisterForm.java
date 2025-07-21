package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import dbcode.UserDAO;
import model.User;

public class RegisterForm extends javax.swing.JFrame {
    
    public RegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menuPanel1 = new components.MenuPanel();
        roundedButton21 = new components.RoundedButton2();
        backgroundPanel1 = new components.BackgroundPanel();
        roundedButton1 = new components.RoundedButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        registerLabel = new javax.swing.JLabel();
        showPasswordButton = new javax.swing.JButton();
        emailField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(43, 82, 136));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 700));
        jPanel1.setLayout(new java.awt.BorderLayout());

        menuPanel1.setPreferredSize(new java.awt.Dimension(270, 700));

        roundedButton21.setText("EXIT APPLICATION");
        roundedButton21.setPreferredSize(new java.awt.Dimension(185, 50));
        roundedButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanel1Layout = new javax.swing.GroupLayout(menuPanel1);
        menuPanel1.setLayout(menuPanel1Layout);
        menuPanel1Layout.setHorizontalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(roundedButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        menuPanel1Layout.setVerticalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanel1Layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addComponent(roundedButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jPanel1.add(menuPanel1, java.awt.BorderLayout.LINE_START);

        roundedButton1.setForeground(new java.awt.Color(43, 82, 136));
        roundedButton1.setText("ENTER");
        roundedButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        roundedButton1.setPreferredSize(new java.awt.Dimension(265, 51));
        roundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 239, 239));
        jLabel1.setText("Register");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(239, 239, 239));
        jLabel2.setText("Username:");

        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        usernameField.setForeground(new java.awt.Color(153, 153, 153));
        usernameField.setText("Enter your username");
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(239, 239, 239));
        jLabel3.setText("Password:");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setText("Enter your password");
        passwordField.setPreferredSize(new java.awt.Dimension(232, 38));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setText("<html>Already have an account? <a style='color:white; text-decoration: underline;' href=''>Login</a></html> ");
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });

        showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide_eye.png"))); // NOI18N
        showPasswordButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showPasswordButton.setPreferredSize(new java.awt.Dimension(35, 35));
        showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordButtonActionPerformed(evt);
            }
        });

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        emailField.setForeground(new java.awt.Color(153, 153, 153));
        emailField.setText("Enter your email");
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(239, 239, 239));
        jLabel4.setText("Email/Phone:");

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );

        jPanel1.add(backgroundPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private final String passwordPlaceholder = "Enter your password";
    
    private boolean isPasswordVisible = false;
    
    private void usernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusGained
        if (usernameField.getText().equals("Enter your username")) {
            usernameField.setText("");
            usernameField.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_usernameFieldFocusGained

    private void usernameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusLost
        if (usernameField.getText().isEmpty()) {
            usernameField.setForeground(new java.awt.Color(153, 153, 153));
            usernameField.setText("Enter your username");
        }
    }//GEN-LAST:event_usernameFieldFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SwingUtilities.invokeLater(() -> {
        jLabel1.requestFocusInWindow();
        passwordField.setText(passwordPlaceholder);
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
        });
    }//GEN-LAST:event_formWindowOpened

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed
        try {
            String username = usernameField.getText().trim();
            String email = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (email.isEmpty() || email.equals("Enter your email") ||
                password.isEmpty() || password.equals("Enter your password") ||
                username.isEmpty() || username.equals("Enter your username")) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = new User(username, email, password);
            UserDAO userDAO = new UserDAO();
            userDAO.register(user);
            
            // java.awt.EventQueue.invokeLater(new Runnable() {
            // public void run()
            // {
            //     new Dashboard().setVisible(true);
            // }
            // });
            
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_roundedButton1ActionPerformed

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if (passwordField.getText().equals(passwordPlaceholder)) {
            passwordField.setText("");
            passwordField.setForeground(Color.BLACK);
            passwordField.setEchoChar('●'); 
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (passwordField.getPassword().length == 0) {
            passwordField.setText(passwordPlaceholder);
            passwordField.setForeground(Color.GRAY);
            passwordField.setEchoChar((char) 0); 
            isPasswordVisible = false;
            showPasswordButton.setText("Show");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerLabelMouseClicked

    private void showPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordButtonActionPerformed
        String currentText = new String(passwordField.getPassword());

        if (currentText.equals(passwordPlaceholder)) return;

        if (isPasswordVisible) {
            passwordField.setEchoChar('●');
            showPasswordButton.setText("Show");
        } else {
            passwordField.setEchoChar((char) 0);
            showPasswordButton.setText("Hide");
        }
        isPasswordVisible = !isPasswordVisible;
    }//GEN-LAST:event_showPasswordButtonActionPerformed

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if (emailField.getText().equals("Enter your email")) {
            emailField.setText("");
            emailField.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (emailField.getText().isEmpty()) {
            emailField.setForeground(new java.awt.Color(153, 153, 153));
            emailField.setText("Enter your email");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void roundedButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton21ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_roundedButton21ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.BackgroundPanel backgroundPanel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private components.MenuPanel menuPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registerLabel;
    private components.RoundedButton roundedButton1;
    private components.RoundedButton2 roundedButton21;
    private javax.swing.JButton showPasswordButton;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
