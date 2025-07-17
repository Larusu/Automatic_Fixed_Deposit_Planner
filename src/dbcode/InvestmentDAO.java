package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import logic.InterestCalculator;
import model.Investment;

public class InvestmentDAO extends CrudDAO<Investment>{
    
     @Override
    protected String getTableName() {
        return "investments";
    }

    @Override
    protected String getColumnName() {
        return "deposit_id, maturity_date, maturity_amount, total_interest, estimated_tax";
    }

    @Override
    protected ArrayList<Object> InsertData(Investment i) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(i.getDepositId());
        fields.add(i.getMaturityDate());
        fields.add(i.getMaturityAmount());
        fields.add(i.getTotalInterest());
        fields.add(i.getEstimateTax());

        return fields;
    }

    public static void calculateSQL(int id)
    {
        
        try(Connection conn = DatabaseInitializer.connect();)
        {
            String sqlGetID = "SELECT id FROM deposit_plan ORDER BY id DESC LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(sqlGetID);
            ResultSet rsGetID = pstmt.executeQuery();

            int depositPlanId = rsGetID.getInt("id");
        }
        catch(SQLException e)
        {
            
        }

        InvestmentDAO.calculateSQL(id);
    }
}
