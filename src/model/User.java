package model;

// for hashing
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User 
{    
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = hash(password);
    }

    public User(String email, String password) // for logging in
    {
        this.email = email;
        this.password = hash(password);
    }

    public String getUsername(){ return username; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password; }

    private String hash(String password)
    {
        try
        {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new RuntimeException("SHA-256 algorithm not found!", e);
        }
    }
}
