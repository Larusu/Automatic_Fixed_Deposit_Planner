package dbcode;

import java.util.ArrayList;

import model.Investment;

public class InvestmentDAO extends CrudDAO<Investment>{

    @Override
    protected String getTableName() {
        return "investments";
    }

    @Override
    protected String getColumnName() {
        return "deposit_id, maturity_amount, total_interest, estimated_tax";
    }

    @Override
    protected ArrayList<Object> InsertData(Investment i) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(i.getDepositId());
        fields.add(i.getMaturityAmount());
        fields.add(i.getTotalInterest());
        fields.add(i.getEstimateTax());

        return fields;
    }
}
