package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import dbcode.UserDAO;
import model.User;

public class LoginForm extends javax.swing.JFrame {
    
    public LoginForm() {
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
        emailPhoneLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        registerLabel = new javax.swing.JLabel();
        showPasswordButton = new javax.swing.JButton();

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
        jLabel1.setText("Login");

        emailPhoneLabel.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        emailPhoneLabel.setForeground(new java.awt.Color(239, 239, 239));
        emailPhoneLabel.setText("Email/Phone:");

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

        passwordLabel.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(239, 239, 239));
        passwordLabel.setText("Password:");

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
        registerLabel.setText("<html>No account yet? <a style='color:white; text-decoration: underline;' href=''>Register</a></html> ");
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

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1))
                    .addGroup(backgroundPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailPhoneLabel)
                                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                    .addComponent(passwordLabel)
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(emailPhoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                        .addComponent(showPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(55, 55, 55)
                .addComponent(roundedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
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
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (email.isEmpty() || email.equals("Enter your email") ||
                password.isEmpty() || password.equals("Enter your password")) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = new User(email, password);
            UserDAO userDAO = new UserDAO();
            userDAO.login(user);

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
        if (new String(passwordField.getPassword()).equals(passwordPlaceholder)) {
            passwordField.setText("");
            passwordField.setForeground(Color.BLACK);
            passwordField.setEchoChar('●'); // Use bullet or asterisk
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
        new RegisterForm().setVisible(true);
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

    private void roundedButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton21ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_roundedButton21ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.BackgroundPanel backgroundPanel1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailPhoneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private components.MenuPanel menuPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerLabel;
    private components.RoundedButton roundedButton1;
    private components.RoundedButton2 roundedButton21;
    private javax.swing.JButton showPasswordButton;
    // End of variables declaration//GEN-END:variables
}
