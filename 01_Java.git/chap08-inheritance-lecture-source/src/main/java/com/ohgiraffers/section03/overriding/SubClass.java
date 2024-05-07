package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperCalss {

    /* 메소드 이름 변경 에러 */
//    @Override
//    public void method2(int num) {} <-- 이름이 달라 에러 발생

    /* 메소드 리턴타입 변경 에러 */
//    @Override
//    public int method(int num) { return 0; }

    /* 매개변수 갯수, 타입 변경 에러 */
//    @Override <-- 작성하지 않으면 새로운 메소드를 생성한다고 인식하여 에러 발생 X
//    public void method(String num) {}
//    @Override
//    public void method(int num, String num) {}

    @Override
    public void method(int num) {}

    /* private 메소드는 오버라이딩 불가 */
//    @Override
//    private void privateMethod() {}

    /* final 메소드 오버라이딩 불가 */
//    @Override
//    public final void finalMethod() {}

    /* 부모 메소드의 접근제한자와 같거나 더 넓은 범위로 오버라이딩 가능 */
//    @Override
//    void protectedMethod() {} //dafault 생략 됨, 더 좁은 범위로 불가능

//    @Override
//    protected void protectedMethod() {} //같은 범위로 가능
    @Override
    public void protectedMethod() {} //더 넓은 범위로 가능


}
