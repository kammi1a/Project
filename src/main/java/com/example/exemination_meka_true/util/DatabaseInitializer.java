package com.example.exemination_meka_true.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initDatabase() {
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {

            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "username VARCHAR(250) NOT NULL UNIQUE);";
            statement.executeUpdate(createUsersTable);


            String createSubjectsTable = "CREATE TABLE IF NOT EXISTS Subjects (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(250) NOT NULL);";
            statement.executeUpdate(createSubjectsTable);


            String createTestsTable = "CREATE TABLE IF NOT EXISTS Tests (" +
                    "id SERIAL PRIMARY KEY, " +
                    "subject_id INT NOT NULL REFERENCES Subjects(id), " +
                    "name VARCHAR(250) NOT NULL);";
            statement.executeUpdate(createTestsTable);

            
            String createQuestionsTable = "CREATE TABLE IF NOT EXISTS Questions (" +
                    "id SERIAL PRIMARY KEY, " +
                    "test_id INT NOT NULL REFERENCES Tests(id), " +
                    "question_text TEXT NOT NULL, " +
                    "correct_answer VARCHAR(250) NOT NULL);";
            statement.executeUpdate(createQuestionsTable);

            String createResultsTable = "CREATE TABLE IF NOT EXISTS Results (" +
                    "user_id INT NOT NULL REFERENCES Users(id), " +
                    "test_id INT NOT NULL REFERENCES Tests(id), " +
                    "score INT NOT NULL, " +
                    "username VARCHAR(250), " +  
                    "test_name VARCHAR(250), " + 
                    "PRIMARY KEY (user_id, test_id));";
            statement.executeUpdate(createResultsTable);


            System.out.println("Tables created successfully or already exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
