package test.java.com.example.cse360;

import main.java.com.example.cse360.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    @Test
    public void testUserCreation() {
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        User user = new User("email@example.com", "username", password, "First", "Middle", "Last", "Preferred");
        
        assertEquals("email@example.com", user.getEmail());
        assertEquals("username", user.getUsername());
        assertArrayEquals(password, user.getPassword());
        assertEquals("First", user.getFirstName());
        assertEquals("Middle", user.getMiddleName());
        assertEquals("Last", user.getLastName());
        assertEquals("Preferred", user.getPreferredName());
    }

    @Test
    public void testPasswordCheck() {
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        User user = new User("email@example.com", "username", password, "First", "Middle", "Last", "Preferred");

        assertTrue(user.checkPassword(new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'}));
        assertFalse(user.checkPassword(new char[] {'w', 'r', 'o', 'n', 'g'}));
    }
}
