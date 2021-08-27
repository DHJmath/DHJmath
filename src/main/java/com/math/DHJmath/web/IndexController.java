package com.math.DHJmath.web;

import com.math.DHJmath.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    // 인덱스 페이지
    @GetMapping("/")
    public String index(Model model) {

        // 로그인 성공시 세션에 SessionUser를 저장
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        
        // 세션에 저장된 값이 있을 때만 model에 userName 등록
        // 세션에 저장된 값이 없으면 로그인 버튼이 보임
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String userLogin() {
        return "/user/user-login";
    }


}
