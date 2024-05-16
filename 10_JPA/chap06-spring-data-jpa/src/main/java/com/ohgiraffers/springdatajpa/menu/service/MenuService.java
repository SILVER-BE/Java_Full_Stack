package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자를 자동으로 생성해준다 (의존성 주입)
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* 1. findById */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(foundMenu, MenuDTO.class); //Entity -> MenuDTO 가공
    }

    /* 2. findAll : Sort */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 3. findAll : Pageable */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,   //현재 보고있는 페이지 (=offset) (실제 '1' 페이지면 여기선 '0'이어야 함)
                pageable.getPageSize(),     //한 페이지에 몇 개의 글을 볼 것인지 (=limit)
                Sort.by("menuCode").descending()
        );
        Page<Menu> menuList = menuRepository.findAll(pageable);
        return menuList
                .map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* 4. Query Method */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {

//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);

        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(
                menuPrice,
                Sort.by("menuPrice").descending()
        );

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }


    /* 5. JPQL or Native Query */
    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* 6. save */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {

        //DTO 를 Entity 타입으로 바꿔주기
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }

    /* 7. modify ( 엔티티 객체 필드 값 변경 ) */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {

        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode()).orElseThrow(IllegalArgumentException::new);

        foundMenu.modifyMenuName(menuDTO.getMenuName());

        //변경이 감지되어 업데이트가 자체적으로 진행
    }

    /* 8. deleteById */
    @Transactional
    public void deleteMenu(Integer menuCode) {

        menuRepository.deleteById(menuCode);
    }
}
