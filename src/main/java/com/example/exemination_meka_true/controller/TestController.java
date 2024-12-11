package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.model.Test;
import com.example.exemination_meka_true.dao.TestDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TestController {

    public static Test selectedTest;

    @FXML
    private ListView<Test> testsList;

    private final TestDAO testDAO = new TestDAO();

    @FXML
    public void initialize() {
        loadTests();
    }

    private void loadTests() {
        ObservableList<Test> tests = FXCollections.observableArrayList(
                testDAO.findAllBySubjectId(SubjectsController.selectedSubject.getId())
        );
        testsList.setItems(tests);
    }

    public void selectTest() {
        selectedTest = testsList.getSelectionModel().getSelectedItem();
        if (selectedTest != null) {
            openTestQuestionsScreen();
        }
    }

    private void openTestQuestionsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/exemination_meka_true/view/test_questions.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Answer Questions");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
