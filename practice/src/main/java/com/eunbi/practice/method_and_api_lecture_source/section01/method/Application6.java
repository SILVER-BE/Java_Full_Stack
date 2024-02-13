package com.eunbi.practice.method_and_api_lecture_source.section01.method;

/*
* main() 시작
* hello world!
* hello world!
* main() 종료
* */

public class Application6 {
    public static void main(String[] args) {
        System.out.println("main() 시작");

        Application6 app6 = new Application6();
        app6.testMethod();

        System.out.println(app6.testMethod());

        System.out.println("main() 종료");
    }


    public String testMethod () {
        return "hello world!";
    }
}
