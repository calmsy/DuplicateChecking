package com.beans;

public class Score {
    private String student_id;
    private String course_id;
    private double usual_score;
    private double final_score;
    private double total_score;

    private String course_name;
    private String student_name;

    public Score() {
    }

    public Score(String student_id, String course_id, double usual_score, double final_score, double total_score) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.usual_score = usual_score;
        this.final_score = final_score;
        this.total_score = total_score;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public double getUsual_score() {
        return usual_score;
    }

    public void setUsual_score(double usual_score) {
        this.usual_score = usual_score;
    }

    public double getFinal_score() {
        return final_score;
    }

    public void setFinal_score(double final_score) {
        this.final_score = final_score;
    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    @Override
    public String toString() {
        return "Score{" +
                "student_id='" + student_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", usual_score=" + usual_score +
                ", final_score=" + final_score +
                ", total_score=" + total_score +
                '}';
    }
}
