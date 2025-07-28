package gui;

import dbcode.UserDAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import session.Session;
import static session.Session.userId;

public class Dashboard extends javax.swing.JFrame {
    
    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        
        logoutLabel.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 20f));
        exitLabel.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 20f));
        dashboardLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 50f));
        
        UserDAO user = new UserDAO();
        String userUsername = user.getField(userId, "username");
        
        profileView.setText(userUsername);
    }

    private void initComponents() {

        dashboardMenuPanel2 = new components.DashboardMenuPanel();
        logoutLabel = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        logoWhite = new javax.swing.JLabel();
        dashboardBackgroundPanel2 = new components.DashboardBackgroundPanel();
        dashboardLabel = new javax.swing.JLabel();
        viewPortfolioButton = new components.RoundedButton3();
        fixedDepositCalculatorButton = new components.RoundedButton3();
        createGoalButton = new components.RoundedButton3();
        createFixedDepositButton = new components.RoundedButton3();
        profileView = new components.RoundedButtonDecoration();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fixed Deposit Planner");
        setResizable(false);

        dashboardMenuPanel2.setPreferredSize(new java.awt.Dimension(242, 700));

        logoutLabel.setBackground(new java.awt.Color(255, 255, 255));
        logoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutLabel.setText("LOG OUT");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutLabelMouseExited(evt);
            }
        });

        exitLabel.setBackground(new java.awt.Color(255, 255, 255));
        exitLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(255, 255, 255));
        exitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitLabel.setText("EXIT APPLICATION");
        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitLabelMouseExited(evt);
            }
        });

        logoWhite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard_logo.png"))); // NOI18N
        logoWhite.setText("jLabel2");

        javax.swing.GroupLayout dashboardMenuPanel2Layout = new javax.swing.GroupLayout(dashboardMenuPanel2);
        dashboardMenuPanel2.setLayout(dashboardMenuPanel2Layout);
        dashboardMenuPanel2Layout.setHorizontalGroup(
            dashboardMenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardMenuPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(logoWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dashboardMenuPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(dashboardMenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitLabel)
                    .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        dashboardMenuPanel2Layout.setVerticalGroup(
            dashboardMenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardMenuPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(logoWhite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitLabel)
                .addGap(49, 49, 49))
        );

        getContentPane().add(dashboardMenuPanel2, java.awt.BorderLayout.LINE_START);

        dashboardBackgroundPanel2.setPreferredSize(new java.awt.Dimension(808, 700));
        dashboardBackgroundPanel2.setLayout(null);

        dashboardLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 50)); // NOI18N
        dashboardLabel.setForeground(new java.awt.Color(43, 82, 136));
        dashboardLabel.setText("Dashboard");
        dashboardBackgroundPanel2.add(dashboardLabel);
        dashboardLabel.setBounds(40, 40, 430, 90);

        viewPortfolioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_portfolio.png"))); // NOI18N
        viewPortfolioButton.setText("<html><center>View</center>Portfolio</html>");
        viewPortfolioButton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        viewPortfolioButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewPortfolioButton.setPreferredSize(new java.awt.Dimension(270, 510));
        viewPortfolioButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewPortfolioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPortfolioButtonActionPerformed(evt);
            }
        });
        dashboardBackgroundPanel2.add(viewPortfolioButton);
        viewPortfolioButton.setBounds(40, 180, 270, 480);

        fixedDepositCalculatorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fixed_deposit_calculator.png"))); // NOI18N
        fixedDepositCalculatorButton.setText("  Fixed Deposit Calculator");
        fixedDepositCalculatorButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        fixedDepositCalculatorButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fixedDepositCalculatorButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        fixedDepositCalculatorButton.setMargin(new java.awt.Insets(2, 15, 3, 14));
        fixedDepositCalculatorButton.setPreferredSize(new java.awt.Dimension(270, 510));
        fixedDepositCalculatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedDepositCalculatorButtonActionPerformed(evt);
            }
        });
        dashboardBackgroundPanel2.add(fixedDepositCalculatorButton);
        fixedDepositCalculatorButton.setBounds(350, 520, 410, 140);

        createGoalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/create_goal.png"))); // NOI18N
        createGoalButton.setText("   Create Goal");
        createGoalButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        createGoalButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        createGoalButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        createGoalButton.setMargin(new java.awt.Insets(2, 15, 3, 14));
        createGoalButton.setPreferredSize(new java.awt.Dimension(270, 510));
        createGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGoalButtonActionPerformed(evt);
            }
        });
        dashboardBackgroundPanel2.add(createGoalButton);
        createGoalButton.setBounds(350, 350, 410, 140);

        createFixedDepositButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/create_fixed_deposit_plan.png"))); // NOI18N
        createFixedDepositButton.setText("   Create Fixed Deposit");
        createFixedDepositButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        createFixedDepositButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        createFixedDepositButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        createFixedDepositButton.setMargin(new java.awt.Insets(2, 15, 3, 14));
        createFixedDepositButton.setPreferredSize(new java.awt.Dimension(270, 510));
        createFixedDepositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFixedDepositButtonActionPerformed(evt);
            }
        });
        dashboardBackgroundPanel2.add(createFixedDepositButton);
        createFixedDepositButton.setBounds(350, 180, 410, 140);

        profileView.setBackground(new java.awt.Color(239, 239, 239));
        profileView.setForeground(new java.awt.Color(43, 82, 136));
        profileView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        profileView.setText("<html> <span style='color: #2B5288;'>Username</span><br> <span style='color: #A6A6A6;'>email@example.com</span> </html> ");
        profileView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        profileView.setMargin(new java.awt.Insets(2, 5, 3, 14));
        profileView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileViewActionPerformed(evt);
            }
        });
        dashboardBackgroundPanel2.add(profileView);
        profileView.setBounds(480, 30, 300, 70);

        getContentPane().add(dashboardBackgroundPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewPortfolioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPortfolioButtonActionPerformed
        new Portfolio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewPortfolioButtonActionPerformed

    private void profileViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileViewActionPerformed
        new UserProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileViewActionPerformed

    private void createFixedDepositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFixedDepositButtonActionPerformed
        new CreateFixedDepositForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createFixedDepositButtonActionPerformed

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to log out?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Session.logout();
            this.dispose(); 
            new LoginForm().setVisible(true); 
        }
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void logoutLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseEntered
        logoutLabel.setForeground(new Color(190,190,190));
    }//GEN-LAST:event_logoutLabelMouseEntered

    private void logoutLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseExited
        logoutLabel.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_logoutLabelMouseExited

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
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
    }//GEN-LAST:event_exitLabelMouseClicked

    private void exitLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseEntered
        exitLabel.setForeground(new Color(190,190,190));
    }//GEN-LAST:event_exitLabelMouseEntered

    private void exitLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseExited
        exitLabel.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_exitLabelMouseExited

    private void createGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGoalButtonActionPerformed
        new CreateGoalForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_createGoalButtonActionPerformed

    private void fixedDepositCalculatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedDepositCalculatorButtonActionPerformed
        new FixedDepositCalculator().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_fixedDepositCalculatorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButton3 createFixedDepositButton;
    private components.RoundedButton3 createGoalButton;
    private components.DashboardBackgroundPanel dashboardBackgroundPanel2;
    private javax.swing.JLabel dashboardLabel;
    private components.DashboardMenuPanel dashboardMenuPanel2;
    private javax.swing.JLabel exitLabel;
    private components.RoundedButton3 fixedDepositCalculatorButton;
    private javax.swing.JLabel logoWhite;
    private javax.swing.JLabel logoutLabel;
    private components.RoundedButtonDecoration profileView;
    private components.RoundedButton3 viewPortfolioButton;
    // End of variables declaration//GEN-END:variables
}
