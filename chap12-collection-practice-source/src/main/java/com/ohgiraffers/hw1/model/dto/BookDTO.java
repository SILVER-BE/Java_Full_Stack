package com.ohgiraffers.hw1.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    //초기화
    private int bNo;
    private int category;
    private String title;
    private String author;

    //기본 생성자
    public BookDTO() {}

    //도서 제목, 도서 장르, 도서 제자 매개변수를 가진 생성자
    public BookDTO(int bNo, String title, int category, String author) {
        this.bNo = bNo;
        this.title = title;
        this.category = category;
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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bNo=" + bNo +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
