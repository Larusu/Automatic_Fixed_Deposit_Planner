package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:db/planner.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
