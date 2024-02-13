package com.eunbi.practice.method_and_api_lecture_source.section01.method;

/* 상수 두 개를 이용하여 더하기, 빼기, 곱하기, 나누기의 값 도출 */

public class Application7 {
    public static void main(String[] args) {

        Application7 app7 = new Application7();
        System.out.println(app7.result1(4, 2));
        System.out.println(app7.result2(4, 2));
        System.out.println(app7.result3(4, 2));
        System.out.println(app7.result4(4, 2));

        int firstNum = 4;
        int secondNum = 2;

        System.out.println(app7.result1(firstNum, secondNum));
        System.out.println(app7.result2(firstNum, secondNum));
        System.out.println(app7.result3(firstNum, secondNum));
        System.out.println(app7.result4(firstNum, secondNum));
    }

    public int result1(int first, int second) {
        return first + second;
    }
    public int result2(int first, int second) {
        return first - second;
    }
    public int result3(int first, int second) {
        return first * second;
    }
    public int result4(int first, int second) {
        return first % second;
    }

}
