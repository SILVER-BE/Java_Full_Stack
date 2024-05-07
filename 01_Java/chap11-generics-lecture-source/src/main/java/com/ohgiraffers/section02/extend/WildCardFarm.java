package com.ohgiraffers.section02.extend;

public class WildCardFarm {

    /* WildCard 를 통해
    * RabbitFarm 에 들어올 토끼의 종류를 제한해주자....*/

    /* 토끼농장에 있는 토끼가 어떤 토끼이던 상관없다. */
    public void anyType(RabbitFarm<?> farm) {
        farm.getAnimal().cry();
    }

    /* 토끼농장의 토끼는 Bunny이거나 그 후손 타입으로 만들어진 토끼농장만 매개변수로 사용 가능 */
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getAnimal().cry();
    }

    /* Bunny 이거나 그 부모타입으로 만들어진 토끼농장만 매개변수로 사용 가능 */
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getAnimal().cry();
    }


}
