package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {

        /* 여러 개의 전달인자를 이용한 메소드 호출 테스트 */
        Application4 app4 = new Application4();
        app4.testMethod("박은비", 20, '여');
//        app4.testMethod(20, "박은비", '여'); //값의 갯수는 맞지만 순서가 다르게 전달되면 호출하지 못한다.

        String name = "박은비";
        int age = 20;
        char gender = '여';

        app4.testMethod(name, age, gender);

    }

    public void testMethod(String name, int age, final char gender) {
        // final로 상수를 고정하면, 이 안에서 다시 선언할 수 없음 = 상수

        /* 매개변수도 일종의 지역변수로 분류된다.
        * 매개변수 역시 final 키워드를 사용할 수 있다.
        * 지역변수에 final 키워드를 붙여 상수를 만드는 것과 동일하다.
        * final 매개변수는 상수 네이밍 규칙을 선택적으로 따르는 경향이 있다.
        * */
        System.out.println("당신의 이름은 " + name + "이고, 나이는 " + age + "세이며, 성별은 " + gender + "입니다.");

    }
}
