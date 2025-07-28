package dbcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static final String MYSQL_ROOT_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/planner_db"; // xampp
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    static Connection connect() throws SQLException
    {
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return conn;
    }

    private static void createDatabaseIfNotExists() throws SQLException
    {
        try(Connection conn = DriverManager.getConnection(MYSQL_ROOT_URL, USERNAME, PASSWORD); 
            Statement stmt = conn.createStatement())
        {
            String sql = "CREATE DATABASE IF NOT EXISTS planner_db;";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new SQLException("Failed to create database", e);
        }
    }

    public static void initializeDatabase()
    {
        try 
        {
            createDatabaseIfNotExists();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database", e);
        }

        try(Connection conn = connect(); 
            Statement stmt = conn.createStatement();)
        { 
            String users = """
                CREATE TABLE IF NOT EXISTS user ( 
                id INT PRIMARY KEY AUTO_INCREMENT,
                username VARCHAR(99) NOT NULL,
                email VARCHAR(99) NOT NULL UNIQUE,
                password VARCHAR(99) NOT NULL
                );
            """;
            
            String goal = """
                CREATE TABLE IF NOT EXISTS goal (
                id INT PRIMARY KEY AUTO_INCREMENT,
                user_id INT NOT NULL,
                name VARCHAR(255) NOT NULL,
                timeframe_value INT NOT NULL,
                timeframe_unit TEXT NOT NULL,
                price DECIMAL(10, 2) NOT NULL,
                FOREIGN KEY (user_id) REFERENCES user(id)
                );
            """;

            String deposit = """ 
                CREATE TABLE IF NOT EXISTS deposit_plan (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(99) NOT NULL,
                user_id INT NOT NULL,
                goal_id INT,
                principal_amount DECIMAL(10, 2) NOT NULL,
                interest_rate DECIMAL(10, 2) NOT NULL,
                duration_value INT NOT NULL,
                duration_unit TEXT NOT NULL,
                compounding_frequency TEXT NOT NULL,
                start_date TEXT NOT NULL,
                FOREIGN KEY (user_id) REFERENCES user(id),
                FOREIGN KEY (goal_id) REFERENCES goal(id)
                );      
            """;

            String investments ="""
                CREATE TABLE IF NOT EXISTS investments (
                id INT PRIMARY KEY AUTO_INCREMENT,
                deposit_id INT NOT NULL,
                maturity_date TEXT NOT NULL,
                maturity_amount DECIMAL(10, 2) NOT NULL,
                total_interest DECIMAL(10, 2) NOT NULL,
                estimated_tax DECIMAL(10, 2) NOT NULL,
                FOREIGN KEY (deposit_id) REFERENCES deposit_Plan(id)
                );
            """;

            stmt.executeUpdate(users);
            stmt.executeUpdate(goal);
            stmt.executeUpdate(deposit);
            stmt.executeUpdate(investments);
            
        }catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    static void ResetDB(String columnName)
    {
        String sql = "DROP TABLE IF EXISTS ";
        switch (columnName.toLowerCase()) 
        {
            case "investments":
                sql += "investments;";
                break;
            case "goal":
                sql += "investments, deposit_plan, goal;";
                break;
            case "depositplan":
                sql += "investments, deposit_plan;";
                break;
            case "user":
                sql += "investments, deposit_plan, goal, user;";
                break;
            default:
                return;
        }
        
        try(Connection conn = connect();
        Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        initializeDatabase();
    }
}