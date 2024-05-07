-- Q1

select
	category_code,
    category_name
from
	tbl_category
order by
	category_name desc,
	category_code is not null;
    
-- Q2

select
	menu_name,
    menu_price
from
	tbl_menu
where
	menu_name like '%밥%' and
    menu_price between 20000 and 30000;
    
-- Q3

select
	menu_name,
    menu_price
from
	tbl_menu
where
	menu_price < 10000 or
    menu_name like '%김치%'
order by
	menu_price,
    menu_name desc;
    
-- Q4

select
	category_code,
    category_name
from
	tbl_category
order by
	category_name desc,
	category_code is not null;
    
select
	category_code,
    menu_name,
    menu_price
from
    tbl_menu
where
	menu_price = 13000 and
	category_code not in (8, 9, 10) and
    orderable_status != 'N';