package com.ohgiraffers.section05.parameter;

public class ParameterTest {

    public void primaryTypeParameter(int num) { //기본자료형
        System.out.println("매개변수로 전달 받은 값 : " + num);
    }

    public void primaryTypeParameter(int[] iarr) {  //기본자료형 배열
        /*
        * 배열의 주소가 전달된다.
        * 즉 인자로 전달하는 배열과 매개변수로 전달받은 배열은 서로 동일한 배열을 가리킨다. (얕은 복사)
        */
        System.out.println("매개변수로 전달 받은 값 : " + iarr);
        System.out.println("배열의 값 출력 : ");
        for(int i = 0; i < iarr.length; i++) {
            System.out.print(iarr[i] + " ");

        }
//        for(int i : iarr) {                   //향상된 for문
//            System.out.println((i + " "));
//        }
        System.out.println();
        iarr[0] = 99;

        System.out.println("변경 후 배열의 값 출력 : ");
        for(int i = 0; i < iarr.length; i++) {
            System.out.print(iarr[i] + " ");
        }
        System.out.println();
    }

    public void classTypeParameter(RectAngle rectAngle) {   //클래스 자료형
        System.out.println("매개변수로 전달받은 값 :" + rectAngle);

        System.out.println("변경 전 사각형의 넓이와 둘레 ==========");
        rectAngle.calcArea();
        rectAngle.calcRound();

        rectAngle.setWidth(100);
        rectAngle.setHeight(100);

        System.out.println("변경 후 사각형의 넓이와 둘레 ==========");
        rectAngle.calcArea();
        rectAngle.calcRound();
    }

    public void variableLengthArrayparameter(String name, String...hobby) { //가변인자
        System.out.println("이름 : " + name);
        System.out.println("취미의 갯수 : " + hobby.length);
        System.out.println("취미 : ");
        for(int i = 0; i < hobby.length; i++) {
            System.out.print(hobby[i] + " ");
        }
        System.out.println();
    }

    /* 오버로딩시 주의해야한다.
    * 둘 중 어떤 메소드를 호출하는 것인지에 대한 모호성이 발생했기 때문에 에러. */
//    public void variableLengthArrayparameter(String...hobby) {              //오버로딩
//        System.out.println("취미의 갯수 : " + hobby.length);
//        System.out.println("취미 : ");
//        for(int i = 0; i < hobby.length; i++) {
//            System.out.print(hobby[i] + " ");
//        }
//        System.out.println();
//
//    }
}
