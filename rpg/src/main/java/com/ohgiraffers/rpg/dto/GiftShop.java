package com.ohgiraffers.rpg.dto;

public class GiftShop {

    private final Gift[] giftList = new Gift[4];

    public GiftShop() {
        giftList[0] = new Gift("꽃다발", 30000, 20);
        giftList[1] = new Gift("케이크", 45000, 30);
        giftList[2] = new Gift("발가락 양말", 3000, -20);
        giftList[3] = new Gift("슈퍼카", 100000000, -1000);
    }
    
}
