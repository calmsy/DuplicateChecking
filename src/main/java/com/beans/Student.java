package com.beans;

public class Student {
    private String student_id;
    private String student_name;
    private String sex;
    private String college;
    private String class_id;
    private String phone;

    public Student() {
    }

    public Student(String student_id, String student_name, String sex, String college, String class_id, String phone) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.sex = sex;
        this.college = college;
        this.class_id = class_id;
        this.phone = phone;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", sex='" + sex + '\'' +
                ", college='" + college + '\'' +
                ", class_id='" + class_id + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
