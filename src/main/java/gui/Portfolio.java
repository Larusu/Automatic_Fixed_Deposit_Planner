package gui;

import dbcode.DepositPlanDAO;
import dbcode.GoalDAO;
import dbcode.InvestmentDAO;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Portfolio extends javax.swing.JFrame {
    
    public void loadDataDepositPlan() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
            "ID", "Plan", "Principal", "Rate", "Interest", "Tax", "Duration", "Goal", "Start", "Maturity", "Total"
        });

        DepositPlanDAO depositDAO = new DepositPlanDAO();

        try {
            List<Object[]> data = depositDAO.getAllData();
            for (Object[] row : data) {
                model.addRow(row);
            }

            depositPlanTable.setModel(model);

            if (depositPlanTable instanceof components.CustomJTable) {
                ((components.CustomJTable) depositPlanTable).customizeAppearance();
            }

        } catch (SQLException er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load data from database.");
        }
    }
    
    public void loadDataGoal() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
             "ID", "Goal", "Duration", "Price"
        });

        GoalDAO goal = new GoalDAO();

        try {
            List<Object[]> data = goal.getAllData();
            for (Object[] row : data) {
                model.addRow(row);
            }

            goalTable.setModel(model);

            if (goalTable instanceof components.CustomJTable) {
                ((components.CustomJTable) goalTable).customizeAppearance();
            }

        } catch (SQLException er) {
            er.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load data from database.");
        }
    }

    public Portfolio() {
        initComponents();
        setLocationRelativeTo(null);
        loadDataDepositPlan();
        loadDataGoal();
        
        portfolioLabel.setFont(FontLoader.loadFont("agrandir_wide_bold.otf", Font.PLAIN, 40f));
        backButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        addDepositPlanButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        deleteDepositPlanButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        addGoalButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        deleteGoalButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        showDepositPlansButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
        showGoalsButton.setFont(FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 16f));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new components.DashboardMenuPanel();
        backButton = new components.RoundedButton();
        jLabel1 = new javax.swing.JLabel();
        rightPanel = new components.DashboardBackgroundPanel();
        parentPanel = new javax.swing.JPanel();
        portfolioLabel = new javax.swing.JLabel();
        showDepositPlansButton = new components.RoundedButton3();
        showGoalsButton = new components.RoundedButton3();
        tablePanels = new components.DashboardBackgroundPanel();
        goalsPanel = new components.DashboardBackgroundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        goalTable = new components.CustomJTable();
        addGoalButton = new components.RoundedButton2();
        deleteGoalButton = new components.RoundedButton2();
        depositPlansPanel = new components.DashboardBackgroundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        depositPlanTable = new components.CustomJTable();
        addDepositPlanButton = new components.RoundedButton2();
        deleteDepositPlanButton = new components.RoundedButton2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fixed Deposit Planner");

        leftPanel.setPreferredSize(new java.awt.Dimension(200, 700));

        backButton.setForeground(new java.awt.Color(47, 90, 166));
        backButton.setText("BACK\n");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard_logo.png"))); // NOI18N

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setPreferredSize(new java.awt.Dimension(850, 700));
        rightPanel.setLayout(new java.awt.BorderLayout());

        parentPanel.setBackground(new java.awt.Color(204, 204, 204));
        parentPanel.setPreferredSize(new java.awt.Dimension(850, 150));

        portfolioLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        portfolioLabel.setForeground(new java.awt.Color(43, 82, 136));
        portfolioLabel.setText("Portfolio");

        showDepositPlansButton.setText("Deposit Plans");
        showDepositPlansButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDepositPlansButtonActionPerformed(evt);
            }
        });

        showGoalsButton.setText("Goals");
        showGoalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGoalsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(portfolioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(parentPanelLayout.createSequentialGroup()
                        .addComponent(showDepositPlansButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showGoalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(468, Short.MAX_VALUE))
        );
        parentPanelLayout.setVerticalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(portfolioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showDepositPlansButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showGoalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        rightPanel.add(parentPanel, java.awt.BorderLayout.PAGE_START);

        tablePanels.setPreferredSize(new java.awt.Dimension(850, 550));
        tablePanels.setLayout(new java.awt.CardLayout());

        goalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(goalTable);

        addGoalButton.setText("ADD");
        addGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGoalButtonActionPerformed(evt);
            }
        });

        deleteGoalButton.setText("DELETE");
        deleteGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGoalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout goalsPanelLayout = new javax.swing.GroupLayout(goalsPanel);
        goalsPanel.setLayout(goalsPanelLayout);
        goalsPanelLayout.setHorizontalGroup(
            goalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goalsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, goalsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(deleteGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        goalsPanelLayout.setVerticalGroup(
            goalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goalsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(goalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteGoalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        tablePanels.add(goalsPanel, "card2");

        depositPlanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(depositPlanTable);

        addDepositPlanButton.setText("ADD");
        addDepositPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepositPlanButtonActionPerformed(evt);
            }
        });

        deleteDepositPlanButton.setText("DELETE");
        deleteDepositPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDepositPlanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout depositPlansPanelLayout = new javax.swing.GroupLayout(depositPlansPanel);
        depositPlansPanel.setLayout(depositPlansPanelLayout);
        depositPlansPanelLayout.setHorizontalGroup(
            depositPlansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositPlansPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depositPlansPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(deleteDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        depositPlansPanelLayout.setVerticalGroup(
            depositPlansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositPlansPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(depositPlansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteDepositPlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        tablePanels.add(depositPlansPanel, "card2");

        rightPanel.add(tablePanels, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void showDepositPlansButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDepositPlansButtonActionPerformed
        tablePanels.removeAll();
        tablePanels.add(depositPlansPanel);
        tablePanels.repaint();
        tablePanels.revalidate();
    }//GEN-LAST:event_showDepositPlansButtonActionPerformed

    private void deleteDepositPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDepositPlanButtonActionPerformed
        int selectedRow = depositPlanTable.getSelectedRow();
    
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) depositPlanTable.getModel();
        int id = (int) model.getValueAt(selectedRow, 0); 
        
        InvestmentDAO investment = new InvestmentDAO();
        investment.delete(id);
        DepositPlanDAO depositDAO = new DepositPlanDAO();
        depositDAO.delete(id);
        JOptionPane.showMessageDialog(this, "Plan successfully deleted.", "Deleted Successfully!", JOptionPane.INFORMATION_MESSAGE);
        
        loadDataDepositPlan();
    }//GEN-LAST:event_deleteDepositPlanButtonActionPerformed

    private void deleteGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGoalButtonActionPerformed
        int selectedRow = goalTable.getSelectedRow();
    
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) goalTable.getModel();
        int id = (int) model.getValueAt(selectedRow, 0); 
        
        try {
            GoalDAO goalDAO = new GoalDAO();
            goalDAO.delete(id);
        } catch (RuntimeException e) {
            if (e.getMessage().toLowerCase().contains("foreign key")) {
            JOptionPane.showMessageDialog(null, 
            "Please delete the existing plan first.\nThen try again.", 
            "Delete Failed", 
            JOptionPane.ERROR_MESSAGE);
            return;
            } else {
            JOptionPane.showMessageDialog(null, 
                "We couldn't delete the item.\nPlease try again later.", 
                "Delete Failed", 
                JOptionPane.ERROR_MESSAGE);
            return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "Goal successfully deleted.", "Deleted Successfully!", JOptionPane.INFORMATION_MESSAGE);
        
        loadDataGoal();
    }//GEN-LAST:event_deleteGoalButtonActionPerformed

    private void showGoalsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGoalsButtonActionPerformed
        tablePanels.removeAll();
        tablePanels.add(goalsPanel);
        tablePanels.repaint();
        tablePanels.revalidate();
    }//GEN-LAST:event_showGoalsButtonActionPerformed

    private void addDepositPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepositPlanButtonActionPerformed
        new CreateFixedDepositForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addDepositPlanButtonActionPerformed

    private void addGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGoalButtonActionPerformed
        new CreateGoalForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addGoalButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedButton2 addDepositPlanButton;
    private components.RoundedButton2 addGoalButton;
    private components.RoundedButton backButton;
    private components.RoundedButton2 deleteDepositPlanButton;
    private components.RoundedButton2 deleteGoalButton;
    private components.CustomJTable depositPlanTable;
    private components.DashboardBackgroundPanel depositPlansPanel;
    private components.CustomJTable goalTable;
    private components.DashboardBackgroundPanel goalsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private components.DashboardMenuPanel leftPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JLabel portfolioLabel;
    private components.DashboardBackgroundPanel rightPanel;
    private components.RoundedButton3 showDepositPlansButton;
    private components.RoundedButton3 showGoalsButton;
    private components.DashboardBackgroundPanel tablePanels;
    // End of variables declaration//GEN-END:variables
}
