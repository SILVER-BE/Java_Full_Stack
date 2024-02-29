package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 변경할 메뉴 코드, 이름, 가격을 입력 받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴의 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();
        System.out.print("메뉴의 이름을 어떻게 변경하시겠습니까? : ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("메뉴의 가격을 어떻게 변경하시겠습니까? : ");
        int menuPrice = sc.nextInt();

        /* 2. MenuDTO 객체를 생성하여 입력받은 값으로 setting */
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuCode(menuCode);
        newMenu.setMenuPrice(menuPrice);

        /* 3. UpdateController의 updateMenu() 메소드 호출 */
        updateController upController = new updateController();
        int result = upController.updateMenu(newMenu);
        System.out.println("newMenu = " + newMenu);
        System.out.println("result = " + result);

        /* 4. update 결과에 따라 성공, 실패 메세지 출력 */
        if(result > 0) {
            System.out.println("메뉴 변경 성공 !");
        } else {
            System.out.println("메뉴 변경에 실패했습니다 ....");
        }
    }
}
