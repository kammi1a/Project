package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Question;

import java.util.Arrays;
import java.util.List;

public class QuestionDAO {

    public List<Question> findAllByTestId(int testId) {
        return Arrays.asList(
                new Question(1, testId, "What is 2 + 2?", "4"),
                new Question(2, testId, "What is the capital of France?", "Paris"),
                new Question(3, testId, "What is 3 * 3?", "9"),
                new Question(4, testId, "What is the square root of 16?", "4"),
                new Question(5, testId, "Who wrote 'Hamlet'?", "Shakespeare")
        );
    }
}
