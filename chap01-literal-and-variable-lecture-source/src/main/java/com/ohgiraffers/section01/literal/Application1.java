package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        System.out.println(123);
        System.out.println(1.23);

        System.out.println('a'); //문자 형태의 값은 홑따옴표(single-quotation)으로 감싸줘야 한다.
//        System.out.println('ab'); // 두 개 이상은 문자로 취급하지 않기 때문에 에러 발생
//        System.out.println(''); //오류 남
          System.out.println('1'); //숫자 값이지만 문자로 판단

        System.out.println("안녕하세요");
        System.out.println("123"); //숫자 값이 아닌 문자열 인식+
        System.out.println(""); //오류 안남
        System.out.println("a"); //홑따옴표와 다른 값으로 인식, 문자=/=문자열

        System.out.println(true);
        System.out.println(false); //true 혹은 false 값을 논리값이라 함
    }
}
