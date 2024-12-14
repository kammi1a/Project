package com.example.exemination_meka_true.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSeeder {

    public static void seedDatabase() {
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {

            
            String insertSubjects = "INSERT INTO Subjects (id, name) VALUES " +
                    "(1, 'Math'), " +
                    "(2, 'Science') " +
                    "ON CONFLICT (id) DO NOTHING;";
            statement.executeUpdate(insertSubjects);

            
            String insertTests = "INSERT INTO Tests (id, subject_id, name) VALUES " +
                    "(1, 1, 'Algebra Test'), " +
                    "(2, 1, 'Calculus Test'), " +
                    "(3, 2, 'Physics Test'), " +
                    "(4, 2, 'Chemistry Test') " +
                    "ON CONFLICT (id) DO NOTHING;";
            statement.executeUpdate(insertTests);

            
            String insertQuestions = "INSERT INTO Questions (id, test_id, question_text, correct_answer) VALUES " +
                    "(1, 1, 'What is x if 2x = 6?', '3'), " +
                    "(2, 1, 'What is the derivative of x^2?', '2x'), " +
                    "(3, 2, 'What is the sum of angles in a triangle?', '180'), " +
                    "(4, 2, 'What is the area of a rectangle with sides 3 and 4?', '12'), " +
                    "(5, 3, 'What is the unit of force?', 'Newton'), " +
                    "(6, 3, 'What is the acceleration due to gravity on Earth?', '9.8 m/s^2'), " +
                    "(7, 4, 'What is the chemical symbol for water?', 'H2O'), " +
                    "(8, 4, 'What is the pH of pure water?', '7') " +
                    "ON CONFLICT (id) DO NOTHING;";
            statement.executeUpdate(insertQuestions);

            System.out.println("Database successfully seeded!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
