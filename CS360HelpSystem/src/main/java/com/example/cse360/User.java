package main.java.com.example.cse360;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String email;
    private String username;
    private char[] password; // Storing as char array for security reasons
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private boolean isOneTimePassword;
    private LocalDateTime oneTimePasswordExpiry;
    private List<String> topics; // Define the topics field

    public User(String email, String username, char[] password, String firstName, String middleName, String lastName, String preferredName) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        this.topics = new ArrayList<>(); // Initialize the topics list
    }

    // Getter methods
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public boolean isOneTimePassword() {
        return isOneTimePassword;
    }

    public LocalDateTime getOneTimePasswordExpiry() {
        return oneTimePasswordExpiry;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public List<String> getTopics() {
        return topics; // Now it returns the initialized topics list
    }

    // Additional methods
    public boolean checkPassword(char[] passwordToCheck) {
        return Arrays.equals(this.password, passwordToCheck);
    }

    // Setters if needed
    public void setPassword(char[] password) {
        this.password = password;
    }
}
