package com.ohgiraffers.rpg.dto;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Item> bag = new ArrayList<>();
    public Bag() {}

    public void printBag() {
        for(Item item : bag) {
            System.out.println(item);
        }
    }

    public void hiItem(Item item) {
        bag.add(item);
    }

    public void byeItem(Item item) {
        bag.remove(item);
    }

}
