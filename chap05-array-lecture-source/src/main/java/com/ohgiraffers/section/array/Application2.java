package com.ohgiraffers.section.array;

public class Application2 {
    public static void main(String[] args) {

        //배열 길이와 객체 함수 헷갈리지 말 것. 배열 길이는 배열의 갯수로 함수는 배열의 명칭

    /*
    * [배열의 사용 방법]
    * 1. 배열 선언
    * 2. 배열 할당 (new 연산자 이용)
    * 3. 배열 인덱스 공간에 값 대입
    * */

    /* 배열 선언
    * 자료형[] 배열명;
    * 자료형 배열명[];
    *
    * stack 영역에 배열의 주소를 보관할 수 있는 공간을 만드는 것이다.
    * */
//    int[] iarr;  둘 다 가능
    int iarr[];

    /* 배열 할당 */
    iarr = new int[5];
//    iarr = new int[]; //배열의 크기를 지정하지 않으면 에러 발생

    int[] iarr2 = new int[5];

    /* 선언과 동시에 할당과 동시에 초기화 */
    int[] iarr3 = new int[] {11, 22, 33, 44, 55};   //대괄호에 숫자 x
    for(int i = 0; i < iarr3.length; i++) {
        System.out.println(iarr3[i]);
    }
    int[] iarr4 = {111, 222, 333, 444, 555};   //배열의 길이 5
    for(int i = 0; i < iarr4.length; i++) {
        System.out.println(iarr4[i]);
    }

    String[] sarr = {"red", "orange", "yellow", "green", "purple"};
    for(int i = 0; i < sarr.length; i++) {
        System.out.println(sarr[i]);
    }
    System.out.println(iarr); //---> [I@36baf30c
    /* hashcode() : 일반적으로 객체의 주소값을 10진수로 변환하여 생성한 객체의 고유한 정수값을 반환 */
     System.out.println("iarr의 hashCode : " + iarr.hashCode());

     System.out.println("iarr의 길이 : " + iarr.length);

     /* 배열의 한계점 : 길이의 변경이 불가함 */
        double[] darr = new double[10];
        System.out.println("darr의 길이 : " + darr.length);
        System.out.println("darr의 hashCode : " + darr.hashCode());

        darr = new double[100];
        System.out.println("darr의 길이 : " + darr.length);
        System.out.println("darr의 hashCode : " + darr.hashCode()); //완전히 다른 배열이라는 뜻, 새로 덮어씌워진 것이며 길이가 변경된 것이 아님 > 재창조

     /* 배열의 인덱스 공간에 값 대입 */

     /* <값의 형태별 기본값>
     * 정수 : 0
     * 실수 : 0.0
     * 논리 : false
     * 문자열 : \u0000
     * 참조 : null
     * */

        System.out.println(iarr[0]);
        System.out.println(iarr[1]);
        System.out.println(iarr[2]);
        System.out.println(iarr[3]);
        System.out.println(iarr[4]);

        System.out.println("========");

        for(int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }

        iarr[0] = 1;
        iarr[1] = 2;
        iarr[2] = 3;
        iarr[3] = 4;
        iarr[4] = 5;

        System.out.println("========");

        for(int i = 0; i < iarr.length; i++) {
            iarr[i] = i + 1;
            System.out.println(iarr[i]);
        }

    }
}
