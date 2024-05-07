package com.ohgiraffers.section02.superkeyword;

import java.util.Date;
public class Product {

    private String code;    //상품코드
    private String brand;   //제조사
    private String name;    //상품명
    private int price;      //가격
    private Date manufacturingDate; //제조일자

    public Product() {
        System.out.println("Product 클래스의 기본생성자 호출함");
    }

    //필드 초기화 생성자 : alt + insert -> constructor
    public Product(String code, String brand, String name, int price, Date manufacturingDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;

        System.out.println("Product 클래스의 매개변수 있는 생성자 호출함");
    }

    //setter : alt + insert -> setter
    public void setCode(String code) {
        this.code = code;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }


    //getter : alt + insert -> getter
    public String getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public String getInformation() {
        return "Product [code=" + code + ", brand=" + brand + ", name=" + name
                + ", price=" + price + ", manufacturingDate=" + manufacturingDate + "]";
    }

}
