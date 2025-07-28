import dbcode.DatabaseInitializer;
import gui.LoginForm;

public class Main {
    
    public static void main(String[] args) {
        
        DatabaseInitializer.initializeDatabase();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new LoginForm().setVisible(true);
            }
        });
    }
}
