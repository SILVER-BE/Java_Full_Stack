package com.ohgiraffers.hw1.model.dto;

public class BookDTO {

    private int bNo;
    private int category;
    private String title;
    private String author;

    public BookDTO() {}

    public BookDTO(int bNo, int category, String title, String author) {
        this.bNo = bNo;
        this.category = category;
        this.title = title;
        this.author = author;
    }

    //setter
    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //getter
    public int getbNo() {
        return bNo;
    }

    public int getCategory() {
        return category;
    }

    public String getTitle() {return title;
    }

    public String getAuthor() {
        return author;
    }

    //toString()
    @Override
    public String toString() {
        return "도서 번호 : " + bNo +
                " / 분류 : " + category +
                " / 제목 : " + title +
                " / 저자 : " + author;
    }
}
