package com.hw1.model.dto;

public class CookBook extends Book {

    private boolean coupon;

    //기본 생성자
    public CookBook() {}

    //매개변수 있는 생성자
    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    //setter
    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }

    //getter
    public boolean isCoupon() {
        return coupon;
    }

    //toString()

    @Override
    public String toString() {
        return super.toString()
                + "coupon=" + coupon;
    }
}
