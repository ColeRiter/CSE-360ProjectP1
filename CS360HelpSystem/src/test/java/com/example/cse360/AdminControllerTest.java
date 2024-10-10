package test.java.com.example.cse360;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminControllerTest {

    private AdminController adminController;
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        adminController = new AdminController(userManager);
    }

    @Test
    public void testInviteUser() {
        String inviteCode = adminController.inviteUser("newuser@example.com", "newuser", UserRole.STUDENT);
        assertNotNull(inviteCode); // Check that an invitation code is generated
    }

    @Test
    public void testResetUser() {
        User user = new User("user@example.com", "user", "password".toCharArray(), "User", "", "Account", "");
        userManager.registerUser(user);
        adminController.resetUser("user");
        
        assertTrue(user.isOneTimePassword()); // Check if the user has a one-time password
    }
}
