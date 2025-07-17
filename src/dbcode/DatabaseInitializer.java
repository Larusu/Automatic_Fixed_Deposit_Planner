package dbcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    static final String DB_URL = "jdbc:mysql://localhost:3306/planner_db"; // xampp
    static final String Username = "root";
    static final String Password = "";

    public static Connection connect()
    {
        try 
        {
            Connection conn = DriverManager.getConnection(DB_URL, Username, Password);
            return conn;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void initializeDatabase()
    {
        try(Connection conn = connect(); 
            Statement stmt = conn.createStatement();)
        { 
            String users = "CREATE TABLE IF NOT EXISTS User (" +  
                        "    id INT PRIMARY KEY AUTO_INCREMENT," + 
                        "    username VARCHAR(99) NOT NULL," + 
                        "    email VARCHAR(99) NOT NULL UNIQUE," + 
                        "    password VARCHAR(99) NOT NULL" + 
                        "    );";
            
            String goal = "CREATE TABLE IF NOT EXISTS Goal (" + 
                        "    id INT PRIMARY KEY AUTO_INCREMENT," + 
                        "    name VARCHAR(255) NOT NULL," + 
                        "    timeframe_value INT NOT NULL," + 
                        "    timeframe_unit TEXT NOT NULL," + 
                        "    price DECIMAL(10, 2) NOT NULL" + 
                        "    );";

            String deposit = "CREATE TABLE IF NOT EXISTS Deposit_Plan (" + 
                            "    id INT PRIMARY KEY AUTO_INCREMENT," + 
                            "    user_id INT NOT NULL," + 
                            "    goal_id INT," + 
                            "    principal_amount DECIMAL(10, 2) NOT NULL," + 
                            "    interest_rate DECIMAL(10, 2) NOT NULL," + 
                            "    duration_value INT NOT NULL," + 
                            "    duration_unit TEXT NOT NULL," + 
                            "    compounding_frequency TEXT NOT NULL," + 
                            "    start_date TEXT NOT NULL," + 
                            "    FOREIGN KEY (user_id) REFERENCES User(id)," + 
                            "    FOREIGN KEY (goal_id) REFERENCES Goal(id)" + 
                            "    );";

                String investments = "CREATE TABLE IF NOT EXISTS Investments (" +
                                    "    id INT PRIMARY KEY AUTO_INCREMENT," +
                                    "    deposit_id INT NOT NULL," +
                                    "    maturity_date TEXT NOT NULL," +
                                    "    maturity_amount DECIMAL(10, 2) NOT NULL," +
                                    "    total_interest DECIMAL(10, 2) NOT NULL," +
                                    "    estimated_tax DECIMAL(10, 2) NOT NULL," +
                                    "    FOREIGN KEY (deposit_id) REFERENCES Deposit_Plan(id)" +
                                    ");";

            stmt.executeUpdate(users);
            stmt.executeUpdate(goal);
            stmt.executeUpdate(deposit);
            stmt.executeUpdate(investments);
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
