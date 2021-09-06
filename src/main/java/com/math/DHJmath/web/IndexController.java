package com.math.DHJmath.web;

import com.math.DHJmath.config.auth.LoginUser;
import com.math.DHJmath.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class IndexController {


    // 인덱스 페이지
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // 1);
        
        // 세션에 저장된 값이 있을 때만 model에 userName 등록
        // 세션에 저장된 값이 없으면 로그인 버튼이 보임
        if (user != null) {
            model.addAttribute("sessionUser", user);
        }

        return "index";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String userLogin() {
        return "/user/user-login";
    }


}
