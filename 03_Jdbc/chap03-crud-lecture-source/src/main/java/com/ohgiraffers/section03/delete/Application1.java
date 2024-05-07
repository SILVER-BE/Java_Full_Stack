package com.ohgiraffers.section03.delete;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        /* 1. 삭제할 메뉴 코드 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴의 코드를 입력하세요 : ");
        int deleteMenu = sc.nextInt();

        /* 2. DeleteController의 deleteMenu() 메소드 호출 */
        DeleteController deleteController = new DeleteController();
        int result = deleteController.deleteMenu(deleteMenu);

        System.out.println("result = " + result);
        /* 3. delete 결과에 따라 성공이면 '메뉴 삭제 성공!', 아니면 '메뉴 삭제 실패' */
        if(result > 0) {
            System.out.println("메뉴 삭제 성공!");
        } else {
            System.out.println("메뉴 삭제에 실패했습니다.");
        }
        /* entry key = "deleteMenu" */

    }
}
