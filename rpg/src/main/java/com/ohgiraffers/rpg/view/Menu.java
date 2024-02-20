package com.ohgiraffers.rpg.view;

import com.ohgiraffers.rpg.controller.Manager;

import java.util.Scanner;

public class Menu {

    public Menu() {}
    private Scanner sc = new Scanner(System.in);
    private Manager manager = new Manager();

    public void menu() {
        while (true) {
            System.out.println("============ 메뉴 ============");
            System.out.println("1. 내 상태");
            System.out.println("2. 소지품 보기");
            System.out.println("3. 대화하기");
            System.out.println("4. 쇼핑하기");
            System.out.println("5. 아르바이트 하기");
            System.out.println("6. 호감도 확인하기");
            System.out.println("7. 종료");
            System.out.println("============================");
            System.out.println("번호를 선택하세요 : ");
            int selectNum = sc.nextInt();
            sc.nextLine();

            switch (selectNum) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("어느 아르바이트를 하러 갈까?");
                    System.out.println("1. 편의점 / 2. 영화관 / 3. 식당");
                    System.out.println("============================");
                    System.out.println("번호를 선택하세요 : ");
                    int selectNum2 = sc.nextInt();
                    sc.nextLine();
                    manager.alba(selectNum2);
                    break;
                case 6: break;
                case 7: return;
            }
        }
    }

}
