package com.beans;

public class MyFile {
    private String fileName;
    private String similarity;

    public MyFile() {
    }

    public MyFile(String fileName, String similarity) {
        this.fileName = fileName;
        this.similarity = similarity;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
