package com.hw1.model.dto;

public class Student extends Person {

    private int grade;
    private String major;


    public Student() {
        super();
        System.out.println("Student 클래스의 기본 생성자 호출");
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        super.name = name;
        this.grade = grade;
        this.major = major;
        System.out.println("Person 클래스의 부모 필드도 초기화하는 생성자 호출");
    }

    //setter
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    //getter
    public int getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getInformation() {
        return super.getInformation()
                + " 학년 : " + this.grade
                + ", 전공 : " + this.major
                + "]";
    }

}
