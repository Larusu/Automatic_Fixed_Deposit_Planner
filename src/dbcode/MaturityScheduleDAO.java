package dbcode;

import java.util.ArrayList;

import model.MaturityEntry;

public class MaturityScheduleDAO extends CrudDAO<MaturityEntry> {

    @Override
    protected String getTableName() {
        return "maturity_schedule";
    }

    @Override
    protected String getColumnName() {
        return "investment_id, period_number, date, interest_earned, tax_deducted, total_balance";
    }

    @Override
    protected ArrayList<Object> InsertData(MaturityEntry m) {

        ArrayList<Object> fields = new ArrayList<>();
        fields.add(m.getInvestmentId());
        fields.add(m.getPeriodNumber());
        fields.add(m.getDate());
        fields.add(m.getInterestEarned());
        fields.add(m.getTaxDeducted());
        fields.add(m.getTotalBalance());

        return fields;
    }

}
