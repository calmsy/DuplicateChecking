package com.beans;

public class CandCS {
    Classes aClass;
    ClassScore classScore;

    public CandCS() {
    }

    public CandCS(Classes aClass, ClassScore classScore) {
        this.aClass = aClass;
        this.classScore = classScore;
    }

    public Classes getaClass() {
        return aClass;
    }

    public void setaClass(Classes aClass) {
        this.aClass = aClass;
    }

    public ClassScore getClassScore() {
        return classScore;
    }

    public void setClassScore(ClassScore classScore) {
        this.classScore = classScore;
    }

    @Override
    public String toString() {
        return "CandCS{" +
                "aClass=" + aClass +
                ", classScore=" + classScore +
                '}';
    }
}
