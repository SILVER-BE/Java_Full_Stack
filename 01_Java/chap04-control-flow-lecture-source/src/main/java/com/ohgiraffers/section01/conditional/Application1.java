package com.ohgiraffers.section01.conditional;

public class Application1 {
    public static void main(String[] args) {

        A_if a = new A_if();
//        a.simpleIfstatement();
//        a.nestedIfstatement();

        B_ifElse b = new B_ifElse();
//        b.simpleIfElseStatement();
//        b.nestedIfElseStatement();

        C_ifElseif c = new C_ifElseif();
//        c.simpleIfElseStatement();
//        c.nestedIfelseIfstatement();

        D_switch d = new D_switch();
//        d.simpleSwitchStatement();
        d.switchVendingMachine();

    }
}
