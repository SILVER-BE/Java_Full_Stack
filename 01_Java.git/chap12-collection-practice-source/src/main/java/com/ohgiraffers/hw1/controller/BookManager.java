package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.comparator.AscBookNO;
import com.ohgiraffers.hw1.comparator.AscBookTitle;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.*;

public class BookManager {

    private ArrayList<BookDTO> bookList = new ArrayList<>();

    public BookManager() {
    }

    public void addBook(BookDTO book) {
        bookList.add(book);
        System.out.println("저장된 도서 : " + bookList.size());
        System.out.println("저장된 도서 정보 : " + bookList);
    }

    public void deleteBook(int key) {
        bookList.remove(key);
    }

    public void searchBook(String title) {
        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.contains(title)) {
                System.out.println(bookList.contains(title));
            } else {
                System.out.println("조회된 도서가 목록에 없습니다.");
            }
        }
    }

    public void displayAll() {
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }

    public List<BookDTO> sortedBookList(int type) { //List<BookDTO> ...
        switch (type) {
            case 1 :
                bookList.sort(new AscBookNO());
                break;
            case 2 :
                bookList.sort(new AscBookTitle());
                break;
        }

        return bookList;
    }

    public void printBookList(List<BookDTO> printList) {

        for(BookDTO book : bookList) {
            System.out.println(book);
        }

    }






}
