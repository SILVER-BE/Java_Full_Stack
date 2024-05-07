package com.ohgiraffers.section04.overflow;

public class Applicaiton1 {
    public static void main(String[] args) {

        /* 필기.
        *  자료형 별 값의 최대 범위를 벗어나는 경우
        *  발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환시킴
        *  */

        byte num1 = 127;

        System.out.println("num1 : " + num1);       //127 : byte의 최대 저장 범위 (-128~127)

        num1++;     //num1 = num1 + 1   //1 증가 (num1 에 1을 넣어서 다시 num1에 넣는다.) <- 128이 되어 범위 이탈

        System.out.println("num1 overflow : " + num1);  //-128 ㅣ byte의 최소 저장 범위

        /* 필기. 언더플로우
         * 오버플로우와 반대 개념으로 최소 범위보다 작은 수를 발생시키는 경우 발생하는 현상이다. 최댓값으로 순환.
         */
        byte num2 = -128;

        System.out.println("num2 : " + num2);       //-128 : byte의 최소 저장 범위

        num2--;     //num2 = num2 - 1 (num2에서 -1 한 값을 다시 num2로 넣어라 <- 1 감소 및 범위 이탈)

        System.out.println("num2 underflow : " + num2);     //127 : byte의 최대 저장 범위

        int firstNum = 1000000;     //100만
        int secondNum = 700000;     //70만

        int multi = firstNum * secondNum;           //7천억, int 범위 초과
        System.out.println("firstNum * secondNum : " + multi);      //-79669248 <-값은 나오는데 틀림, 논리적 에러

        long longMulti = firstNum * secondNum;      //int로 이미 계산된 값이 넣어짐
        System.out.println("longMulit :" + longMulti);

        long result = (long) firstNum * secondNum;      //강제 형변환
        System.out.println("result : " + result);       //정상적으로 7천억 출력






    }
}
