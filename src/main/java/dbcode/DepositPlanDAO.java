package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.DepositPlan;
import session.Session;

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
    protected String whereClauseForGetAllData()
    {
        return "user_id";
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
    public List<Object[]> getAllData() throws SQLException
    {
        List<Object[]> data = new ArrayList<>();

        String sql = """
                        SELECT d.id, d.name, d.principal_amount, d.interest_rate, i.total_interest, i.estimated_tax, 
                               d.duration_value, d.duration_unit, g.name AS goal_name, d.start_date, i.maturity_date, 
                               i.maturity_amount 
                        FROM deposit_plan d
                        LEFT JOIN investments i ON i.deposit_id = d.id
                        LEFT JOIN goal g ON d.goal_id = g.id
                        WHERE d.user_id = ?;
                    """;

        try(Connection conn = DatabaseInitializer.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, Session.userId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Object[] row = new Object[11];

                row[0] = rs.getInt("id");
                row[1] = rs.getString("name");
                row[2] = "P" + rs.getString("principal_amount");
                row[3] = rs.getString("interest_rate");
                row[4] = "P" + rs.getString("total_interest");
                row[5] = "P" + rs.getString("estimated_tax");
                row[6] = rs.getString("duration_value") + " " 
                       + rs.getString("duration_unit");
                row[7] = rs.getString("goal_name");
                row[8] = rs.getString("start_date");
                row[9]= rs.getString("maturity_date");
                row[10] = "P" + rs.getString("maturity_amount");

                data.add(row);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, 
            "We couldn't retrieve all the data.\nPlease try again later.", 
            "Retrieving Failed", 
            JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return data;
    }
    
}
