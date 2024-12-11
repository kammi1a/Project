package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.model.Subject;
import com.example.exemination_meka_true.dao.SubjectDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SubjectsController {

    public static Subject selectedSubject;

    @FXML
    private ListView<Subject> subjectsList;

    private final SubjectDAO subjectDAO = new SubjectDAO();

    @FXML
    public void initialize() {
        loadSubjects();
    }

    private void loadSubjects() {
        ObservableList<Subject> subjects = FXCollections.observableArrayList(subjectDAO.findAll());
        subjectsList.setItems(subjects);
    }

    public void selectSubject() {
        selectedSubject = subjectsList.getSelectionModel().getSelectedItem();
        if (selectedSubject != null) {
            openTestsScreen();
        }
    }

    private void openTestsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/exemination_meka_true/view/tests.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Tests");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
