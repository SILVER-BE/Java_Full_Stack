package com.ohgiraffers.section02.extend;

/* 인터페이스 상속 시 implemetns 키워드 대신 extends 사용한다. */
//public class RabbitFarm<T implements Animal> {} <-- 에러 발생, implements 사용 불가
public class RabbitFarm<T extends Rabbit & Animal> {
    //토끼이거나 토끼 후손만 가능한 상태가 됨

    /* & 로 여러 타입을 동시에 가지는 타입 변수를 지정할 수 있다. (&로 묶어준 모든 타입에 해당해야함)
    * 단, 클래스는 하나만 지정할 수 있으며 &의 맨 앞에는 클래스, 이후로는 인터페이스가 와야한다. */

    private T animal;//정해지지 않은 타입으로 animal 지정

    public RabbitFarm() {}; //기본 생성자

    public RabbitFarm(T animal) {   //변수 생성자
        this.animal = animal;
    }

    //setter
    public void setAnimal(T animal) {
        this.animal = animal;
    }

    //getter
    public T getAnimal() {
        return this.animal;
    }



}
