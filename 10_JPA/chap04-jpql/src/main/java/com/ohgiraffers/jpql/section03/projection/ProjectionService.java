package com.ohgiraffers.jpql.section03.projection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectionService {

    private  ProjectionRepository projectionRepository;

    public ProjectionService (ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    // 수정해도 영속성 컨텍스트 안에서 관리가 되는지? (영속화 되어있는 객체인지 아닌지)
    @Transactional
    public List<Menu> singleEntityProjection() {
        List<Menu> menuList = projectionRepository.SingleEntityProjection();
        menuList.get(0).setMenuName("맛있는 유니콘 고기");
        return menuList;
    }


}
