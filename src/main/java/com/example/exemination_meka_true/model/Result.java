package com.example.exemination_meka_true.model;

public class Result {
    private int userId;
    private int testId;
    private int score;
    private String userName;
    private String testName;

    // Основной конструктор
    public Result(int testId, int userId, String userName, String testName, int score) {
        this.testId = testId;
        this.userId = userId;
        this.score = score;
        this.userName = userName != null ? userName : ""; // Устанавливаем пустую строку, если значение null
        this.testName = testName != null ? testName : ""; // Устанавливаем пустую строку, если значение null
    }

    // Конструктор по умолчанию (без имени пользователя и названия теста)
    public Result(int testId, int userId, int score) {
        this(testId, userId, "", "", score);
    }

    public int getUserId() {
        return userId;
    }

    public int getTestId() {
        return testId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTestName() {
        return testName;
    }

    public int getScore() {
        return score;
    }
}
