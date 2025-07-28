package gui;

import dbcode.UserDAO;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import session.Session;
import static session.Session.userId;

public class UserProfile extends javax.swing.JFrame {

    UserDAO user;
    String userUsername;
    String userEmail;

    public UserProfile() {
        initComponents();
        setLocationRelativeTo(null);
        
        profileLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 80f));
        backButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        usernameLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 50f));
        usernameField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 50f));
        emailLabel.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 50f));
        emailField.setFont(FontLoader.loadFont("league_gothic_regular.ttf", Font.PLAIN, 50f));
        updateProfileButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        updateProfileButton.setVerticalAlignment(SwingConstants.CENTER);
        updateProfileButton.setMargin(new Insets(20,10,10,10));
              
        user = new UserDAO();
        userUsername = user.getField(userId, "username");
        userEmail = user.getField(userId, "email");
        
        usernameField.setText(userUsername);
        emailField.setText(userEmail);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new components.DashboardMenuPanel();
        logo = new javax.swing.JLabel();
        backButton = new components.RoundedButton();
        rightPanel = new components.DashboardBackgroundPanel();
        profileLabel = new javax.swing.JLabel();
        userProfilePanel = new components.RoundedPanel();
        usernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        updateProfileButton = new components.RoundedButton3();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fixed Deposit Planner");

        leftPanel.setPreferredSize(new java.awt.Dimension(242, 700));
        leftPanel.setLayout(null);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard_logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftPanel.add(logo);
        logo.setBounds(80, 60, 80, 80);

        backButton.setForeground(new java.awt.Color(47, 90, 166));
        backButton.setText("BACK\n");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        leftPanel.add(backButton);
        backButton.setBounds(49, 620, 139, 37);

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setPreferredSize(new java.awt.Dimension(808, 700));

        profileLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 80)); // NOI18N
        profileLabel.setForeground(new java.awt.Color(43, 82, 136));
        profileLabel.setText("Profile");

        userProfilePanel.setBackground(new java.awt.Color(47, 90, 166));

        usernameLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username:");

        emailLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email:");

        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        emailField.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N

        javax.swing.GroupLayout userProfilePanelLayout = new javax.swing.GroupLayout(userProfilePanel);
        userProfilePanel.setLayout(userProfilePanelLayout);
        userProfilePanelLayout.setHorizontalGroup(
            userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfilePanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel)
                    .addComponent(emailLabel)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        userProfilePanelLayout.setVerticalGroup(
            userProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfilePanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        updateProfileButton.setText("Update");
        updateProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileLabel)
                    .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                            .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                            .addComponent(userProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)))))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(updateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileButtonActionPerformed
        try {
            String updatedUserName = usernameField.getText();
            String updatedEmail = emailField.getText();
            
            if (updatedUserName.isEmpty() || updatedEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Update failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ArrayList<Object>userStore = new ArrayList<>();
            userStore.add(updatedUserName);
            userStore.add(updatedEmail);
            
            ArrayList<String>column = new ArrayList<>();
            column.add("username");
            column.add("email");
            
            user.updateField(Session.userId, column, userStore);
            
            JOptionPane.showMessageDialog(null, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            new Dashboard().setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateProfileButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButton backButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private components.DashboardMenuPanel leftPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel profileLabel;
    private components.DashboardBackgroundPanel rightPanel;
    private components.RoundedButton3 updateProfileButton;
    private components.RoundedPanel userProfilePanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
