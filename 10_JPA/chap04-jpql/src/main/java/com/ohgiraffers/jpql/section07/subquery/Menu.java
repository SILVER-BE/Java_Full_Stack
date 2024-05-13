package com.ohgiraffers.jpql.section07.subquery;

import com.ohgiraffers.jpql.section06.join.Category;
import jakarta.persistence.*;

@Entity(name = "Section07Menu")
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
