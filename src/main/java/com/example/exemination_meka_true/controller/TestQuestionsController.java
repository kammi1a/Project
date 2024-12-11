package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.dao.QuestionDAO;
import com.example.exemination_meka_true.model.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class TestQuestionsController {

    @FXML
    private Label questionLabel;

    @FXML
    private TextField answerField;

    private final QuestionDAO questionDAO = new QuestionDAO();
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @FXML
    public void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
        questions = questionDAO.findAllByTestId(TestController.selectedTest.getId());
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
        } else {
            showResults();
        }
    }

    public void submitAnswer() {
        String userAnswer = answerField.getText();
        Question currentQuestion = questions.get(currentQuestionIndex);

        if (currentQuestion.getCorrectAnswer().equalsIgnoreCase(userAnswer)) {
            score++;
        }

        currentQuestionIndex++;
        answerField.clear();
        showNextQuestion();
    }

    private void showResults() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Completed");
        alert.setHeaderText("Your Results");
        alert.setContentText("You scored: " + score + "/" + questions.size());
        alert.showAndWait();

        questionLabel.getScene().getWindow().hide();
    }
}
