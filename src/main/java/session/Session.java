package session;

import dbcode.UserDAO;
import model.User;

public class Session {

    // Maintains and manages the session state of the currently logged-in user across the application.
    public static int userId = -1;

    public static void login(String email, String password) throws Exception 
    {
        User user = new User(email, password);
        UserDAO userDAO = new UserDAO();
        userDAO.login(user);
    }

    public static void logout()
    {
        userId = -1;
    }
}
