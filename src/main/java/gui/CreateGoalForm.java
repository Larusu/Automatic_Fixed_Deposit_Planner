package gui;

import dbcode.GoalDAO;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.Goal;

public class CreateGoalForm extends javax.swing.JFrame {

        public enum Frequency {
            ANNUALLY("Annually"),
            SEMIANNUALLY("Semiannually"),
            QUARTERLY("Quarterly"),
            MONTHLY("Monthly"),
            BIWEEKLY("Biweekly"),
            WEEKLY("Weekly"),
            DAILY("Daily");

        private final String label;

        Frequency(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
        
    public CreateGoalForm() {
        initComponents();
        setLocationRelativeTo(null);
        
        createAGoalLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 50f));
        goalNameLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 40f));
        goalNameField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 25f));
        targetAmountLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 40f));
        targetAmountField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 25f));
        targetDateLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 40f));
        targetDateValueField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 25f));
        targetDateUnitComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        backButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        createGoalButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        createGoalButton.setVerticalAlignment(SwingConstants.CENTER);
        createGoalButton.setMargin(new Insets(20,10,10,10));
    }
    
    private void initComponents() {

        leftPanel = new components.DashboardMenuPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new components.RoundedButton();
        rightPanel = new components.DashboardBackgroundPanel();
        roundedPanel1 = new components.RoundedPanel();
        goalNameLabel = new javax.swing.JLabel();
        targetDateLabel = new javax.swing.JLabel();
        targetAmountLabel = new javax.swing.JLabel();
        goalNameField = new javax.swing.JTextField();
        targetAmountField = new javax.swing.JFormattedTextField();
        targetDateValueField = new javax.swing.JFormattedTextField();
        targetDateUnitComboBox = new javax.swing.JComboBox<>();
        createGoalButton = new components.RoundedButton3();
        createAGoalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fixed Deposit Planner");
        setResizable(false);

        leftPanel.setPreferredSize(new java.awt.Dimension(242, 700));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard_logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(77, 88));

        backButton.setForeground(new java.awt.Color(47, 90, 166));
        backButton.setText("BACK\n");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setPreferredSize(new java.awt.Dimension(808, 700));

        roundedPanel1.setBackground(new java.awt.Color(47, 90, 166));

        goalNameLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        goalNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        goalNameLabel.setText("Goal Name:");

        targetDateLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        targetDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        targetDateLabel.setText("Target Date:");

        targetAmountLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        targetAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        targetAmountLabel.setText("Target Amount:");

        goalNameField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        targetAmountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        targetAmountField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        targetDateValueField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        targetDateValueField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        targetDateUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weeks", "Months", "Years" }));

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(targetDateValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(targetDateUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(targetDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(targetAmountLabel)
                        .addComponent(goalNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goalNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                        .addComponent(targetAmountField)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(goalNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goalNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(targetAmountLabel)
                .addGap(12, 12, 12)
                .addComponent(targetAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(targetDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(targetDateValueField)
                    .addComponent(targetDateUnitComboBox))
                .addGap(63, 63, 63))
        );

        createGoalButton.setText("Create");
        createGoalButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGoalButtonActionPerformed(evt);
            }
        });

        createAGoalLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 80)); // NOI18N
        createAGoalLabel.setForeground(new java.awt.Color(43, 82, 136));
        createAGoalLabel.setText("Create a Goal");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createAGoalLabel)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(createAGoalLabel)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(createGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void createGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGoalButtonActionPerformed
        try {
            String goalName = goalNameField.getText().trim();
            String targetAmountTxt = targetAmountField.getText().trim();
            String targetDateValueTxt = targetDateValueField.getText().trim();
            String targetDateUnit = targetDateUnitComboBox.getSelectedItem().toString();
            
            if (goalName.isEmpty() || targetAmountTxt.isEmpty() || targetDateValueTxt.isEmpty() || targetDateUnit.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;            
            }
            
            double targetAmount = Double.parseDouble(targetAmountTxt);
            int targetDateValue = Integer.parseInt(targetDateValueTxt);
            
            GoalDAO goalInsert = new GoalDAO();
            Goal goal = new Goal(goalName, targetDateValue, targetDateUnit, targetAmount); 
            goalInsert.insert(goal);
            
            JOptionPane.showMessageDialog(this, "Goal created successfully.", "Creation Success", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            new Dashboard().setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_createGoalButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButton backButton;
    private javax.swing.JLabel createAGoalLabel;
    private components.RoundedButton3 createGoalButton;
    private javax.swing.JTextField goalNameField;
    private javax.swing.JLabel goalNameLabel;
    private javax.swing.JLabel jLabel1;
    private components.DashboardMenuPanel leftPanel;
    private components.DashboardBackgroundPanel rightPanel;
    private components.RoundedPanel roundedPanel1;
    private javax.swing.JFormattedTextField targetAmountField;
    private javax.swing.JLabel targetAmountLabel;
    private javax.swing.JLabel targetDateLabel;
    private javax.swing.JComboBox<String> targetDateUnitComboBox;
    private javax.swing.JFormattedTextField targetDateValueField;
    // End of variables declaration//GEN-END:variables
}
