package test.java.com.example.cse360;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testRegisterUser() {
        User user = new User("admin@example.com", "admin", "password".toCharArray(), "Admin", "", "User", "Admin");
        userManager.registerUser(user);
        assertEquals(1, userManager.getAllUsers().size());
        assertEquals(user, userManager.getAllUsers().get(0));
    }

    @Test
    public void testUserRoleAssignment() {
        User user = new User("user@example.com", "user", "password".toCharArray(), "Regular", "", "User", "");
        userManager.registerUser(user);
        userManager.addRoleToUser("user", UserRole.STUDENT);
        assertTrue(user.getRoles().contains(UserRole.STUDENT));
    }

    @Test
    public void testRemoveRoleFromUser() {
        User user = new User("user@example.com", "user", "password".toCharArray(), "Regular", "", "User", "");
        userManager.registerUser(user);
        userManager.addRoleToUser("user", UserRole.INSTRUCTOR);
        userManager.removeRoleFromUser("user", UserRole.INSTRUCTOR);
        assertFalse(user.getRoles().contains(UserRole.INSTRUCTOR));
    }
}