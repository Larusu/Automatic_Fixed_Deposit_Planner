package dbcode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Goal;

public class GoalDAO extends CrudDAO<Goal>{

    @Override
    protected String getTableName() {
        return "goal";
    }

    @Override
    protected String getColumnName() {
        return "name, timeframe_value, timeframe_unit, price";
    }

    @Override
    protected ArrayList<Object> InsertData(Goal g) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(g.getName());
        fields.add(g.getTimeframeValue());
        fields.add(g.getTimeframeUnit());
        fields.add(g.getPrice());

        return fields;
    }

    ArrayList<Goal> getAllGoal()
    {
        ArrayList<Goal> goal = new ArrayList<>();

        try(Connection conn = DatabaseInitializer.connect();
        Statement stmt = conn.createStatement();)
        {
            String sql = "SELECT id, name FROM goal";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next())
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
