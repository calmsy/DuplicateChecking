package com.beans;

public class ClassScore {
    private String class_id;
    private double usual_score;
    private double avg_usual_score;
    private double final_score;
    private double avg_final_score;
    private double total_score;
    private double avg_total_score;

    private int number;
    private String class_name;
    public ClassScore() {
    }

    public ClassScore(String class_id, double usual_score, double avg_usual_score, double final_score, double avg_final_score, double total_score, double avg_total_score) {
        this.class_id = class_id;
        this.usual_score = usual_score;
        this.avg_usual_score = avg_usual_score;
        this.final_score = final_score;
        this.avg_final_score = avg_final_score;
        this.total_score = total_score;
        this.avg_total_score = avg_total_score;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public double getUsual_score() {
        return usual_score;
    }

    public void setUsual_score(double usual_score) {
        this.usual_score = usual_score;
    }

    public double getAvg_usual_score() {
        return avg_usual_score;
    }

    public void setAvg_usual_score(double avg_usual_score) {
        this.avg_usual_score = avg_usual_score;
    }

    public double getFinal_score() {
        return final_score;
    }

    public void setFinal_score(double final_score) {
        this.final_score = final_score;
    }

    public double getAvg_final_score() {
        return avg_final_score;
    }

    public void setAvg_final_score(double avg_final_score) {
        this.avg_final_score = avg_final_score;
    }

    public double getTotal_score() {
        return total_score;
    }

    public void setTotal_score(double total_score) {
        this.total_score = total_score;
    }

    public double getAvg_total_score() {
        return avg_total_score;
    }

    public void setAvg_total_score(double avg_total_score) {
        this.avg_total_score = avg_total_score;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Class_score{" +
                "class_id='" + class_id + '\'' +
                ", usual_score=" + usual_score +
                ", avg_usual_score=" + avg_usual_score +
                ", final_score=" + final_score +
                ", avg_final_score=" + avg_final_score +
                ", total_score=" + total_score +
                ", avg_total_score=" + avg_total_score +
                '}';
    }
}
