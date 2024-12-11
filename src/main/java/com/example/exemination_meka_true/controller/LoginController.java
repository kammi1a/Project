package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.dao.UserDAO;
import com.example.exemination_meka_true.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    private final UserDAO userDAO = new UserDAO();

    public void login() {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            showAlert("Error", "Username cannot be empty");
            return;
        }

        if (userDAO.findByUsername(username).isEmpty()) {
            showAlert("Error", "User not found");
            return;
        }

        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();
            Stage mainStage = new Stage();
            mainStage.setTitle("Main Menu");
            mainStage.setScene(new javafx.scene.Scene(
                    javafx.fxml.FXMLLoader.load(getClass().getResource("/com/example/exemination_meka_true/view/main.fxml"))
            ));
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void redirectToRegister() {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.close();
            Stage registerStage = new Stage();
            registerStage.setTitle("Register");
            registerStage.setScene(new javafx.scene.Scene(
                    javafx.fxml.FXMLLoader.load(getClass().getResource("/com/example/exemination_meka_true/view/register.fxml"))
            ));
            registerStage.show();
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
