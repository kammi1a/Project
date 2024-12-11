package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Subject;

import java.util.Arrays;
import java.util.List;

public class SubjectDAO {
    public List<Subject> findAll() {
        return Arrays.asList(
                new Subject(1, "Math"),
                new Subject(2, "Science")
        );
    }
}
