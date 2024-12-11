package com.example.exemination_meka_true.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    public void showSubjects() {
        loadScreen("/com/example/exemination_meka_true/view/subjects.fxml", "Subjects");
    }

    public void showResults() {
        loadScreen("/com/example/exemination_meka_true/view/results.fxml", "My Results");
    }

    private void loadScreen(String resource, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
