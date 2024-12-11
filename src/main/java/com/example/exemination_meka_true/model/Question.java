package com.example.exemination_meka_true.model;

public class Question {
    private int id;
    private int testId;
    private String questionText;
    private String correctAnswer;

    public Question(int id, int testId, String questionText, String correctAnswer) {
        this.id = id;
        this.testId = testId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public int getTestId() {
        return testId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
