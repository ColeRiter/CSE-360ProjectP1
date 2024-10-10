package main.java.com.example.cse360;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FinishSetupController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField preferredNameField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button finishButton;

    private User currentUser;
    private UserManager userManager;

    public FinishSetupController(User currentUser, UserManager userManager) {
        this.currentUser = currentUser;
        this.userManager = userManager;
    }

    @FXML
    public void initialize() {
        // Pre-fill fields with current user information if needed
        emailField.setText(currentUser.getEmail());
        firstNameField.setText(currentUser.getFirstName());
        middleNameField.setText(currentUser.getMiddleName());
        lastNameField.setText(currentUser.getLastName());
        preferredNameField.setText(currentUser.getPreferredName());
    }

    @FXML
    public void handleFinishSetup() {
        // Retrieve values from the input fields
        String email = emailField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String middleName = middleNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String preferredName = preferredNameField.getText().trim();

        // Validate inputs
        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            showError("Email, First Name, and Last Name are required fields.");
            return;
        }

        // Update user information
        currentUser.setEmail(email);
        currentUser.setFirstName(firstName);
        currentUser.setMiddleName(middleName);
        currentUser.setLastName(lastName);
        currentUser.setPreferredName(preferredName);

        // Register updated user in the UserManager
        userManager.registerUser(currentUser);

        // Show success alert and redirect to the appropriate home page
        showAlert("Setup Complete", "Your account has been successfully set up!");
        
        // Redirect to home page or logout
        // Logic to navigate to the user's home page would go here
        // For example, load the appropriate FXML file
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
