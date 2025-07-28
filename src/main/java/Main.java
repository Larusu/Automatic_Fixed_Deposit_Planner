import dbcode.DatabaseInitializer;
import gui.LoginForm;

public class Main 
{
    public static void main(String[] args) 
    {
        try
        { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseInitializer.initializeDatabase();

            java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
        } 
        catch(Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, 
            "The application failed to start properly.\nPlease restart the application.", 
            "Startup Error (Open XAMPP)", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
