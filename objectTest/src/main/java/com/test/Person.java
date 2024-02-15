package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Person {

    /*
    * 사람의 속성 : 이름(String), 나이(int), 국적(String), 강아지(class) --- 캡슐화
    *
    * */

    private String name;
    private int age;
    private String national;
    private Dog dog;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public void setNational(String national) {
//        String[] n = {"한국", "일본", "중국", "홍콩", "터키"};
//            if(Arrays.asList(n).contains(national)) {
//                this.National = national;
//            } else {
//                this.National = "한국";
//            }
//    }

    public void setNational(String national) {
        String[] n = {"한국", "일본", "중국", "홍콩", "터키"};

        for(String i : n) {
            if (national.equals(i)) {
                this.national = national; break;
            } else {
                this.national = "한국";
            }
        }
    }


    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public void adoptDog(Dog dog) {
//        this.dog = dog;
//    }

    public void adoptDog(String dog) {
        System.out.println("강아지를 입양했다 !");
        Dog dog1 = new Dog(dog);
        this.dog = dog1;
    }


//    public void teachDog(int num) {
//        dog.learnAility(num);
//    }

//    public void teachDog(int num) {
//        //재주를 가르치자
//        dog.learnAility(num);
//    }

    public void teachDog(String[] str) {
        dog.setPlay(str);
    }

    //getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNational() {
        return national;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", national='" + national + '\'' +
                ", dog='" + dog + "'" +
                '}';
    }
}
