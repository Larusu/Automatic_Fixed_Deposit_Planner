package gui;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import session.Session;

public class LoginForm extends javax.swing.JFrame {
    private char defaultEchoChar;
    private boolean showingPassword = false;
    
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        loginLabel.requestFocusInWindow();
        defaultEchoChar = passwordField.getEchoChar();

        loginLabel.setFont(FontLoader.loadFont("agrandir_regular.otf", Font.PLAIN, 90f));
        exitButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        emailLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        emailField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        passwordLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        loginButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        loginButton.setVerticalAlignment(SwingConstants.CENTER);
        loginButton.setMargin(new Insets(20,10,10,10));
        registerLabel.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 12f));
        appnameLabel.setFont(FontLoader.loadFont("shrikhand_regular.ttf", Font.PLAIN, 30f));
        mottoLabel.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 12f));
    }
    
    private void initComponents() {

        rightPanel = new components.BackgroundPanel();
        loginLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new components.RoundedButton();
        registerLabel = new javax.swing.JLabel();
        viewPasswordButton = new components.RoundedButton();
        leftPanel = new components.DashboardBackgroundPanel();
        exitButton = new components.RoundedButton2();
        logoBlue = new javax.swing.JLabel();
        appnameLabel = new javax.swing.JLabel();
        mottoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        rightPanel.setPreferredSize(new java.awt.Dimension(780, 700));

        loginLabel.setFont(new java.awt.Font("Segoe UI", 0, 90)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Login");

        emailLabel.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(239, 239, 239));
        emailLabel.setText("Email:");

        emailField.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(239, 239, 239));
        passwordLabel.setText("Password:");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordField.setEchoChar('\u25cf');
        passwordField.setPreferredSize(new java.awt.Dimension(232, 38));

        loginButton.setForeground(new java.awt.Color(43, 82, 136));
        loginButton.setText("Login");
        loginButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        loginButton.setPreferredSize(new java.awt.Dimension(265, 51));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setText("No account yet? Register");
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });

        viewPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hide_eye.png"))); // NOI18N
        viewPasswordButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewPasswordButton.setPreferredSize(new java.awt.Dimension(40, 40));
        viewPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(viewPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(200, 200, 200))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(loginLabel)
                .addGap(26, 26, 26)
                .addComponent(emailLabel)
                .addGap(6, 6, 6)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(passwordLabel)
                .addGap(6, 6, 6)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(viewPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(registerLabel))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        leftPanel.setPreferredSize(new java.awt.Dimension(270, 700));
        leftPanel.setLayout(null);

        exitButton.setText("EXIT APPLICATION");
        exitButton.setPreferredSize(new java.awt.Dimension(185, 50));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        leftPanel.add(exitButton);
        exitButton.setBounds(40, 581, 185, 50);

        logoBlue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_logo.png"))); // NOI18N
        leftPanel.add(logoBlue);
        logoBlue.setBounds(30, 70, 210, 210);

        appnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        appnameLabel.setForeground(new java.awt.Color(43, 82, 136));
        appnameLabel.setText("BLUPLAN");
        leftPanel.add(appnameLabel);
        appnameLabel.setBounds(60, 290, 150, 40);

        mottoLabel.setForeground(new java.awt.Color(43, 82, 136));
        mottoLabel.setText("Turn intentions into actions");
        leftPanel.add(mottoLabel);
        mottoLabel.setBounds(40, 330, 190, 16);

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (email.isEmpty() || email.equals("Enter your email") ||
                password.isEmpty() || password.equals("Enter your password")) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Session.login(email, password);

            new Dashboard().setVisible(true);
            JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        new RegisterForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerLabelMouseClicked

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit the application?",
            "Exit Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void viewPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPasswordButtonActionPerformed
        if (showingPassword) {
            passwordField.setEchoChar(defaultEchoChar); 
            passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        } else {
            passwordField.setEchoChar((char) 0); 
            passwordField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        }
        showingPassword = !showingPassword;
    }//GEN-LAST:event_viewPasswordButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appnameLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private components.RoundedButton2 exitButton;
    private components.DashboardBackgroundPanel leftPanel;
    private components.RoundedButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoBlue;
    private javax.swing.JLabel mottoLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerLabel;
    private components.BackgroundPanel rightPanel;
    private components.RoundedButton viewPasswordButton;
    // End of variables declaration//GEN-END:variables
}
