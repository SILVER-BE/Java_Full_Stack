package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    public static void main(String[] args) {

        /* [ 와일드 카드 ]
        * 제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때,
        * 그 객체의 타입 변수를 제한할 수 있다.
        *
        *
        * <?> : 제한 없음
        * <? extends Type> : 와일드카드의 상한 제한 (Type과 Type의 후손을 이용해 생성한 인스턴스만 인자로 사용 가능)
        * <? super Type> : 와일드카드의 하한 제한 (Type과 Type의 부모를 이용해 생성한 인스턴스만 인자로 사용 가능
        * */

        /* 제한된 토끼농장을 사용해보자 */
        WildCardFarm wcf = new WildCardFarm();

        /* <?> */
//        wcf.anyType(new RabbitFarm<Mammal>(new Mammal()));
//        wcf.anyType(new RabbitFarm<Reptile>(new Reptile()));
        wcf.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wcf.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wcf.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        /* <? extends Bunny > */ //Rabbit은 Bunny의 부모
//        wcf.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));
        wcf.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wcf.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        /* <? super Bunny> */
        wcf.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wcf.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wcf.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny())); <--에러




    }
}
