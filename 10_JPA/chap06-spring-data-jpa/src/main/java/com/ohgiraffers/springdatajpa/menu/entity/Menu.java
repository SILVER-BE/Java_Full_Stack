package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_menu")
@Getter //값을 꺼내오는거라 사용해도 무방
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
/* @AllArgsConstructor : 이것도 지양 */
/* @ToString : 사용 가능하나 연관 관계 매핑 필드는 제거하고 사용 */
/* @Setter 지양 : 객체를 언제든지 변경할 수 있으면 객체의 안전성 보장 X
* 값 변경이 필요한 경우에는 해당 기능을 위한 메소드를 별도로 생성 */
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    /* 메뉴이름을 변경해주는 메소드 */
    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }
}
