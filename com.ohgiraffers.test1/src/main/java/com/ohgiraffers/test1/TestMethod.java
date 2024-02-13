package com.ohgiraffers.test1;

import java.util.Scanner;

public class TestMethod {
    public static void Calculator(int first, int second) {

        first += second;
        System.out.println("두 수를 더한 값은 " + first + "입니다.");
    }

    public double CircleArea() {

        final double A = Math.PI;

        Scanner sc = new Scanner(System.in);
        System.out.print("반지름을 입력하시오 : ");
        double num = sc.nextInt();
        double result = A * num * num;

        return result;
    }

    public static int randomNumber() {
        return (int)(Math.random() * 10) + 1;
    }

}





