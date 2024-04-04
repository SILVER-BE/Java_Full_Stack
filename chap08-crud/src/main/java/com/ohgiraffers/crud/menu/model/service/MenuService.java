package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {

        return menuMapper.findAllMenu();
    }

    @Transactional(readOnly = true) //읽기 전용으로 설정
    public List<CategoryDTO> findCategoryList() {

        return menuMapper.findCategoryList();
    }

    //트랜잭션 처리를 해주려면..
    @Transactional
    public void registMenu(MenuDTO menu) {

        menuMapper.registMenu(menu);
    }
}
