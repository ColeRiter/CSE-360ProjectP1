package test.java.com.example.cse360;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {

    private LoginController loginController;
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        loginController = new LoginController(userManager);
    }

    @Test
    public void testLogin_Success() {
        User user = new User("user@example.com", "user", "password".toCharArray(), "User", "", "Account", "");
        userManager.registerUser(user);
        
        boolean loginSuccessful = loginController.handleLogin("user", "password".toCharArray());
        assertTrue(loginSuccessful); // Check that login was successful
    }

    @Test
    public void testLogin_Failure() {
        User user = new User("user@example.com", "user", "password".toCharArray(), "User", "", "Account", "");
        userManager.registerUser(user);
        
        boolean loginSuccessful = loginController.handleLogin("user", "wrongpassword".toCharArray());
        assertFalse(loginSuccessful); // Check that login failed
    }
}
