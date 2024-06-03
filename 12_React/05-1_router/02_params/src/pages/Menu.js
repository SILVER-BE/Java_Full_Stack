import {useState, useEffect} from "react";
import { getMenuList } from "../api/MenuAPI";
import boxStyle from "./Menu.module.css";
import MenuItem from "../Components/MenuItem";
import { useNavigate } from "react-router-dom";

function Menu() {

    const [menuList, setMenuList] = useState();
    const [searchValue, setSearchValue] = useState('');

    //메뉴 목록에 대한 조회
    useEffect(() => {
        setMenuList(getMenuList());
    }, []);

    const navigate = useNavigate(); // 호출하면 함수가 반환됨 (navigation function이 호출)

    const onClickHandler = () => navigate(`/menu/search?menuName=${searchValue}`)

    return (
        <div>
            <h1>메뉴 목록</h1>

            <div>
                <input 
                    type="search"
                    name="menuName"
                    value={searchValue}
                    onChange={ e => setSearchValue(e.target.value) }
                />
                <button onClick={onClickHandler}>검색</button>
            </div>

            <div className={boxStyle.MenuBox}> 
                { menuList && menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>) }
            </div>
        </div>
    );
}

export default Menu;