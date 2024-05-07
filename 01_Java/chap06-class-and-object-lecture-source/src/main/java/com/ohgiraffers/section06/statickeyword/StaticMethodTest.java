package com.ohgiraffers.section06.statickeyword;

public class StaticMethodTest {

    private int count;

    public void nonStaticMethod() {
        this.count++;               //인스턴스 생성 후 사용 가능한 메소드이기 때문에 this에 주소가 들어있다.
                                    //this = 현재 객체의 값, 필드값
                                    //이 메소드를 호출할 때는 이미 객체가 생성되어 있는 상태이기 때문에 this 사용 가능
        System.out.println("nonStaticMethod 호출됨");
    }

    public static void staticMethod() {
//        this.count++;             //인스턴스를 생성하지 않고 사용하는 메소드이기 때문에 this에는 주소가 들어갈 수 없다.
    }                               //객체 생성 후 호출 X.. this에 주소가 들어갈 수 없음
}
