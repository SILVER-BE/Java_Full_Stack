package com.ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Section01Menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    private int categoryCode;
    private String orderableStatus;

    public Menu() {};

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Menu{");
        sb.append("menuCode=").append(menuCode);
        sb.append(", menuName='").append(menuName).append('\'');
        sb.append(", menuPrice=").append(menuPrice);
        sb.append(", categoryCode=").append(categoryCode);
        sb.append(", orderableStatus='").append(orderableStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
