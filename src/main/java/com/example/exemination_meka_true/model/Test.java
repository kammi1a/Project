package com.example.exemination_meka_true.model;

public class Test {
    private int id;
    private int subjectId;
    private String name;

    public Test(int id, int subjectId, String name) {
        this.id = id;
        this.subjectId = subjectId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
