package gui;

import dbcode.DepositPlanDAO;
import dbcode.GoalDAO;
import dbcode.InvestmentDAO;
import java.awt.Font;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.DepositPlan;
import model.Goal;

public class CreateFixedDepositForm extends javax.swing.JFrame {
        
    private Map<String, Goal> goalMap = new HashMap<>();

    GoalDAO goal;
    
    public CreateFixedDepositForm() {
        goal = new GoalDAO();
        initComponents();
        setLocationRelativeTo(null);
        
        newDepositPlanLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 50f));
        planNameLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 24f));
        planNameField.setFont(FontLoader.loadFont("league_gothic_regular", Font.PLAIN, 18f));
        principalAmountLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD,20f));
        principalAmountField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        interestRateLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        interestRateField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        bankComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        depositDurationLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        depositDurationField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        depositDurationComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        compoundingFrequencyLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        compoundingFrequencyComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        startDateLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        startDateChooser.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        connectGoalLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        goalComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        taxApplicableLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.ITALIC, 14f));
        backButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        createFixedDepositPlanButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        createFixedDepositPlanButton.setVerticalAlignment(SwingConstants.CENTER);
        createFixedDepositPlanButton.setMargin(new Insets(20,10,10,10));

        loadGoalsToComboBox();
    }
    
    private void loadGoalsToComboBox() {
        ArrayList<Goal> goals = goal.getAllGoals();
        goalComboBox.removeAllItems(); 
        goalMap.clear();

        if (goals != null) {
            for (Goal g : goals) {
                String name = g.getName();
                goalComboBox.addItem(name); 
                goalMap.put(name, g);        
            }
        } else {
            System.err.println("Goal list is null.");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new components.DashboardMenuPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new components.RoundedButton();
        rightPanel = new components.DashboardBackgroundPanel();
        roundedPanel1 = new components.RoundedPanel();
        principalAmountLabel = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        bankComboBox = new javax.swing.JComboBox<>();
        interestRateField = new javax.swing.JTextField();
        depositDurationLabel = new javax.swing.JLabel();
        depositDurationComboBox = new javax.swing.JComboBox<>();
        depositDurationField = new javax.swing.JFormattedTextField();
        principalAmountField = new javax.swing.JFormattedTextField();
        compoundingFrequencyLabel = new javax.swing.JLabel();
        compoundingFrequencyComboBox = new components.FrequencyComboBox();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        startDateLabel = new javax.swing.JLabel();
        connectGoalLabel = new javax.swing.JLabel();
        taxApplicableLabel = new javax.swing.JLabel();
        goalComboBox = new javax.swing.JComboBox<>();
        createFixedDepositPlanButton = new components.RoundedButton3();
        newDepositPlanLabel = new javax.swing.JLabel();
        planNameLabel = new javax.swing.JLabel();
        planNameField = new javax.swing.JTextField();

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
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.CENTER);

        rightPanel.setPreferredSize(new java.awt.Dimension(808, 700));

        roundedPanel1.setBackground(new java.awt.Color(47, 90, 166));

        principalAmountLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        principalAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        principalAmountLabel.setText("Principal Amount:");

        interestRateLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        interestRateLabel.setForeground(new java.awt.Color(255, 255, 255));
        interestRateLabel.setText("Interest Rate (%):");

        bankComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BDO", "BPI", "Metrobank", "Security Bank", "RCBC", "Maya Savings", "CIMB", "SeaBank", "Uno Digital Bank", "GoTyme Bank" }));
        bankComboBox.setPreferredSize(new java.awt.Dimension(104, 22));
        bankComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankComboBoxActionPerformed(evt);
            }
        });

        interestRateField.setEditable(false);
        interestRateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        depositDurationLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        depositDurationLabel.setForeground(new java.awt.Color(255, 255, 255));
        depositDurationLabel.setText("Deposit Duration:");

        depositDurationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONTHS", "YEARS" }));

        depositDurationField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        principalAmountField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        principalAmountField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        compoundingFrequencyLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        compoundingFrequencyLabel.setForeground(new java.awt.Color(255, 255, 255));
        compoundingFrequencyLabel.setText("Compounding Frequency: ");

        compoundingFrequencyComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Annually", "Semiannually", "Quarterly", "Monthly", " " }));

        startDateLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        startDateLabel.setText("Start Date:");

        connectGoalLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        connectGoalLabel.setForeground(new java.awt.Color(255, 255, 255));
        connectGoalLabel.setText("Connect to a goal:");

        taxApplicableLabel.setFont(new java.awt.Font("Leelawadee UI", 3, 14)); // NOI18N
        taxApplicableLabel.setForeground(new java.awt.Color(255, 255, 255));
        taxApplicableLabel.setText("Tax Applicable");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taxApplicableLabel))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(principalAmountLabel)
                            .addComponent(depositDurationLabel)
                            .addComponent(compoundingFrequencyLabel)
                            .addComponent(interestRateLabel)
                            .addComponent(startDateLabel)
                            .addComponent(connectGoalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(principalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(depositDurationField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(interestRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(depositDurationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(compoundingFrequencyComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(goalComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(principalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depositDurationField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositDurationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compoundingFrequencyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compoundingFrequencyComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(goalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectGoalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(taxApplicableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        createFixedDepositPlanButton.setText("Create");
        createFixedDepositPlanButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createFixedDepositPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFixedDepositPlanButtonActionPerformed(evt);
            }
        });

        newDepositPlanLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 40)); // NOI18N
        newDepositPlanLabel.setForeground(new java.awt.Color(43, 82, 136));
        newDepositPlanLabel.setText("New Deposit Plan");

        planNameLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        planNameLabel.setForeground(new java.awt.Color(43, 82, 136));
        planNameLabel.setText("Plan Name:");

        planNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        planNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 82, 136), 2));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newDepositPlanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(planNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(planNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createFixedDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(newDepositPlanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(planNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(planNameLabel))
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(createFixedDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createFixedDepositPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFixedDepositPlanButtonActionPerformed
        try {
            String planName = planNameField.getText().trim();
            String principalText = principalAmountField.getText().trim();
            String rateText = interestRateField.getText().trim();
            String durationText = depositDurationField.getText().trim();
            Date startDate = startDateChooser.getDate();
            String selectedName = (String) goalComboBox.getSelectedItem();
            Goal selectedGoal = goalMap.get(selectedName);
            Integer goalId = selectedGoal != null ? selectedGoal.getGoalId() : 0;
            String depositDurationUnit = depositDurationComboBox.getSelectedItem().toString();
            String compoundingFrequency = compoundingFrequencyComboBox.getSelectedItem().toString();

            if (planName.isEmpty() || principalText.isEmpty() || rateText.isEmpty()
                    || durationText.isEmpty() || startDate == null || "Select Frequency".equals(depositDurationUnit)) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double principalAmount = Double.parseDouble(principalText);
            double interestRate = Double.parseDouble(rateText);
            int depositDuration = Integer.parseInt(durationText);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(startDate);

            DepositPlan depositPlan = new DepositPlan(planName, principalAmount, interestRate, depositDuration, depositDurationUnit,
                compoundingFrequency, formattedDate);
            if(goalId != 0)
            {
                depositPlan = new DepositPlan(planName, goalId, principalAmount, interestRate, depositDuration, depositDurationUnit,
                compoundingFrequency, formattedDate);
            }
            
            DepositPlanDAO depositDAO = new DepositPlanDAO();
            depositDAO.insert(depositPlan);
            
            InvestmentDAO investment = new InvestmentDAO();
            investment.calculateSQL();
            
            JOptionPane.showMessageDialog(this, "Deposit Plan created successfully.", "Creation Success", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            new Dashboard().setVisible(true);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "Format Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_createFixedDepositPlanButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void bankComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankComboBoxActionPerformed
        String bankSelected = bankComboBox.getSelectedItem().toString();
        
        switch (bankSelected) {
            case "BDO":
                interestRateField.setText("0.0625");
                break;
            case "BPI":
                interestRateField.setText("5.0");
                break;
            case "Metrobank":
                interestRateField.setText("3.8");
                break;
            case "Security Bank":
                interestRateField.setText("3.6");
                break;
            case "RCBC":
                interestRateField.setText("6.5");
                break;
            case "Maya Savings":
                interestRateField.setText("3.5");
                break;
            case "CIMB":
                interestRateField.setText("3.0");
                break;
            case "SeaBank":
                interestRateField.setText("4.0");
                break;
            case "Uno Digital Bank":
                interestRateField.setText("3.75");
                break;
            case "GoTyme Bank":
                interestRateField.setText("3.5");
                break;
        }
    }//GEN-LAST:event_bankComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButton backButton;
    private javax.swing.JComboBox<String> bankComboBox;
    private components.FrequencyComboBox compoundingFrequencyComboBox;
    private javax.swing.JLabel compoundingFrequencyLabel;
    private javax.swing.JLabel connectGoalLabel;
    private components.RoundedButton3 createFixedDepositPlanButton;
    private javax.swing.JComboBox<String> depositDurationComboBox;
    private javax.swing.JFormattedTextField depositDurationField;
    private javax.swing.JLabel depositDurationLabel;
    private javax.swing.JComboBox<String> goalComboBox;
    private javax.swing.JTextField interestRateField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel jLabel1;
    private components.DashboardMenuPanel leftPanel;
    private javax.swing.JLabel newDepositPlanLabel;
    private javax.swing.JTextField planNameField;
    private javax.swing.JLabel planNameLabel;
    private javax.swing.JFormattedTextField principalAmountField;
    private javax.swing.JLabel principalAmountLabel;
    private components.DashboardBackgroundPanel rightPanel;
    private components.RoundedPanel roundedPanel1;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel taxApplicableLabel;
    // End of variables declaration//GEN-END:variables
}
