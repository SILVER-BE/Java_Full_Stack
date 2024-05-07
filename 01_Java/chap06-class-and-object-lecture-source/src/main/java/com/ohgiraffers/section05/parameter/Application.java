package com.ohgiraffers.section05.parameter;

public class Application {
    public static void main(String[] args) {

        /*
        * 매개변수(parameter)로 사용 가능한 자료형
        * 1. 기본자료형  --> byte, int, short 등..
        * 2. 기본자료형 배열   --> int[] arr = new arr[] {}
        * 3. 클래스 자료형(사용자 정의 자료형)
        * 4. 클래스 자료형 배열(= 객체 배열)
        * 5. 가변 인자
        * */

        ParameterTest pt = new ParameterTest();

        int num = 20;
        pt.primaryTypeParameter(num);

        int[] iarr = new int[] {1,2,3,4,5};
        System.out.println("기본자료형 배열 전달인자로 전달하는 값 : " + iarr);
        pt.primaryTypeParameter(iarr);

        System.out.println("변경 후 원본 배열의 값 출력 : ");
        for(int i = 0; i < iarr.length; i++) {
            System.out.print(iarr[i] + " ");
        }
        System.out.println();

        RectAngle r1 = new RectAngle(12.5, 22.5);

        System.out.println("클래스 자료형 전달인자로 전달하는 값 : " + r1);
        pt.classTypeParameter(r1);

        System.out.println("변경 후 사걱형의 넓이와 둘레 ==========");
        r1.calcArea();
        r1.calcRound();

        /* 가변인자는 갯수가 정해지지 않음 */
//        pt.variableLengthArrayparameter();  //인자가 아무것도 없는 경우 에러 발생
        pt.variableLengthArrayparameter("홍길동"); //가변인자 제외하고 입력하면 Error X
        pt.variableLengthArrayparameter("권은지", "볼링"); //1개도 가능(가변!)
        pt.variableLengthArrayparameter("남윤진", "볼링", "당구", "축구");
        pt.variableLengthArrayparameter("유승제", new String[] {"테니스", "서예", "탁구"}); //배열 형태도 가능

        //어떤 메소드를 사용해야할지 헷갈려서 오류 발생 (오버로딩 작성 후..빨간줄 그어짐)


    }

}
