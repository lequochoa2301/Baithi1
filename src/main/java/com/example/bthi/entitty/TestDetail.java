package com.example.bthi.entitty;

import jakarta.persistence.*;

@Entity
public class TestDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private double pointMax;
     private double pointObtained;
     private String result;

     @ManyToOne
     @JoinColumn(name = "testID")
     private Test test;

     @ManyToOne
     @JoinColumn(name = "studentID")
     private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPointMax() {
        return pointMax;
    }

    public void setPointMax(double pointMax) {
        this.pointMax = pointMax;
    }

    public double getPointObtained() {
        return pointObtained;
    }

    public void setPointObtained(double pointObtained) {
        this.pointObtained = pointObtained;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
