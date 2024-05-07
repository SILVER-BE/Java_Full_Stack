package com.ohgiraffers.section02.abstractclass;

public abstract class Product {
    private int nonStaticField;
    private static int staticField;

    public Product() {}

    // 추상클래스에 일반 메소드도 사용 가능
    public void nonStaticMethod() {
        System.out.println("Product 클래스의 nonStaticMethod 호출함");
    }
    public static void staticMethod() {
        System.out.println("Product 클래스의 staticMethod 호출함");
    }

    // 추상메소드
    public abstract void abstMethod();

}
