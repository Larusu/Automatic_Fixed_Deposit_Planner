package session;

import dbcode.UserDAO;
import model.User;

public class Session {
    
    public static int userId = -1;

    public static void login(String username, String email, String password) 
    {
        User user = new User(username, email, password);
        UserDAO userDAO = new UserDAO();
        userDAO.register(user);
    }

    public static void logout()
    {
        userId = -1;
    }
}
