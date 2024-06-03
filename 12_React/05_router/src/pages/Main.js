import {Link} from "react-router-dom";

function Main() {
    return (
        <div>
            <h1>메인</h1>
            <nav>
                <Link to="/">HOME</Link>
                <Link to="/about">소개</Link>
                <Link to="/menu">메뉴 목록</Link>
            </nav>
        </div>
    );
}

export default Main; //다른 곳에서 import 했을 때 이 컴포넌트 default로 사용 가능