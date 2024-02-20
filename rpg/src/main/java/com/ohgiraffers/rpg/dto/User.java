package com.ohgiraffers.rpg.dto;

public class User {

    private String name;
    private int charm;
    private Bag bag = new Bag();
    private Item equipmentsItem;
    private int money;

    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Item getEquipmentsItem() {
        return equipmentsItem;
    }

    public void setEquipmentsItem(Item equipmentsItem) {
        this.equipmentsItem = equipmentsItem;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void wearOn(Item item) {
        this.setEquipmentsItem(item);
        this.setCharm(this.getCharm() + item.getCharm());
    }

    public void alba(int type) {

    }

    public void makeMoney(int money) {
        this.setMoney(this.getMoney() + money);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", charm=" + charm +
                ", bag=" + bag +
                ", equipmentsItem=" + equipmentsItem +
                ", money=" + money +
                '}';
    }
}
