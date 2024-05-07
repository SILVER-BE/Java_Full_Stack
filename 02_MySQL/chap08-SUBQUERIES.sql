/* SUBQUERY */

select
	category_code
from
	tbl_menu
where
	menu_name = '민트미역국';

/* MAINQUERY */
-- 메인 쿼리에 서브 쿼리를 넣어보자 !

SELECT
	menu_code,
	menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu;
    
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu
WHERE
	category_code = (SELECT
						category_code
					FROM
						tbl_menu
					WHERE
						menu_name = '민트미역국'); -- 민트미역국의 카테고리 코드를 가지고 있는 메뉴들만 출력됨
												-- 4를 입력할 수도 있겠지만 민트미역국의 카테고리가 변경되거나 정확히 모를 경우 사용
                                                
--

SELECT
	COUNT(*) AS 'count'
FROM
	tbl_menu
GROUP BY category_code;

/* FROM 절에 쓰인 서브쿼리는 반드시 자신의 별칭이 있어야 한다. */
SELECT
	MAX(count)
FROM
	(SELECT
		COUNT(*) as 'count'
	FROM
		tbl_menu
	GROUP BY category_code) AS countmenu; -- 별칭!
    
--

SELECT
	AVG(menu_price)
FROM
	tbl_menu
WHERE
	category_code = 4;
    
/* 카테고리별 평균 가격보다 높은 가격의 메뉴 조회 */
SELECT
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
	tbl_menu a
WHERE
	menu_price > (SELECT
					AVG(menu_price)
				FROM
					tbl_menu
				WHERE
					category_code = a.category_code);

/* EXISTS */
-- 조회 결과가 있을 때 true 아니면 false

/* 메뉴가 있는 카테고리 조회 */
SELECT
	category_name
FROM
	tbl_category a
WHERE
	EXISTS(SELECT
				1 -- 의미없는 상수 넣어준거임
			FROM
				tbl_menu b
			WHERE
				b.category_code = a.category_code
			)
ORDER BY 1; -- 메뉴가 있는 카테고리 메뉴만 정렬되어 출력

/* CTE(Common Table Expressions) */
-- 파생테이블과 비슷한 개념이며 코드의 가독성과 재사용성을 위해 파생 테이블 대신 사용하게 된다.
-- FROM절에서만 사용 됨(JOIN일 시 JOIN 구문에서도 가능)

WITH menucate AS (SELECT
						menu_name,
                        category_name
					FROM
						tbl_menu a
					JOIN
						tbl_category b on a.category_code = b.category_code
					) -- menu name 과 category name을 조인, 카테고리 코드가 일치할 경우 조인하여 출력
SELECT
	* -- menucate로 파생된 모든 항목을 출력 (이 경우 menu name 과 category name 출력)
FROM
	menucate
ORDER BY
	menu_name;
		
