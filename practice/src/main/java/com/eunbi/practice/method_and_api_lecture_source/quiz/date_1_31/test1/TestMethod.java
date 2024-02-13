package com.eunbi.practice.method_and_api_lecture_source.quiz.date_1_31.test1;

import java.util.Scanner;

public class TestMethod {

    public void Calculator(int first, int second) {
        first += second;
    }

    public double CircleArea() {
        final double PI = 3.14;

        Scanner sc = new Scanner(System.in);
        System.out.print("반지름의 값을 입력하시오 : ");
        double num = sc.nextInt();

        return PI * num * num;
    }

    public static int TestRandom() {        //★
        return (int) Math.random() * 10 + 1;
    }




}
