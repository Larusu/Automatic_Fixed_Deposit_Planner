package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                
            pstmt.setDouble(1, (Double)fields.get(0));
            pstmt.setDouble(2, (Double)fields.get(1));
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

    public String getDepositSpecificField(int id, String columnName){
        // Returning a specific data from a specific field 
        if (checkColumnName(columnName)) return null; 

        String sql = "SELECT " + columnName + " FROM deposits WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            ResultSet field = pstmt.executeQuery();
            
            if(field.next()){
                return String.valueOf(field.getString(columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDepositField(int id){

        String depositField = "";
        String sql = "SELECT * FROM deposits WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            ResultSet field = pstmt.executeQuery();
            
            if(field.next()){
                for(int i = 1; i < 8; i++){
                    depositField += String.valueOf(field.getString(i)) + " ";
                }
                depositField += String.valueOf(field.getString(8));
            }

            return depositField;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateDepositField(int id, ArrayList<String> columnName, ArrayList<Object> newValue){
        // Updating specified column with new values
        if (columnName.size() != newValue.size()) {
            System.out.println("Mismatch between column names and values.");
            return;
        }

        StringBuilder fields = new StringBuilder();
        for(int i = 0; i < columnName.size(); i++){
            if (checkColumnName(columnName.get(i)))  return; 
            
            fields.append(columnName.get(i)).append(" = ?");
            if (i < columnName.size() - 1) {
                fields.append(", ");
            }
        }

        String sql = "UPDATE deposits SET " + fields + "  WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            for(int i = 0; i < newValue.size(); i++){
                if(newValue.get(i) instanceof Integer){
                    pstmt.setInt(i + 1, (Integer)newValue.get(i));
                }else if(newValue.get(i) instanceof Double){
                    pstmt.setDouble(i + 1, (Double)newValue.get(i));
                }
                else if(newValue.get(i) instanceof String){
                    pstmt.setString(i + 1, String.valueOf(newValue.get(i)));
                }
            }
            pstmt.setInt(columnName.size() + 1, id);
            pstmt.executeUpdate();

            System.out.println("Updated row with id " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private boolean checkColumnName(String columnName){

        List<String> allowedColumns = Arrays.asList(
            "principal_amount", "interest_rate", "duration_value", "duration_unit",
            "compounding_frequency", "start_date", "estimate_tax"
        );
        
        if (!allowedColumns.contains(columnName)) {
            System.out.println("Invalid column name: " + columnName);
            return true;
        }
        return false;
    }
}
