package com.ohgiraffers.section01.polymorphism;

public class Application3 {
    public static void main(String[] args) {

        Application3 app3 = new Application3();

        Animal animal1 = new Cat();
        Animal animal2 = new Tiger();

        app3.feed(animal1);     //동일한 타입이기 때문에 가능함
        app3.feed(animal2);

        Cat animal3 = new Cat();
        Tiger animal4 = new Tiger();

        app3.feed((Animal) animal3);    //명시적 형변환 (업캐스팅)
        app3.feed(animal4);             //묵시적 형변환
        app3.feed(new Cat());
        app3.feed(new Tiger());

    }

    public void feed(Animal animal) {
        animal.eat();
    }

    /* 다형성을 적용하지 않았다면.. */
//    public void feed(Cat cat) {
//    }
//    public void feed(Tiger tiger) {
//
//    } <-- 모두 작성해야했음
}
