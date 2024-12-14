package com.example.exemination_meka_true.controller;

import com.example.exemination_meka_true.dao.QuestionDAO;
import com.example.exemination_meka_true.dao.ResultDAO;
import com.example.exemination_meka_true.model.Question;
import com.example.exemination_meka_true.model.Result;
import com.example.exemination_meka_true.util.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class TestQuestionsController {

    @FXML
    private Label questionLabel;

    @FXML
    private TextField answerField;

    private final QuestionDAO questionDAO = new QuestionDAO();
    private final ResultDAO resultDAO = new ResultDAO(DatabaseUtil.getConnection());
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public TestQuestionsController() throws SQLException {
    }

    @FXML
    public void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
        // Загружаем все вопросы для выбранного теста
        questions = questionDAO.findAllByTestId(TestController.selectedTest.getId());
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
        } else {
            saveResults();
            showResults();
        }
    }

    public void submitAnswer() {
        String userAnswer = answerField.getText();
        Question currentQuestion = questions.get(currentQuestionIndex);

        // Проверяем, если ответ правильный, увеличиваем счет
        if (currentQuestion.getCorrectAnswer().equalsIgnoreCase(userAnswer)) {
            score++;
        }

        currentQuestionIndex++;
        answerField.clear();
        showNextQuestion();
    }

    private void saveResults() {
        // Создаем новый результат с полными данными
        Result result = new Result(
                TestController.selectedTest.getId(),
                LoginController.loggedInUser.getId(),
                LoginController.loggedInUser.getUsername(),
                TestController.selectedTest.getName(),
                score
        );
        // Сохраняем результат в базе данных
        resultDAO.save(result);
    }


    private void showResults() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Completed");
        alert.setHeaderText("Your Results");
        alert.setContentText("You scored: " + score + "/" + questions.size());
        alert.showAndWait();
        saveResults();


        // Закрытие текущего окна после завершения теста
        questionLabel.getScene().getWindow().hide();
    }
}
