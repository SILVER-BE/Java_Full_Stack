package com.ohgiraffers.section03.interfaceimplements;

public interface InterProduct {

    /* 인터페이스는 추상 메소드와 상수 필드만 작성 가능하다.
    * public void final 제어자 조합을 상수 필드라고 부른다.
    * 반드시 선언과 동시에 초기화 해줘야 한다.
    * */

    public static final int MAX_NUM = 100;
    int MIN_NUM = 10; //앞에 묵시적으로 생략되어 있음 (public static final)

    /* 인터페이스는 생성자를 가질 수 없다. */
//    public InterProduct() {}

    /* 구현부가 있는 non-static 메소드를 가질 수 없다. */
//    public void nonStaticMethod() {}

    /* 추상 메소드만 작성 가능 */
    public abstract void nonStaticMethod(); //구현부 X

    /* 인터페이스의 메소드는 묵시적으로 public abstract의 의미를 가지기 때문에
    * 인터페이스의 메소드를 오버라이딩 하는 경우
    * 반드시 접근제한자를 public 으로 해야 오버라이딩이 가능하다. */

    void abstMethod(); //public abstract를 생략하고 작성해도 문제 X <- 당연히 abstract로 간주

    /* 하지만, static 메소드는 작성이 가능하다. (JDK 1.8 추가된 기능) */
    public static void staticMethod() {
        System.out.println("InterProduct 클래스의 staticMethod 호출됨");
    }

    /* 또한 default 키워드를 사용하면 non-static 메소드도 작성 가능하다. (JDK 1.8 추가된 기능) */
    public default void defaultMethod() {
        System.out.println("Interproduct 클래스의 defaultMethod 호출됨");
    }


}
