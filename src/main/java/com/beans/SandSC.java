package com.beans;

import java.util.List;

public class SandSC {
    Student student;
    List<Score> scores;

    public SandSC() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "SandSC{" +
                "student=" + student +
                ", scores=" + scores +
                '}';
    }
}
