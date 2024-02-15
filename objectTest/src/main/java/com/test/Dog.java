package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dog extends Person {

    /* 강아지 속성 : 이름(String), 재주(String[]) */

    private String name;

    private String[] play;

    public Dog () {}

    public Dog (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

//    public void learnAility(int num) {
//        if(num == 1) {
//            System.out.println(name + "가 앉았습니다.");
//        } else if (num == 2) {
//            System.out.println(name + "가 배를 뒤집었습니다.");
//        } else if (num == 3) {
//            System.out.println(name + "가 기다립니다.");
//        }
//    }

    public void setPlay(String[] play) {
        this.play = play;
    }

    public String[] getPlay() {
        return play;
    }

    @Override
    public String toString() {
        return name + "', " + name + "가 배운 재주 : " + Arrays.toString(play) +
                '}';
    }


}
