package dbcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DepositDAO {
    
    public void insertDepositField(int id, String what, Object value){

        try (Connection conn = DatabaseInitializer.connect();
            Statement stmt = conn.createStatement()){

            String sqlInsert = "INSERT INTO deposits(" + what + ")VALUES(?)";
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getDepositField(int id, String field){

    }
    public void updateDepositField(int id, String field, Object newValue){

    }
    public void deleteDepositById(int id){

    }
}
