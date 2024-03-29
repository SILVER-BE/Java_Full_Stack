package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
//@SessionAttributes("id")
public class FirstController {

    /* 반환 값을 void로 설정하면 요청 주소가 view의 이름이 된다. */
    @GetMapping("regist")
    public void regist() {}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) { // WebRequest request -> 정보를 가지고 있음 여기서 꺼내오기(getParameter를 이용해서)

         String name = request.getParameter("name");
         int price = Integer.parseInt(request.getParameter("price"));
         int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

         String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록 하셨습니다.";

         model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {}

    /* @RequestParam으로 요청 파라미터 전달 받기
    * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 매개 변수 앞에 작성한다.
    * form의 name 속성값과 매개변수의 이름이 다른 경우 @RequestParam("name")을 설정하면 된다.
    *
    * 값이 넘어오지 않는 경우 defaultValue를 이용해 기본값을 설정해줄 수 있다. */
    @PostMapping("modify")
    public String modifyMenuPrice(Model model, @RequestParam String modifyName,
                                  @RequestParam(defaultValue = "0") int modifyPrice) {
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경했습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    /* 파라미터가 여러개인 경우 맵으로 한 번에 처리할 수 있다.
    * 이 때 맵의 키는 form의 name 속성값이 된다.
    *  */
    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {
        String modifyMenu = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyMenu + "으로, 가격을 " + modifyPrice +"원으로 변경했습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {}

    /* @ModelAttribute 이용하는 방법
    * DTO 같은 모델을 커맨드 객체로 생성하여 매개변수를 전달해준 뒤, 해당 인스턴스를 model에 담는다.
    * 경우에 따라 폼에서 입력한 값을 다음 화면으로 바로 전달해야하는 경우 유용하게 사용할 수 있다.
    *
    * @ModelAttribute("모델에 담을 key값")을 지정할 수 있으며,
    * 지정하지 않으면 타입의 앞글자를 소문자로 한 네이밍 규칙을 따른다.
    * menuDTO로 담긴다.
    *
    * */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {

        System.out.println(menu);

        return "first/searchResult";
    }

    // 첫번째 로그인 방법
    @GetMapping("login")
    public void login(){}

    /* HttpSession을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    // 첫번째 로그아웃 방법
    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {

        session.invalidate();

        return "first/loginResult";
    }

    // 두번째 로그아웃 방법
    /* SessionAttributes로 등록된 값은 session의 상태를 관리하는
     * SessionStatus의 setComplete() 메소드를 호출해야 사용이 만료된다. */
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "first/loginResult";
    }

    // 두번째 로그인 방법 --> 첫번째 로그아웃은 이걸로 안됨 !! 주석 처리 후 진행 ..
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
    /* 클래스에 키값을 등록하고, 모델 영역에 해당 키값이 추가되는 경우 세션이 자동으로 등록 됨 */

        model.addAttribute("id", id);

        return "first/loginResult";
    }

}
