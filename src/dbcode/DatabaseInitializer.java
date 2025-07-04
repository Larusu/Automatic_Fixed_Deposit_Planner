package dbcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    static final String DB_URL = "jdbc:sqlite:db/database.db";

    public static Connection connect(){

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("PRAGMA foreign_keys = ON"); // to enable foreign key
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void initializeDatabase(){

        try(Connection conn = connect(); 
            Statement stmt = conn.createStatement();)
        { 
            String deposits = "CREATE TABLE IF NOT EXISTS deposits(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "principal_amount REAL NOT NULL," +
            "interest_rate REAL NOT NULL," +
            "duration_value INTEGER NOT NULL," +
            "duration_unit TEXT NOT NULL," +
            "compounding_frequency TEXT NOT NULL," +
            "start_date TEXT NOT NULL," +
            "is_tax_applied INTEGER NOT NULL);";

            String investments = "CREATE TABLE IF NOT EXISTS investments(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "deposit_id INTEGER NOT NULL, " +
            "maturity_amount REAL NOT NULL, " +
            "total_interest REAL NOT NULL, " +
            "estimated_tax REAL NOT NULL, " +
            "FOREIGN KEY (deposit_id) REFERENCES deposits(id) ON DELETE CASCADE);";

            String maturity_schedule = "CREATE TABLE IF NOT EXISTS maturity_schedule(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "investment_id INTEGER NOT NULL, " +
            "period_number INTEGER NOT NULL, " +
            "date TEXT NOT NULL, " +
            "interest_earned REAL NOT NULL, " +
            "tax_deducted REAL NOT NULL, " +
            "total_balance REAL NOT NULL, " +
            "FOREIGN KEY (investment_id) REFERENCES investments(id) ON DELETE CASCADE);";

            stmt.executeUpdate(deposits);
            stmt.executeUpdate(investments);
            stmt.executeUpdate(maturity_schedule);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
