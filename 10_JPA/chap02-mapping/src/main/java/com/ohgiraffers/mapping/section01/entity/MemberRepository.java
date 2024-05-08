package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    // 알아서 의존성 주입받아 사용할 수 있음 (엔티티 객체 만드는 과정 생략 가능)
    @PersistenceContext
    private EntityManager entityManager;

    // 전달받은 Member 라는 Entity 를 저장한다.
    public void save(Member member) {
        entityManager.persist(member);
    }

    // 저장된 아이디를 기준으로 이름을 반환한다.
    public String findNameById(String memberId) {
        //                                          ┌ Entity name ( Table name X )
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";
        //                                                   └ alias 별칭은 필수

        return entityManager.createQuery(jpql, String.class).getSingleResult();
        //                                      └ 반환받고자 하는 타입
    }







}
