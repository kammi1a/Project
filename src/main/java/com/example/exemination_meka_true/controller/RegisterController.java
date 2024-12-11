package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.dao.UserDAO;
import com.example.exemination_meka_true.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField usernameField;

    private final UserDAO userDAO = new UserDAO();

    public void register() {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            showAlert("Error", "Username cannot be empty");
            return;
        }

        if (userDAO.findByUsername(username).isPresent()) {
            showAlert("Error", "Username already exists");
            return;
        }

        User user = new User(username);
        userDAO.save(user);

        showAlert("Success", "Registration successful! Redirecting to login...");
        redirectToLogin();
    }

    private void redirectToLogin() {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new javafx.scene.Scene(
                    javafx.fxml.FXMLLoader.load(getClass().getResource("/com/example/exemination_meka_true/view/login.fxml"))
            ));
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
