package main.java.com.example.cse360;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Get the list of registered users from RegisterController
        List<User> registeredUsers = RegisterController.getRegisteredUsers();

        boolean isLoginSuccessful = false;

        // Loop through the registered users to check for a matching username and password
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username) && user.checkPassword(password.toCharArray())) {
                isLoginSuccessful = true;
                break;
            }
        }

        // Check if login was successful
        if (isLoginSuccessful) {
            System.out.println("Login successful!");
            errorLabel.setText("Login successful!");

            // Here you can switch to another scene or load another FXML file
            // Example: Main.showWelcomeScreen();
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    public void goToRegister() {
        try {
            Parent registerPage = FXMLLoader.load(getClass().getResource("/main/resources/register.fxml"));
            Scene registerScene = new Scene(registerPage);
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.setScene(registerScene);
            currentStage.setTitle("Register");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
