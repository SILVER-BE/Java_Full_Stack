/* SELECT절
	MySQL의 가장 기본적인 명령어로 특정 테이블에서 원하는 데이터를 조회해서 가져오는데 사용 된다. */
    
SELECT
	menu_name
FROM
	tbl_menu;
    
SELECT
	menu_code,
	menu_name,
	menu_price
FROM
	tbl_menu;
    
SELECT
	menu_code,
	menu_name,
	menu_price,
	category_code,
	orderable_status
FROM
	tbl_menu;
    
SELECT * FROM tbl_menu;

/* 단독 SELECT */
SELECT 6 + 3;
SELECT 6 * 3;
SELECT 6 % 3;

SELECT NOW();
SELECT CONCAT('홍.',' ','길동');

SELECT CONCAT('홍',' ','길동') AS name;
SELECT CONCAT('홍',' ','길동') AS 'Full name';


