package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /*
         * 1. 사람 생성 ( 이름, 나이는 생성과 동시에 초기화되어야 함 )
         * */

        Person person1 = new Person("홍길동", 20);

        /*
         * 2. 1에서 만든 사람의 국적 설정
         *   (한국, 일본, 중국, 홍콩, 터키 중 하나만 가능 / 만약 다른 국가를 입력했다면 자동으로 한국 설정 ) */

        person1.setNational("홍콩");

        /* 3. 강아지 입양 -> 사람이 할 수 있는 일 (= Person의 메소드를 호출해서 Dog 추가)
        * 단, 강아지는 반드시 이름이 있어야 함 (강아지 입력 스캐너로 입력 받기) */


        Scanner sc = new Scanner(System.in);
        System.out.print("강아지 이름을 입력하세요 : ");
        String dogname = sc.nextLine();

        person1.adoptDog(dogname);

        System.out.println(person1.toString());

        /* 강아지에게 재주 가르치기 -> 사람이 할 수 있는 일
        * (= Person의 매개변수가 있는 메소드를 호출해서 dog의 ability 추가)
        * */

        System.out.println(dogname + "에게 재주를 부리게 해보자 !");

        String[] teachingAbility = new String[]{"앉아", "빵 !!", "기다려!"};
        System.out.println("앉아, 빵, 기다려를 가르쳤다.");
        person1.teachDog(teachingAbility);
        System.out.println("잘 배웠나?");
        System.out.println(person1.toString());

    }







}
