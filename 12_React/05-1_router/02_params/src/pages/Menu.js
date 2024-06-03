import {useState, useEffect} from "react";
import { getMenuList } from "../api/MenuAPI";
import boxStyle from "./Menu.module.css";
import MenuItem from "../Components/MenuItem";

function Menu() {

    const [menuList, setMenuList] = useState();

    //메뉴 목록에 대한 조회
    useEffect(() => {
        setMenuList(getMenuList());
    }, []);

    return (
        <div>
            <h1>메뉴 목록</h1>
            <div className={boxStyle.MenuBox}> 
                { menuList && menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>) }
            </div>
        </div>
    );
}

export default Menu;