package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.comparator.AscCategory;
import com.ohgiraffers.hw1.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;

public class BookManager {

    ArrayList<BookDTO> bookList = new ArrayList<>();

    public void addBook (BookDTO book) {
        bookList.add(book);

        System.out.println("입력된 도서 갯수 : " + bookList.size());
        System.out.println("입력된 도서 목록 : " + bookList);
    }

    public void deleteBook(int index) {
        bookList.remove((index) -1);
    }

    public void displayAll() {
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }

    public int searchBook(String title) {
        int result = 0;
        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.contains(title)) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public void printBook(int index) {
        System.out.println(bookList.get((index)));
    }

    public ArrayList<BookDTO> sortedBookList (int select) {
        if(select == 1) {
            bookList.sort(new AscCategory());
            return bookList;
        } else if(select == 2) {
            bookList.sort(new DescCategory());
            return bookList;
        } else {
            System.out.println("정렬에 실패했습니다.");
        }
        return bookList;
    }

    public void printBookList (ArrayList<BookDTO> br) {
        for(BookDTO book : bookList) {
            System.out.println(book);
        }
    }






}
