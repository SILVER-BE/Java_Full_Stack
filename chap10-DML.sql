/* DML(Data Manipulation Language) */
-- 데이터 조작언어, 테이블에 값을 삽입하거나 수정·삭제하는 SQL의 한 부분이다.

-- 1. INSERT : 새로운 행을 추가하는 구문
SELECT * FROM tbl_menu;
INSERT INTO tbl_menu VALUES (null, '바나나해장국', 8500, 4, 'Y');

-- NULL 허용 가능한(NULLABLE)컬럼이나 AUTO_INCREMENT가 있는 컬럼을 제외하고 
-- INSERT하고 싶은 데이터 컬럼을 지정해서 INSERT 가능하다.

INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
VALUES('초콜릿죽', 6500, 7, 'Y');
SELECT * FROM tbl_menu;

-- 컬럼을 명시하면 INSERT시 데이터의 순서를 바꾸는 것도 가능하다.
INSERT INTO tbl_menu(orderable_status, menu_price, menu_name, category_code)
VALUES('Y', 5500, '파인애플탕', 4);
SELECT * FROM tbl_menu;

INSERT INTO
	tbl_menu
VALUES
	(null, '참치맛아이스크림', 1700, 12, 'Y'),
	(null, '멸치아이스크림', 1500, 11, 'Y'),
	(null, '소시지맛커피', 2500, 8, 'Y');
    
-- 2. UPDATE : 테이블에 기록된 컬럼의 값을 수정하는 구문

SELECT
	menu_code,
    category_code
FROM
	tbl_menu
WHERE
	menu_name = '파인애플탕';
    
update tbl_menu
set 
	category_code = 7
where
	menu_code = 24;
    
update tbl_menu
set
	category_code = 6
where
	menu_code = (SELECT
					menu_code
				FROM
					tbl_menu
				WHERE
					menu_name = '파인애플탕');	
                    
-- UPDATE나 DELETE시 자기 자신 테이블의 데이터를 사용 시 에러 발생  
                    
UPDATE tbl_menu
SET
	category_code = 6
WHERE
	menu_code = (SELECT
					tmp.menu_code
				FROM (SELECT
						menu_code
					FROM
                        tbl_menu
					WHERE
						menu_name = '파인애플탕') tmp 
);

-- 3. DELETE : 테이블의 행을 삭제하는 구문이다.
DELETE FROM tbl_menu
ORDER BY menu_price 
LIMIT 2; -- 가격순으로 정렬 후 맨 위 두가지 삭제됨

-- WHERE절을 활용한 행 삭제
DELETE FROM
	tbl_menu
WHERE
	menu_code = 24;
    
DELETE FROM tbl_menu;
SET SQL_SAFE_UPDATES = 0; -- 세이프 업데이트 모드 비활성화
SET SQL_SAFE_UPDATES = 1; -- 세이프 업데이트 모드 활성화

-- 4. REPLACE : INSERT시 PRIMARY KEY또는 UNIQUE KEY가 중복이 발생할 수 있다면
--				REPLACE를 통해 중복된 데이터를 덮어 쓸 수 있다.

INSERT INTO tbl_menu VALUES (17, '참기름소주', 5000, 10, 'Y');
REPLACE INTO tbl_menu VALUES (17, '참기름소주', 5000, 10, 'Y');
REPLACE tbl_menu VALUES (17, '참기름소주', 5000, 10, 'Y');

REPLACE tbl_menu
SET menu_code = 2,
	menu_name = '우럭쥬스',
    menu_price = 2000,
    category_code = 9,
    orderable_status = 'N';
