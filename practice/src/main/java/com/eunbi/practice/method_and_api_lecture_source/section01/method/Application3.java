package com.eunbi.practice.method_and_api_lecture_source.section01.method;

public class Application3 {
    public static void main(String[] args) {

        Application3 app3 = new Application3();

        /* 당신의 나이는 40세 입니다.
        *  당신의 나이는 20세 입니다.
        *  당신의 나이는 10세 입니다.
        *  당신의 나이는 80세 입니다.
        *  당신의 나이는 60세 입니다. */

        app3.testmethod(40); //매개변수에 값을 저장하여 이용

        int age = 20; //변수에 저장된 값을 이용
        app3.testmethod(age);

        byte byteAge = 10; //자동형변환
        app3.testmethod(byteAge);

        long longAge = 80; //강제형변환
        app3.testmethod((int)longAge);

        app3.testmethod(age * 3); //연산 결과를 이용
    }

    public void testmethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

}
