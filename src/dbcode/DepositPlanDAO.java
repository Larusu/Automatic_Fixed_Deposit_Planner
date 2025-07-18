package dbcode;

import java.util.ArrayList;

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
        return "user_id, goal_id, principal_amount, interest_rate, duration_value, duration_unit," +
                " compounding_frequency, start_date";
    }
    @Override
    protected ArrayList<Object> InsertData(DepositPlan d) 
    {
        ArrayList<Object> fields = new ArrayList<>();
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

}
