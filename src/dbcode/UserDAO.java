package dbcode;

import java.util.ArrayList;

import model.User;

public class UserDAO extends CrudDAO<User> {

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    protected String getColumnName() {
        return "username, email, password";
    }

    @Override
    protected ArrayList<Object> InsertData(User u) {

        ArrayList<Object> fields = new ArrayList<>();
        fields.add(u.getUsername());
        fields.add(u.getEmail());
        fields.add(u.getPassword());

        return fields;
    }

}
