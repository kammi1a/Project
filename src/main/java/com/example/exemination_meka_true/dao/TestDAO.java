package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Test;
import com.example.exemination_meka_true.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    // Метод для получения тестов по subjectId
    public List<Test> findAllBySubjectId(int subjectId) {
        List<Test> tests = new ArrayList<>();

        // Используем switch-case для добавления тестов в зависимости от subjectId
        switch (subjectId) {
            case 1: // Math subject
                tests.add(new Test(1, 1, "Algebra Test"));
                tests.add(new Test(2, 1, "Calculus Test"));
                break;
            case 2: // Science subject
                tests.add(new Test(3, 2, "Physics Test"));
                tests.add(new Test(4, 2, "Chemistry Test"));
                break;
            default:
                System.out.println("No tests available for the given subject ID.");
        }

        return tests;
    }
}
