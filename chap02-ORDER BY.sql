/* ORDER BY 
	ORDER BY절은 SELECT문과 함께 사용하며 결과 집합을 특정 열이나 열들의 값에 따라 정렬하는 데 사용한다. */

SELECT
 menu_code,
 menu_name,
 menu_price
FROM
 tbl_menu
ORDER BY
-- menu_price ASC; -- ASC는 오름차순
 menu_price;
 
 /* 역순 정렬 */
 SELECT
 menu_code,
 menu_name,
 menu_price
FROM
 tbl_menu
ORDER BY
 menu_price DESC; -- DESC는 내림차순
 
/* 여러열로 정렬 */
SELECT
 menu_code,
 menu_name,
 menu_price
FROM
 tbl_menu
ORDER BY
 menu_price DESC,
 menu_name ASC;
 
 /* 연산결과 정렬 */
 SELECT
 menu_code,
 menu_price,
 menu_code * menu_price
FROM
 tbl_menu
ORDER BY
 menu_code * menu_price DESC;
 
 SELECT
 menu_code,
 menu_price,
 menu_code * menu_price
FROM
 tbl_menu
ORDER BY
 menu_code * menu_price DESC;
 
 /* 사용자 지정 목록을 사용하여 데이터 정렬 */
 SELECT FIELD('A', 'A', 'B', 'C');
 SELECT FIELD('B', 'A', 'B', 'C');
 
SELECT
 FIELD(orderable_status, 'N', 'Y') -- 'N'라면 2
FROM
 tbl_menu;

SELECT
 menu_name,
 orderable_status
FROM
 tbl_menu
ORDER BY FIELD(orderable_status, 'N', 'Y');

-- null값이 있는 컬럼에 대한 정렬
SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
ORDER BY
-- ref_category_code ASC;
 ref_category_code; -- ASC 생략 가능
 
-- 오름차순 시 NULL 마지막으로(IS NULL ASC)
SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
ORDER BY
-- ref_category_code IS NULL ASC;
 ref_category_code IS NULL; -- ASC 생략 가능
 
 -- 내림차순 시 NULL 마지막으로(DEFAULT)
 SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
ORDER BY
 ref_category_code DESC; -- DESC 생략 불가능
 
-- 내림차순 시 NULL 처음으로 (IS NULL DESC)
SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
ORDER BY
 ref_category_code IS NULL DESC, ref_category_code DESC;

 



 

 
 