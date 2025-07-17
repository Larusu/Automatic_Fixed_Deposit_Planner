package dbcode;

import java.util.ArrayList;

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
}
