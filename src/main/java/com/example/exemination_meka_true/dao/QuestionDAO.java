package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public List<Question> findAllByTestId(int testId) {
        List<Question> questions = new ArrayList<>();

        switch (testId) {
            case 1: // Algebra Test
                questions.add(new Question(1, 1, "What is x if 2x = 6?", "3"));
                questions.add(new Question(2, 1, "What is the derivative of x^2?", "2x"));
                break;
            case 2: // Geometry Test
                questions.add(new Question(3, 2, "What is the sum of angles in a triangle?", "180"));
                questions.add(new Question(4, 2, "What is the area of a rectangle with sides 3 and 4?", "12"));
                break;
            case 3: // Physics Test
                questions.add(new Question(5, 3, "What is the unit of force?", "Newton"));
                questions.add(new Question(6, 3, "What is the acceleration due to gravity on Earth?", "9.8 m/s^2"));
                break;
            case 4: // Chemistry Test
                questions.add(new Question(7, 4, "What is the chemical symbol for water?", "H2O"));
                questions.add(new Question(8, 4, "What is the pH of pure water?", "7"));
                break;
            default:
                System.out.println("No questions available for the given test ID.");
        }

        return questions;
    }
}
