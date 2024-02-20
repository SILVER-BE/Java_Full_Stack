package com.ohgiraffers.rpg.dto;

import java.util.ArrayList;

public class ClothesShop {

    private final Clothes[] clothesList = new Clothes[4];

    public ClothesShop() {
        clothesList[0] = new Clothes("정장", 100000, 30);
        clothesList[1] = new Clothes("셔츠와 청바지", 25000, 5);
        clothesList[2] = new Clothes("체크 셔츠에 멜빵바지", 15000, -10);
        clothesList[3] = new Clothes("구찌백", 1000000, -1000);
    }




}
