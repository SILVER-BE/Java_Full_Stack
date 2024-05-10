package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_menu")
public class EmbeddedMenu {

    @Id
    private int menuCode;

    @Embedded // 엔티티가 아님
    private MenuInfo menuInfo;

    private int categoryCode;
    private String orderableStatus;

    public EmbeddedMenu() {};


}
