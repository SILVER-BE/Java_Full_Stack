package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCycleTests {

    private EntityLifeCycle lifeCycle;

    @BeforeEach
    void setup() {
        this.lifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testTransient(int menuCode) {
        //when
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode); // 영속성 컨텍스트에서 키와 값으로 관리 됨

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );                                                      // 값(데이터)는 같으나 다른 객체 (값만 똑같이 옮긴 것)

        EntityManager entityManager = lifeCycle.getEntityManagerInstance();


        //then
        assertNotEquals(foundMenu, newMenu);
        assertTrue(entityManager.contains(foundMenu));  // foundMenu는 영속성 컨텍스트에서 관리되는 영속 상태의 객체 (엔티티 매니저에서 가져왔기 때문에)
        assertFalse(entityManager.contains(newMenu));   // newMenu는 연속성 컨텍스트에서 관리되지 않는 비영속성 상태의 객체
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManageOtherEntityManager(int menuCOde) {
        //when
        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCOde);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCOde);

        //then
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManageSameEntityManager(int menuCOde) {
        // 같은 엔티티가 관리해야해서 여기에 엔티티 매니저 객체 생성
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        //when
        Menu menu1 = entityManager.find(Menu.class, menuCOde);
        Menu menu2 = entityManager.find(Menu.class, menuCOde); // 이미 있는 값이라 가지고 있는 객체를 반환해주는 동작이 일어남 (결국 똑같은 객체를 반환 받음)

        //then
        assertEquals(menu1, menu2); // 그래서 같은 주소값을 가지고 있게 된다.
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        //when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //detach : 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하던 객체를 관리하지 않는 상태)로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice); // 1,000원

        //flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. commit 하지 않은 상태이므로 rollback 가능하다.
        entityManager.flush();

        //then
        assertNotEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice()); // 10,000원
        entityTransaction.rollback();
    }

    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        //when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice); // 1,000원
        // merge : 파라미터로 넘어온 준영속 엔티티 객체의 식별자 값으로 1차 캐시에서 엔티티 객체를 조회 한다.
        // (없으면 DB에서 조회하여 1차 캐시에 저장한다.)
        // 조회한 영속 엔티티 객체에 준영속 상태의 엔티티 객체의 값을 병합한 뒤 영속 엔티티 객체를 반환한다.
        // 혹은 조회할 수 없는 데이터라면 새로 생성해서 병합한다.
        entityManager.merge(foundMenu);
        entityManager.flush();

        //then
        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice()); // 10,000원
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽", "12, 까만 딸기탕후루"})
    void testMergeUpdate(int menuCode, String menuName) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);

        //when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);

        entityManager.merge(foundMenu);

        //then
        assertEquals(menuName, refoundMenu.getMenuName());
        //           └하양 민트초코죽             └DB에 저장된 11번의 원래 이름
    }

    @DisplayName("detach 후 merge한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20);
        entityManager.detach(foundMenu);

        //when
        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        foundMenu.setMenuCode(999); // 존재하지 않는 코드값으로 변경
        entityManager.merge(foundMenu);
        entityTransaction.commit();

        //then
        assertEquals("치약맛 초코 아이스크림", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClearPersistenceContext(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        //clear : 영속성 컨텍스트를 초기화 한다. -> 영속성 컨텍스트 내의 모든 엔티티를 준영속화 시킨다.
        entityManager.clear();

        //then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(foundMenu, expectedMenu);
    }

    @DisplayName("영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClosePersistenceContext(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        //close : 영속성 컨텍스트를 종료한다.
        entityManager.close();

        //then
        assertThrows(IllegalStateException.class, // 이 오류가 난다면 테스트 성공
                () -> entityManager.find(Menu.class, menuCode)
        );
    }

    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testRemoveEntity(int menuCode) {
        //given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        //when
        entityTransaction.begin();

        //remove : 엔티티를 영속성 컨텍스트 및 데이터 베이스에서 삭제
        //단, 트랜잭션을 제어하지 않으면 데이터 베이스에서 영구 반영 되지는 않는다.
        //트랜잭션을 커밋하는 순간 영속성 컨텍스트에서 관리하는 엔티티 객체가 데이터 베이스에 반영 된다.
        entityManager.remove(foundMenu);
        //flush : 영속성 컨텍스트의 변경 내용을 데이터 베이스에 동기화하는 작업
        entityManager.flush();

        //then
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        assertNull(refoundMenu);
        entityTransaction.rollback(); // 롤백으로 DB가 지워지지 않게 된다. (커밋하지 않으면 가능 !!)
    }

}
