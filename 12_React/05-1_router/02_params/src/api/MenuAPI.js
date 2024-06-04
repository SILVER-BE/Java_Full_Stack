import menus from '../data/menu-detail.json'; //배열을 menus라는 이름으로 읽어와서 쓰겠다

/* 전체 메뉴 목록 조회용 API */
export function getMenuList() {
    return menus; //그래서 반환값 그냥 menus라고 쓰면 됨
}

/* 메뉴 코드를 이용하여 한 개의 상세 내용 조회 */
export function getMenuDetail(menuCode) {
    return menus.find(menu => menu.menuCode == menuCode);
}

/* 메뉴명을 전달받아 메뉴이름을 포함하고있는 메뉴 목록 조회 */
export function getSearchMenu(menuName) {
    return menus.filter(menu => menu.menuName.match(menuName));
}
