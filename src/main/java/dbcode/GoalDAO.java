package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    protected ArrayList<Object> InsertData(Goal g) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(g.getUserId());
        fields.add(g.getName());
        fields.add(g.getTimeframeValue());
        fields.add(g.getTimeframeUnit());
        fields.add(g.getPrice());

        return fields;
    }

    public ArrayList<Goal> getAllGoals()
    {
        ArrayList<Goal> goal = new ArrayList<>();
        String sql = "SELECT id, name FROM goal WHERE user_id = ?";

        try(Connection conn = DatabaseInitializer.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setInt(1, Session.userId);
            ResultSet rs = pstmt.executeQuery(sql);
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
}
