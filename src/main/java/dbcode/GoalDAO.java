package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.Goal;
import session.Session;

public class GoalDAO extends CrudDAO<Goal>{

    @Override
    protected String getTableName() {
        return "goal";
    }

    @Override
    protected String getColumnName() {
        return "user_id, name, timeframe_value, timeframe_unit, price";
    }

    @Override
    protected String whereClauseForGetAllData()
    {
        return "user_id";
    }

    @Override
    protected ArrayList<Object> InsertData(Goal g) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(g.getUserId());
        fields.add(g.getName());
        fields.add(g.getTimeframeValue());
        fields.add(g.getTimeframeUnit());
        fields.add(g.getPrice());

        return fields;
    }

    @Override
    public void delete(int id) {
        // Deleting an entire row based on the id
        String sqlDelete = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
                PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Deleted row from " + getTableName() + " where id = " + id);
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();       
            String sqlState = e.getSQLState();      
            String errorMsg = e.getMessage().toLowerCase();
            if(errorCode == 1451 || "23000".equals(sqlState) || errorMsg.contains("foreign key"))
            {
                throw new RuntimeException("Foreign key constraint violation: Please delete related records first.");
            }
            e.printStackTrace();
            throw new RuntimeException("We couldn't delete the item.\nPlease try again later.", e);
        }
    }
    
    public ArrayList<Goal> getAllGoals()
    {
        ArrayList<Goal> goal = new ArrayList<>();
        String sql = "SELECT id, name FROM goal WHERE user_id = ?";

        try(Connection conn = DatabaseInitializer.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setInt(1, Session.userId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                goal.add(new Goal(id, name));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Couldn't get goal names.");
            return null;
        }

        return goal;
    }
    
    @Override
    public List<Object[]> getAllData() throws SQLException
    {
        List<Object[]> data = new ArrayList<>();
        
        String sql = "SELECT id, name, timeframe_value, timeframe_unit, price FROM " + getTableName() + " WHERE user_id = ?";
        try(Connection conn = DatabaseInitializer.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setInt(1, Session.userId);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                Object[] row = new Object[4];
                row[0] = rs.getInt("id");
                row[1] = rs.getString("name");
                row[2] = rs.getString("timeframe_value") + " " + rs.getString("timeframe_unit");
                row[3] = "P" + rs.getString("price");
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
