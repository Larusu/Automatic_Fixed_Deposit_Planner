package dbcode;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.TimeReference.Frequency;
import model.DepositPlan;

public class DepositPlanDAO extends CrudDAO<DepositPlan> {

    @Override
    protected String getTableName() 
    {
        return "deposit_plan";
    }

    @Override
    protected String getColumnName() 
    {
        return "name, user_id, goal_id, principal_amount, interest_rate, duration_value, duration_unit," +
                " compounding_frequency, start_date";
    }
    @Override
    protected ArrayList<Object> InsertData(DepositPlan d) 
    {
        ArrayList<Object> fields = new ArrayList<>();
        fields.add(d.getName());
        fields.add(d.getUserId());
        fields.add(d.getGoalId() == 0 ? null : d.getGoalId());
        fields.add(d.getPrincipalAmount());
        fields.add(d.getInterestRate());
        fields.add(d.getDurationValue());
        fields.add(d.getDurationUnit());
        fields.add(d.getCompoundingFrequency());
        fields.add(d.getStartDate());

        return fields;
    }

    @Override
    public void insert(DepositPlan depositPlan) {

        int durationInMonths = (depositPlan.getDurationUnit().equalsIgnoreCase("months"))  
                        ? depositPlan.getDurationValue()
                        : depositPlan.getDurationValue() * 12;

        Frequency freq = Frequency.find(depositPlan.getCompoundingFrequency());

        if ((12 / freq.getFrequency()) > durationInMonths) {
            JOptionPane.showMessageDialog(null,
                "The compounding frequency is longer than the deposit plan duration.",
                "Invalid Compounding Frequency",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        super.insert(depositPlan);
    }
}
