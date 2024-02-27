/* SET_OPERATORS */

-- UNION : 두 개 이상의 SELECT문의 결과를 결합하여 중복된 레코드를 제거 후 반환

SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = 10

UNION
    
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	menu_price < 9000; -- 중복된 결과 제거 후 반환
    
-- UNION ALL

SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = 10

UNION ALL
    
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	menu_price < 9000; -- 중복된 결과 제거하지 않고 모두 반환
    
-- INTERSECT : 두 SELECT문의 결과 중 공통되는 레코드만을 반환 !!
-- MySQL은 제공하지 않는다. 하지만 INNER JOIN 또는 IN 연산자를 활용해서 구현 가능

select
	a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
From
	tbl_menu a
INNER JOIN (select
				menu_code,
                menu_name,
                menu_price,
                category_code,
                orderable_status
			FROM
				tbl_menu
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code) 
                -- 1. 9000원 미만인 메뉴를 먼저 조회(서브쿼리)
				-- 2. on 뒤의 조건이 일치한다면 메인쿼리와 조인 (서브쿼리가 메인쿼리의 일부이기 때문에 서브쿼리만 남을 것)
                -- 3. 카테고리 10인 값만 반환
WHERE
	a.category_code = 10;
    
-- IN 이용

SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
from
	tbl_menu
where
	category_code = 10 and
    menu_code IN (select
						menu_code -- code와 code를 제한!
					From
						tbl_menu
					where
						menu_price < 9000);
                        

-- MINUS : 첫번째 SELECT문의 결과에서 두번째 SELECT문의 결과가 포함하는 레코드를 제외하고 반환
-- MySQL은 MINUS를 제공하지 않음. LEFT JOIN을 활용해서 구현하는 것은 가능하다.

SELECT
	a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status,
    b.menu_price,	-- null 값	
    b.menu_name 	-- 잘 확인하게 넣음 !!
FROM
	tbl_menu a
LEFT JOIN (SELECT
				menu_code,
                menu_name,
                menu_price,
                category_code,
                orderable_status
			FROM
				tbl_menu
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
	b.menu_code IS NULL AND
    a.category_code = 10;
    
    -- b 테이블의 null 값만 출력하기 때문에 a에서 b를 뺀 값이 출력됨
                

