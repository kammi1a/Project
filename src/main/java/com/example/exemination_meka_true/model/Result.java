package com.example.exemination_meka_true.model;

public class Result {
    private String userName;
    private String testName;
    private int score;

    public Result(String userName, String testName, int score) {
        this.userName = userName;
        this.testName = testName;
        this.score = score;
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
