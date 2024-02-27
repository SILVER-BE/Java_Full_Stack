/* WHERE */
-- WHERE절은 특정 조건에 맞는 레코드만을 선택하는데 사용, 다양한 방버븡로 조건을 설정할 수 있다

-- 비교 연산자
SELECT
	menu_name,
	menu_price,
	orderable_status
FROM
	tbl_menu
WHERE
	orderable_status = 'Y';
 
SELECT
	menu_name,
	menu_price,
	orderable_status
FROM
	tbl_menu
WHERE
	menu_price = 13000;
 
 -- 같지 않음 !
SELECT
	menu_code,
	menu_name,
	orderable_status
FROM
	tbl_menu
WHERE
-- orderable_status <> 'Y';
	orderable_status != 'Y';
 
 -- 대소 비교
SELECT
	menu_code,
	menu_name,
	menu_price
FROM
	tbl_menu
WHERE
	menu_price > 20000;
 
SELECT
	menu_code,
	menu_name,
	menu_price
FROM
	tbl_menu
WHERE
	menu_price <= 20000;
    

/* AND 연산자 활용 */

-- 0과 NULL이 아닌 값들일 경우 1이다.
-- 하나라도 0이거나 둘 다 0일 경우 0을 반환한다. (이미 0이면 뒤를 연산하지 않는다.)
-- 0이 아닌 값과 NULL이거나 둘 다 NULL일 경우 NULL을 반환한다.

SELECT 1 AND 1;
SELECT 1 AND 0, 0 AND 1, 0 AND 0, 0 AND NULL;
SELECT 1 AND NULL, NULL AND NULL;

SELECT
	menu_name,
	menu_price,
	category_code,
	orderable_status
FROM
	tbl_menu
WHERE
	orderable_status = 'Y' AND
	category_code = 10;

SELECT
	menu_code,
	menu_name,
	menu_price,
	category_code,
	orderable_status
FROM
	tbl_menu
WHERE
	menu_price > 5000 AND
	category_code = 10;
    
/* OR 연산자 활용 */

-- 둘 다 NULL이 아니면서 하나라도 0이 아닌 값이 있을 경우 1을 반환한다. (이미 1이면 뒤를 연산하지 않는다.)
-- 둘 다 0일 경우 0을 반환한다.
-- 1을 제외한 값들에서 하나라도 NULL이거나 둘 다 NULL일 경우 NULL을 반환한다.

SELECT 1 OR 1, 1 OR 0, 0 OR 1;
SELECT 0 OR 0;
SELECT 1 OR NULL, 0 OR NULL, NULL or NULL;

SELECT
 menu_name,
 menu_price,
 category_code,
 orderable_status
FROM
 tbl_menu
WHERE
orderable_status = 'Y' OR
 category_code = 10
ORDER BY
 category_code;
    
SELECT
 menu_code,
 menu_name,
 menu_price,
 category_code,
 orderable_status
FROM
 tbl_menu
WHERE
 menu_price > 5000 OR
 category_code = 10;

-- AND와 OR의 우선순위
-- AND가 OR보다 우선순위가 높다.
-- OR의 우선순위를 높이고 싶다면 소괄호()를 사용한다.

SELECT 1 OR 0 AND 0;
SELECT (1 OR 0) AND 0;

SELECT
 menu_code,
 menu_name,
 menu_price,
 category_code,
 orderable_status
FROM
 tbl_menu
WHERE
 category_code = 4 OR
 menu_price = 9000 AND
 menu_code > 10;
 
 /* BETWEEN 연산자 활용 */
 
SELECT
 menu_name,
 menu_price,
 category_code
FROM
 tbl_menu
WHERE
 menu_price >= 10000 AND
 menu_price <= 25000
ORDER BY
 menu_price;

SELECT
 menu_name, 
 menu_price,
 category_code
FROM
 tbl_menu
WHERE
 menu_price BETWEEN 10000 AND 25000
ORDER BY
 menu_price;
 

SELECT
 menu_name,
 menu_price,
 category_code
FROM
 tbl_menu
WHERE
 menu_price NOT BETWEEN 10000 AND 25000
ORDER BY
 menu_price;
 
 /* LIKE 연산자 활용 */
 
 SELECT
 menu_name,
 menu_price
FROM
 tbl_menu
WHERE
 menu_name LIKE '%마늘%'
ORDER BY
 menu_name;

SELECT
 menu_code,
 menu_name,
 menu_price,
 category_code,
  orderable_status
FROM
 tbl_menu
WHERE
 menu_price > 5000 AND
 category_code = 10 AND
 menu_name LIKE '%갈치%';

SELECT
 menu_name,
 menu_price
FROM
 tbl_menu
WHERE
 menu_name NOT LIKE '%마늘%'
ORDER BY
 menu_name;
 
 /* IN 연산자 활용 */
 SELECT
 menu_name,
 category_code
FROM
 tbl_menu
WHERE
 category_code = 4 OR
 category_code = 5 OR
 category_code = 6
ORDER BY
 category_code;
 
SELECT
 menu_name,
 category_code
FROM
 tbl_menu
WHERE
 category_code IN (4, 5, 6)
ORDER BY
 category_code;
 
SELECT
 menu_name,
 category_code
FROM
 tbl_menu
WHERE
 category_code NOT IN (4, 5, 6)
ORDER BY
 category_code;
 
/* IS NULL 연산자 활용 */
SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
WHERE
 ref_category_code IS NULL;
 
SELECT
 category_code,
 category_name,
 ref_category_code
FROM
 tbl_category
WHERE
 ref_category_code IS NOT NULL;


