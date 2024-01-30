package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /* 전달인자(argument)와 매개변수(parameter)를 이용한 메소드 호출 */

        /* 변수의 종류
        * 1. 지역변수
        * 2. 매개변수
        * 3. 전역변수(필드)
        * 4. 클래스(static)변수
        * */

        /* 지역변수는 선언한 메소드 블럭 내부에서만 사용 가능하다. 이것을 지역변수의 스코프라고 한다.
        * 다른 메소드간 서로 공유해야 하는 값이 존재하는 경우 메소드 호출 시 사용하는 괄호를 이용해서 값을 전달할 수 있다.
        * 이 때 전달하는 값을 전달인자(argument)라고 부르고,
        * 메소드 선언부 괄호 안에 전달 인자를 받기 위해 선언하는 변수를 매개변수(parameter)라고 부른다. */

        Application3 app3 = new Application3();
        /* 전달인자와 매개변수를 이용한 메소드 호출 테스트 */
        app3.testmethod(40);
//        app3.testmethod("40");     //매개변수는 int형이지만 인자가 String형이기 때문에 에러
//        app3.testmethod(20,30,40); //매개변수는 int형 1개이지만 인자가 3개라 에러
//        app3.testmethod();         //매개변수는 선언되어있지만 인자로 값을 전달하지 않으면 에러

        int age2 = 20;
        app3.testmethod(age2);

        byte byteAge = 10;              //자동형변환 (byte -> int)
        app3.testmethod(byteAge);

        long longAge = 60;
//        app3.testmethod(longAge);     //자동형변환을 할 수 없어서 에러 발생
        app3.testmethod((int)longAge);  //강제형변환(데이터 손실 주의)

        app3.testmethod(age2 * 4); //연산된 결과로 값 계산
    }

    public void testmethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");

    }
}
