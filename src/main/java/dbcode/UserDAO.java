package dbcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.User;
import session.Session;

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

    public void register(User element)
    {
        String email = element.getEmail();
        String checkSQL = "SELECT email FROM user WHERE email = ?";

        try(Connection conn = DatabaseInitializer.connect();
        PreparedStatement pstmt = conn.prepareStatement(checkSQL);)
        {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                System.err.println("Email " + email + " already registered");
                JOptionPane.showMessageDialog(null, 
                "The email " + email + " is already registered.", 
                "Email Already In use!", 
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println("Register successful!");
            this.insert(element);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, 
            "An error occurred while registering the user. Please try again later.", 
            "Registration Error", 
            JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void login(User element)
    {
        String email = element.getEmail();
        String password = element.getPassword();
        String sql = "SELECT password, id FROM user WHERE email = ?";

        try(Connection conn = DatabaseInitializer.connect();
        PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next())
            {
                System.err.println("No account with that email");
                JOptionPane.showMessageDialog(null,
                "No account found with that email.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

            String storedPassword = rs.getString("password");

            if(!storedPassword.equals(password))
            {
                System.err.println("Incorrect password!");
                JOptionPane.showMessageDialog(null,
                "Incorrect password. Please try again.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

            // for changing session's user
            int id = rs.getInt("id");
            Session.userId = id;

            System.out.println("Login successfully!");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
            "An error occurred while logging in. Please try again later.",
            "Login Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }
}
