package com.hw1.model.dto;

public class Employee extends Person {


    private int salary;
    private String dept;

    //기본 생성자
    public Employee() {
        super();
        System.out.println("Employee의 기본생성자 호출됨");
    }

    //
    public Employee(String name, int age, double height, double weight, int salay, String dept) {
        super(age, height, weight);
        super.name = name;
        this.salary = salay;
        this.dept = dept;
        System.out.println("Person 클래스의 부모 필드도 초기화하는 생성자 호출");
    }

    //setter
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    //getter
    public int getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    //
    @Override
    public String getInformation() {
        return super.getInformation()
                + " 급여 : " + this.salary + ", 부서 : " + dept + " ]";
    }
}

