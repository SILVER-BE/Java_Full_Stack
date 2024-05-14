package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //빈 등록은 저절로 된다네요

//    @Query("SELECT c FROM Category c ORDER BY c.categoryCode")
    @Query(value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code",
    nativeQuery= true)
    List<Category> findAllCategory();

}
