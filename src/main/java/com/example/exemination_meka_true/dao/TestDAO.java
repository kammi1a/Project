package com.example.exemination_meka_true.dao;

import com.example.exemination_meka_true.model.Test;

import java.util.Arrays;
import java.util.List;

public class TestDAO {
    public List<Test> findAllBySubjectId(int subjectId) {
        return Arrays.asList(
                new Test(1, 1, "Algebra Test"),
                new Test(2, 1, "Geometry Test"),
                new Test(3, 2, "Physics Test"),
                new Test(4, 2, "Chemistry Test")
        );
    }
}
