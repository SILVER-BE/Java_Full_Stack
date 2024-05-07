package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);

    //메인메뉴 출력, 각 메뉴에 해당하는 메소드 실행, 반복 출력
    public void mainMenu() {
        while (true) {
            System.out.println("*** 도서 관리 프로그램 ***");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색 출력");
            System.out.println("5. 전체 출력");
            System.out.println("6. 끝내기");
            System.out.println("========================");

            System.out.print("프로그램을 선택하세요 : ");
            int select = sc.nextInt();

            BookManager bookManager = new BookManager();
            switch (select) {
                case 1:
                    bookManager.addBook(inputBook());
                    break;
                case 2:
//                    BookDTO bookDTO = new BookDTO();
//                    List<BookDTO> bookSelect = bookDTO.bookList;
//
//                    BookManager bookManager2 = new BookManager();
//                    System.out.println("도서 정렬 방식을 선택하세요.");
//                    System.out.println("1. 도서번호 오름차순 정렬");
//                    System.out.println("2. 도서번호 내림차순 정렬");
//                    System.out.println("3. 책 제목 오름차순 정렬");
//                    System.out.println("4. 책 제목 내림차순 정렬");
//                    System.out.println("=======================");
//                    System.out.print("번호를 선택하세요 : ");
//                    sc.nextLine();
//                    int num = sc.nextInt();
//                    bookManager2.sortedBookList(num);
//
//                    bookManager2.printBookList(bookSelect);
                    break;

                case 3: break;
                case 4: break;
                case 5:
                    bookManager.displayAll();
                    break;
                case 6: break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }

    public BookDTO inputBook() {
        System.out.print("도서 번호 : ");
        int bNo = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 제목 : ");
        String title = sc.next();
        sc.nextLine();

        System.out.println("1. 인문 / 2. 자연과학 / 3. 의료 / 4. 기타");
        System.out.print("도서 장르 : ");
        int category = sc.nextInt();

        sc.nextLine();
        System.out.print("도서 저자 : ");
        String author = sc.nextLine();

        BookDTO newbook = new BookDTO(bNo, title, category, author);
        return newbook;
    }

    public int inputBookNo() {

        //도서 번호로 도서 삭제 기능으로 변경...
        System.out.print("도서 번호 : ");
        int inbNo = sc.nextInt();

        return inbNo;
    }

    public String inputBookTitleNo() {

        //도서 검색 출력 기능으로 변경...
        System.out.print("도서 제목 : ");
        String intitle = sc.nextLine();

        return intitle;
    }

//    Public List<BookDTO> selectSortedBook() {
//          //도서 정렬방식을 정수로 입력받아서
            // 1. 도서번호 오름차순
            // 2. 도서번호 내림차순
            // 3. 책 제목으로 오름차순
            // 4. 책 제목으로 내림차순
            // BookManager 객체의 sortedBookList() 메소드 이용하여 출력
//    }



}
