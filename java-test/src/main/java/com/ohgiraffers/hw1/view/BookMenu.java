package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    public BookMenu() {}

    private BookManager bm = new BookManager();
    Scanner sc = new Scanner(System.in);

    public void menu() {

        while(true) {
            System.out.println("** 프로그램 목록 **");
            System.out.println("1. 새로운 도서 등록");
            System.out.println("2. 등록한 도서 삭제");
            System.out.println("3. 등록된 전체 도서 목록 조회");
            System.out.println("4. 제목으로 도서 목록 조회");
            System.out.println("5. 정렬 기능을 이용한 도서 목록 조회");
            System.out.println("================================");
            System.out.print("프로그램을 선택하세요 : ");
            int selectNum = sc.nextInt();

            switch (selectNum) {
                case 1:
                    bm.addBook(inputBook());
                    System.out.println("입력을 완료 했습니다.");
                    break;
                case 2 :
                    System.out.println("** 등록된 도서 목록 **");
                    bm.displayAll();
                    System.out.println("================================");
                    System.out.print("어떤 도서 정보를 삭제하시겠습니까? : ");
                    int index = sc.nextInt();
                    bm.deleteBook(index);

                    System.out.println("도서 정보가 삭제되었습니다.");
                    break;
                case 3:
                    System.out.println("** 등록된 도서 목록 **");
                    bm.displayAll();
                    break;
                case 4:
                    String title = inputBookTitle();
                    System.out.println("검색어 : " + title);

                    int result = bm.searchBook(title);
                    System.out.println("반환값 : " + result);

                    System.out.println("** 해당 검색어로 조회된 도서 목록입니다. **");
                    bm.printBook(result);

                    break;
                case 5:
                    System.out.println("** 정렬 방식 **");
                    System.out.println("1. 오름 차순 정렬 / 2. 내림 차순 정렬");
                    System.out.print("정렬 방식을 선택해주세요 : ");
                    int select = sc.nextInt();
                    ArrayList<BookDTO> sortedBookList = bm.sortedBookList(select);
                    bm.printBookList(sortedBookList);
                    break;
            }

        }

    }

    public BookDTO inputBook() {
        System.out.print("도서 번호를 입력하세요 : ");
        int bNo = sc.nextInt();

        System.out.println("1. 인문 / 2. 자연과학 / 3. 의료 / 4. 기타");
        System.out.print("카테고리를 선택하세요 : ");
        int category = sc.nextInt();

        System.out.print("제목을 입력하세요 : ");
        String title = sc.next();
        sc.nextLine();

        System.out.print("저자를 입력하세요 : ");
        String author = sc.nextLine();

        BookDTO newbook = new BookDTO(bNo, category, title, author);
        return newbook;
    }

    public String inputBookTitle() {
        System.out.print("검색할 도서 제목을 입력하세요 : ");
        String title = sc.next();

        return title;
    }


}
