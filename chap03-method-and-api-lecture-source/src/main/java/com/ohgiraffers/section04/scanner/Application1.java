package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {


        /* java.util.Scanner를 이용하여 다양한 자료형 값 입력 받기 */

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine(); //문자열 : sc.nextLine();
        System.out.println("입력하신 이름은 " + name + "입니다.");

        System.out.print("나이를 입력하세요 : "); //println은 밑에 커서가 생김
        int age = sc.nextInt(); //정수 : sc.nextInt();
        System.out.println("입력하신 나이는 " + age + "입니다.");

        System.out.print("키를 입력해주세요 : ");
        float height = sc.nextFloat();
        System.out.println("입력하신 키는 " + height + "입니다.");

        System.out.print("true 또는 false를 입력해주세요 : ");
        boolean isTrue = sc.nextBoolean();
        System.out.println("입력하신 값은 " + isTrue + "입니다.");

        sc.nextLine(); //없으면 에러남.. 정수나 실수를 입력받은 후에는 문자열 받기 위한 준비 필요
        System.out.print("아무 문자열을 입력해 주세요 : ");
        char ch = sc.nextLine().charAt(0);
        System.out.println("입력하신 문자는 " + ch + "입니다.");

    }
}
