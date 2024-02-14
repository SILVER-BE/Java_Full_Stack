package com.hw1.view;

import com.hw1.controller.LibraryManager;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.Member;

import java.util.Scanner;

public class LibraryMenu {

    private LibraryManager Lm;

    LibraryManager lm = new LibraryManager();

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();

        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("성별을 입력하세요 : ");
        char gender = sc.next().charAt(0);

        Member mem = new Member(name, age, gender);

        //인서트멤버에 값 전달
        lm.insertMember(mem);

        while (true) {
            System.out.println("==== 메뉴 ====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("0. 프로그램 종료하기");

            System.out.print("메뉴를 선택하세요 : ");
            int sel = sc.nextInt();

            switch (sel) {
                case 1 :
                    System.out.println(lm.myInfo()); break;
                case 2 :
                    Book[] bList = lm.selectAll();

                    for(int i = 0; i < bList.length; i++) {
                        System.out.println(bList[i]);
                    }
                    break;
                case 3 :
                    System.out.print("키워드를 입력하세요 : " + sc.nextLine());
                    String keyword = sc.nextLine();
                    lm.searchBook(keyword);

                    Book[] searchBook = lm.searchBook(keyword);

                    for(Book b : searchBook) {
                        System.out.println(b);
                    }

                    break;
                case 4 :
                    lm.selectAll();
                    System.out.print("대여할 도서를 선택하세요 : ");
                    int result = lm.rentBook(sc.nextInt());

                    switch (result) {
                        case 0 : System.out.println("성공적으로 대여되었습니다."); break;
                        case 1 : System.out.println("나이 제한으로 대여 불가능합니다."); break;
                        case 2 : System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인하세요."); break;
                    }
            }

        }


    }
}

