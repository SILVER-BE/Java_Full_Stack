package com.eunbi.practice.method_and_api_lecture_source.quiz.date_1_31.test1;

public class Application {
    public static void main(String[] args) {

        byte num1 = 1;
        int num2 = 2;
        short num3 = 3;
        long num4 = 4;

        float num5 = 5.0f;
        double num6 = 6.0;

        char num7 = 'a';
        boolean num8 = true;

        System.out.println(num2 + (int)num6);
        System.out.println(num2 + (int)num7);
        System.out.println((num2 > 0)? "양수입니다." : "음수입니다.");
    }
}
