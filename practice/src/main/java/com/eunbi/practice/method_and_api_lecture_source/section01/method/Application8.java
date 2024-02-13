package com.eunbi.practice.method_and_api_lecture_source.section01.method;

/* 10과 20의 합 : 30
* 20과 30의 합 : 50 */

public class Application8 {
    public static void main(String[] args) {

        //static 메소드 호출 방법 : 클래스명.메소드명();
        System.out.println("10과 20의 합 : " + Application8.sum(10, 20));
        System.out.println("20과 30의 합 : " + sum(10, 20)); // 동일한 class면 class 생략 가능

    }

    public static int sum(int first, int second) {
        return first + second;
    }

}
