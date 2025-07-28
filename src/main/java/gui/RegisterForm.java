package gui;

import dbcode.UserDAO;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.User;

public class RegisterForm extends javax.swing.JFrame {
    private char defaultEchoChar;
    private boolean showingPassword = false;
    
    public RegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        registerLabel.requestFocusInWindow();
        defaultEchoChar = passwordField.getEchoChar();

        registerLabel.setFont(FontLoader.loadFont("agrandir_regular.otf", Font.PLAIN, 90f));
        exitApplicationButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        usernameLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        usernameField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        emailLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        emailField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        passwordLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 36f));
        registerButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        registerButton.setVerticalAlignment(SwingConstants.CENTER);
        registerButton.setMargin(new Insets(20,10,10,10));
        loginLabel.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 12f));
        appnameLabel.setFont(FontLoader.loadFont("shrikhand_regular.ttf", Font.PLAIN, 30f));
        mottoLabel.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 12f));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightPanel = new components.BackgroundPanel();
        registerLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        registerButton = new components.RoundedButton();
        loginLabel = new javax.swing.JLabel();
        viewPasswordButton = new components.RoundedButton();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        leftPanel = new components.DashboardBackgroundPanel();
        exitApplicationButton = new components.RoundedButton2();
        logoBlue = new javax.swing.JLabel();
        appnameLabel = new javax.swing.JLabel();
        mottoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        rightPanel.setPreferredSize(new java.awt.Dimension(780, 700));

        registerLabel.setFont(new java.awt.Font("Segoe UI", 0, 90)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Register");

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

        registerButton.setForeground(new java.awt.Color(43, 82, 136));
        registerButton.setText("Register");
        registerButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        registerButton.setPreferredSize(new java.awt.Dimension(265, 51));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setText("Already have an account? Login");
        loginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLabelMouseClicked(evt);
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

        usernameLabel.setFont(new java.awt.Font("Gill Sans MT Condensed", 1, 36)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(239, 239, 239));
        usernameLabel.setText("Username");

        usernameField.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(viewPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(542, 542, 542))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(registerLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(loginLabel)
                .addGap(45, 45, 45))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        leftPanel.setPreferredSize(new java.awt.Dimension(270, 700));
        leftPanel.setLayout(null);

        exitApplicationButton.setText("EXIT APPLICATION");
        exitApplicationButton.setPreferredSize(new java.awt.Dimension(185, 50));
        exitApplicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitApplicationButtonActionPerformed(evt);
            }
        });
        leftPanel.add(exitApplicationButton);
        exitApplicationButton.setBounds(40, 581, 185, 50);

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
  
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
            String username = usernameField.getText().trim();
            String email = emailField.getText().trim();
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
  
            JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            new LoginForm().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void exitApplicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitApplicationButtonActionPerformed
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
    }//GEN-LAST:event_exitApplicationButtonActionPerformed

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

    private void loginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLabelMouseClicked
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appnameLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private components.RoundedButton2 exitApplicationButton;
    private components.DashboardBackgroundPanel leftPanel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoBlue;
    private javax.swing.JLabel mottoLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private components.RoundedButton registerButton;
    private javax.swing.JLabel registerLabel;
    private components.BackgroundPanel rightPanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private components.RoundedButton viewPasswordButton;
    // End of variables declaration//GEN-END:variables
}
