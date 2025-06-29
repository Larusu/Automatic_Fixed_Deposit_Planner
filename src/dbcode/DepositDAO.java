package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepositDAO {

    // column: id, principal_amount, interest_rate, duration_value, duration_unit,
    //         compounding_frequency, start_date, estimate_tax

    public void insertDepositField(ArrayList<Object> fields){
        // Inserting data on Deposit table
        if(fields.size() != 7 || !(fields.get(2) instanceof Integer) || !(fields.get(6) instanceof Integer)){
            System.err.println("Error on insertDepositField()"); 
            return;
        }
        String sqlInsert = "INSERT INTO deposits(" +
            "principal_amount, interest_rate, duration_value, duration_unit," +
            "compounding_frequency, start_date, estimate_tax) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert)){
                
            pstmt.setString(1, String.valueOf(fields.get(0)));
            pstmt.setString(2, String.valueOf(fields.get(1)));
            pstmt.setInt(3, (Integer)fields.get(2));
            pstmt.setString(4, String.valueOf(fields.get(3)));
            pstmt.setString(5, String.valueOf(fields.get(4)));
            pstmt.setString(6, String.valueOf(fields.get(5)));
            pstmt.setInt(7, (Integer)fields.get(6));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getDepositField(int id, String column){
        // Returning a specific data from a specific field
        


        return null;
    }
    public void updateDepositField(int id, String column, Object newValue){

    }

    public void deleteDepositById(int id){
        // Deleting an entire row based on the id
        String sqlDelete = "DELETE FROM deposits WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete)){

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Deleted row on deposit table from id " + id);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void resetDepositTable(){
        // Reseting the entire deposit table by deleting and creating
        String sqlDelete = "DROP TABLE deposits";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete)){
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        DatabaseInitializer.initializeDatabase();
    }
}
