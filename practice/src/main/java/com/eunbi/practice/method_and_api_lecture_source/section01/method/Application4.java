package com.eunbi.practice.method_and_api_lecture_source.section01.method;

public class Application4 {

    /* 당신의 이름은 홍길동이고, 나이는 20세이며, 성별은 여입니다. */
    public static void main(String[] args) {

        Application4 app4 = new Application4();
        app4.testMethod("홍길동", 20, '여');

        String name = "홍길동";
        int age = 20;
        char gender = '여';
        app4.testMethod(name, age, gender);

    }

    public void testMethod(String name, int age, char gender) {
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세이며, 성별은 " + gender + "입니다.");
    }
}
