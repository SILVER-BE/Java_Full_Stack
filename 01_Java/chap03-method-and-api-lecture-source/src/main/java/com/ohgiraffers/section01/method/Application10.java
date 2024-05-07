package com.ohgiraffers.section01.method;

public class Application10 {
    public static void main(String[] args) {

        int first = 100;
        int second = 50;

        int max = Calculator.maxNumberof(first, second);    //얘는 객체 만들지 않아도 되는지..?
        System.out.println("두 수 중 최대값은 : " + max);
    }
}
