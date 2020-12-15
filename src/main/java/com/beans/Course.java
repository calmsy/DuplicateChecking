package com.beans;

public class Course {
    private String course_id;
    private String course_name;
    private int period;
    private double credit;

    public Course() {
    }

    public Course(String course_id, String course_name, int period, double credit) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.period = period;
        this.credit = credit;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", period=" + period +
                ", credit=" + credit +
                '}';
    }
}
