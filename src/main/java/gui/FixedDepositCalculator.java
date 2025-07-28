package gui;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import logic.InterestCalculator;
import logic.TimeReference;

public class FixedDepositCalculator extends javax.swing.JFrame {

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
        
    public FixedDepositCalculator() {
        initComponents();
        setLocationRelativeTo(null);
        
        calculatorLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 50f));
        maturityAmountLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        calculatedField.setFont(FontLoader.loadFont("league_gothic_regular", Font.ITALIC, 40f));
        principalAmountLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD,20f));
        principalAmountField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        interestRateLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        interestRateField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        depositDurationLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        depositDurationField.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 16f));
        depositDurationComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        compoundingFrequencyLabel.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 20f));
        compoundingFrequencyComboBox.setFont(FontLoader.loadFont("league_gothic_regular", Font.BOLD, 11f));
        backButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        calculateButton.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 18f));
        calculateButton.setVerticalAlignment(SwingConstants.CENTER);
        calculateButton.setMargin(new Insets(20,10,10,10));
    }
    
    private void initComponents() {

        leftPanel = new components.DashboardMenuPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new components.RoundedButton();
        rightPanel = new components.DashboardBackgroundPanel();
        calculatorLabel = new javax.swing.JLabel();
        roundedPanel1 = new components.RoundedPanel();
        principalAmountLabel = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        depositDurationLabel = new javax.swing.JLabel();
        depositDurationComboBox = new javax.swing.JComboBox<>();
        depositDurationField = new javax.swing.JFormattedTextField();
        principalAmountField = new javax.swing.JFormattedTextField();
        compoundingFrequencyLabel = new javax.swing.JLabel();
        compoundingFrequencyComboBox = new components.FrequencyComboBox();
        applyTaxLabel = new javax.swing.JLabel();
        interestRateField = new javax.swing.JFormattedTextField();
        taxAppliedCheckBox = new javax.swing.JCheckBox();
        calculatedField = new javax.swing.JTextField();
        calculateButton = new components.RoundedButton();
        maturityAmountLabel = new javax.swing.JLabel();

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
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setPreferredSize(new java.awt.Dimension(808, 700));

        calculatorLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 80)); // NOI18N
        calculatorLabel.setForeground(new java.awt.Color(43, 82, 136));
        calculatorLabel.setText("Calculator");

        roundedPanel1.setBackground(new java.awt.Color(47, 90, 166));

        principalAmountLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        principalAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        principalAmountLabel.setText("Principal Amount:");

        interestRateLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        interestRateLabel.setForeground(new java.awt.Color(255, 255, 255));
        interestRateLabel.setText("Interest Rate (%):");

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
        compoundingFrequencyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compoundingFrequencyComboBoxActionPerformed(evt);
            }
        });

        applyTaxLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        applyTaxLabel.setForeground(new java.awt.Color(255, 255, 255));
        applyTaxLabel.setText("Apply Tax:");

        interestRateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        interestRateField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        calculatedField.setEditable(false);
        calculatedField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        calculateButton.setForeground(new java.awt.Color(47, 90, 166));
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        maturityAmountLabel.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        maturityAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        maturityAmountLabel.setText("Maturity Amount:");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(maturityAmountLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(applyTaxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(taxAppliedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calculatedField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(principalAmountLabel)
                                    .addComponent(depositDurationLabel)
                                    .addComponent(compoundingFrequencyLabel)
                                    .addComponent(interestRateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(interestRateField)
                                            .addComponent(depositDurationField, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(depositDurationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(principalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(compoundingFrequencyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(32, 32, 32))))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(maturityAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calculatedField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(principalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(principalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interestRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(applyTaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxAppliedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(calculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculatorLabel)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(calculatorLabel)
                .addGap(26, 26, 26)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void compoundingFrequencyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compoundingFrequencyComboBoxActionPerformed
        String selectedCompoundingFrequency = (String) compoundingFrequencyComboBox.getSelectedItem();

        if (selectedCompoundingFrequency != null && selectedCompoundingFrequency.equals("Select Compounding Frequency")) {
            return;
        } else {
            if (compoundingFrequencyComboBox.getItemAt(0).equals("Select Compounding Frequency")) {
                compoundingFrequencyComboBox.removeItemAt(0);
            }
        }
    }//GEN-LAST:event_compoundingFrequencyComboBoxActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        try {
            String principalText = principalAmountField.getText().trim();
            String rateText = interestRateField.getText().trim();
            String durationText = depositDurationField.getText().trim();
            String depositDurationUnit = depositDurationComboBox.getSelectedItem().toString();
            String compoundingFrequency = compoundingFrequencyComboBox.getSelectedItem().toString();

            if (principalText.isEmpty() || rateText.isEmpty() || durationText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double principalAmount = Double.parseDouble(principalText);
            double interestRate = Double.parseDouble(rateText);
            int depositDuration = Integer.parseInt(durationText);
            
            TimeReference.Frequency freqEnum = TimeReference.Frequency.find(compoundingFrequency);
            TimeReference.DurationUnit durationEnum = TimeReference.DurationUnit.find(depositDurationUnit);
            double durationInYears = durationEnum.toYears(depositDuration);
            
            boolean taxApplied = taxAppliedCheckBox.isSelected();
            
            System.out.println(depositDuration);
            System.out.println(freqEnum);
            
            InterestCalculator calc = new InterestCalculator();
            
            double calculated;
            
            if (taxApplied) {
                calculated = calc.maturityAmountWithTax(principalAmount, interestRate, freqEnum, durationInYears);
            } else {
                calculated = calc.maturityAmount(principalAmount, interestRate, freqEnum, durationInYears);
            }
            
            String maturityAmount = String.valueOf(calculated);
            calculatedField.setText(maturityAmount);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "Format Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_calculateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applyTaxLabel;
    private components.RoundedButton backButton;
    private components.RoundedButton calculateButton;
    private javax.swing.JTextField calculatedField;
    private javax.swing.JLabel calculatorLabel;
    private components.FrequencyComboBox compoundingFrequencyComboBox;
    private javax.swing.JLabel compoundingFrequencyLabel;
    private javax.swing.JComboBox<String> depositDurationComboBox;
    private javax.swing.JFormattedTextField depositDurationField;
    private javax.swing.JLabel depositDurationLabel;
    private javax.swing.JFormattedTextField interestRateField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel jLabel1;
    private components.DashboardMenuPanel leftPanel;
    private javax.swing.JLabel maturityAmountLabel;
    private javax.swing.JFormattedTextField principalAmountField;
    private javax.swing.JLabel principalAmountLabel;
    private components.DashboardBackgroundPanel rightPanel;
    private components.RoundedPanel roundedPanel1;
    private javax.swing.JCheckBox taxAppliedCheckBox;
    // End of variables declaration//GEN-END:variables
}
