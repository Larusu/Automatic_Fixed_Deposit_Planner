package dbcode;

import java.util.ArrayList;

import model.Deposits;

public class DepositDAO extends CrudDAO<Deposits> {

    @Override
    protected String getTableName() {
        return "deposits";
    }

    @Override
    protected ArrayList<Object> InsertData(Deposits d) {

        ArrayList<Object> fields = new ArrayList<>();
        fields.add(d.getPrincipal());
        fields.add(d.getInterestRate());
        fields.add(d.getDurationValue());
        fields.add(d.getDurationUnit());
        fields.add(d.getCompoundingFrequency());
        fields.add(d.getStartDate());
        fields.add(d.getIsTaxApplied());

        return fields;
    }

    @Override
    protected String getColumnName() {
        return "principal_amount, interest_rate, duration_value, duration_unit," +
                " compounding_frequency, start_date, is_tax_applied";
    }

}
