package com.hw1.model.dto;

public class AniBook extends Book{

    private int accessAge;

    //기본 생성자
    public AniBook() {}

    //매개변수 있는 생성자
    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        this.accessAge = accessAge;
    }

    //setter
    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }

    //getter
    public int getAccessAge() {
        return accessAge;
    }

    //toString()
    @Override
    public String toString() {
        return super.toString() +
                "accessAge=" + accessAge;
    }
}
