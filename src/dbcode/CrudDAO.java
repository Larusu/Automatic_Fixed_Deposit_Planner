package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class CrudDAO<T> {

    protected abstract String getTableName();
    protected abstract String getColumnName();
    protected abstract ArrayList<Object> InsertData(T elements);
    
    public void insert(T elements){

        ArrayList<Object> data = InsertData(elements);
        int sizeOfData = data.size();

        String sqlInsert = "INSERT INTO " + getTableName() + " (" + getColumnName() 
        + ") VALUES(" + getPlaceholder(sizeOfData) + ")";

        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert)){

            for(int i = 0; i < sizeOfData; i++){
                pstmt.setObject(i + 1, data.get(i));
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getField(int id, String column){
         // Returning a specific data from a specific field
        if (validateColumnName(column)) return "Invalid column name"; 

        String sql = "SELECT " + column + " FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            ResultSet field = pstmt.executeQuery();
            
            if(field.next()){
                return field.getString(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDepositField(int id, ArrayList<String> columnName, ArrayList<Object> newValue){
        // Updating specified column with new values
        if ((columnName.size() != newValue.size()) || validateColumnName(columnName)) {
            System.err.println("Error input on updateDepositField()");
            return;
        }
        String sqlUpdate = "UPDATE " + getTableName() +" SET " + getPlaceholder(columnName) + "  WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)){

            for(int i = 0; i < newValue.size(); i++){
                pstmt.setObject(i + 1, newValue.get(i));
            }
            pstmt.executeUpdate();

            System.out.println("Updated row with id " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        // Deleting an entire row based on the id
        String sqlDelete = "DELETE FROM " + getTableName() +  " WHERE id = ?";
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete)){

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Deleted row from " + getTableName() + " where id = " + id);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void reset(){
        // Reseting the entire deposit table by deleting the table and creating it again
        String sqlReset = "DROP TABLE " + getTableName();
        try (Connection conn = DatabaseInitializer.connect();
            PreparedStatement pstmt = conn.prepareStatement(sqlReset)){
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        DatabaseInitializer.initializeDatabase();
    }

    private boolean validateColumnName(String columnName){
        // Validation for developers to check their syntax
        String allowedColumns[] = getColumnName().split(",");
        for(int i = 0; i < allowedColumns.length; i++){
            if(columnName.trim().equals(allowedColumns[i].trim())){
                return true;
            }
        }
        return false;
    }
    private boolean validateColumnName(ArrayList<String> arrayList){
        // Validation for developers to check their syntax
        String allowedColumns[] = getColumnName().split(",");
        for(String array : arrayList){
            for(String allow : allowedColumns){
                if(array.trim().equals(allow.trim())){
                    return true;
                }
            }
        }
        return false;
    }
    private String getPlaceholder(int size){

        String placeholder = "";
        for(int i = 0; i < size; i++){
            placeholder += "?,";
        }
        return placeholder.substring(0, placeholder.length() - 1);
    }
    private String getPlaceholder(ArrayList<String> arrayList){

        String placeholder = "";
        for(int i = 0; i < arrayList.size(); i++){
            placeholder += arrayList.get(i) + " = ?, ";
        }
        return placeholder.substring(0, placeholder.length() - 2);
    }
}
