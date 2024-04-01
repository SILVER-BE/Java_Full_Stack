package com.ohgiraffers.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // 컨트롤러는 여러개 작성해도 상관 X
public class ResolverController {

    //string과 view를 따로 보내거나, string과 view를 함께 보내거나(ModelAndView)
    //아래는 모두 방식의 차이

    @GetMapping("/string")
    /* Model : View에서 표현되어야 하는 동적인 데이터를 담는 용도로 사용하는 객체 */
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환 함.");

        /* 문자열로 뷰 이름을 반환한다는 것은
        * 반환 후 ThymeleafViewResolver에게 prefix/suffix를 붙여 응답 뷰로 설정하라는 의미이다.
        * */
        return "result"; // result라는 html을 뷰 화면으로 반환
    }

    @GetMapping("/string-redirect")
    public String stringRedirect() {

        /* 접두사로 redirect: 를 하면 forward가 아닌 redirect 시킨다. */
        return "redirect:/";
    }

    @GetMapping("/string-redirect-attr") // session에 잠깐 저장한 뒤, 사용하면 사라짐
    public String stringRedirectFlashAttribute(RedirectAttributes rttr) {
        rttr.addFlashAttribute("flashMessage", "리다이렉트 attr 사용하여 redirect");

        /* 리다이렉트 처리 시 request scope의 데이터는 공유되지 않는다.
        * session scope에 너무 많은 데이터를 저장하는 것은 서버 성능에 영향을 준다.
        * redirect 처리 시 전달하여 잠깐 사용하고 싶은 데이터가 있다면 (ex. 저장 완료 alert 메세지 등)
        * RedirectAttributes 객체를 통해 잠시 세선에 저장했다가 redirect 후 세션에서 제거되게 할 수 있다. */

        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mv) {

        /* 모델 객체에 attribute 저장 */
        mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");

        /* View 객체에 논리적 뷰 이름 설정 */
        mv.setViewName("result");

        return mv;
    }

}
