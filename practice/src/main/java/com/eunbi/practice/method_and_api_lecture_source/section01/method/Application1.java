package com.eunbi.practice.method_and_api_lecture_source.section01.method;

public class Application1 {

    // method A 호출됨....
    // method B로 10 값 넘어옴....

    public static void main(String[] args) {

        Application1 app = new Application1();
        app.methodA();
        app.methodB(10);

    }

    public void methodA() {
        System.out.println("method A 호출됨....");
    }

    public void methodB(int b) {
        System.out.println("method B로 값 " + b + "넘어옴....");
    }


}
