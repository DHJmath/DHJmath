package com.math.DHJmath.config;

import com.math.DHJmath.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration  // 1)
public class WebConfig implements WebMvcConfigurer {    // 2)

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }

}


// 1) @Configuration : 스프링 설정파일을 만들기 위한 어노테이션 or Bean을 등록하기 위한 어노테이션이다.
// 2) HandlerMethodArgumentResolver가 스프링에서 인식되려면 항상 WebMvcConfigurer의 addArgumentResolvers() 를 통해 추가돼야함