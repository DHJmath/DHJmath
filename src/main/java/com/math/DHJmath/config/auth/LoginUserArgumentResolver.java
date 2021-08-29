package com.math.DHJmath.config.auth;

import com.math.DHJmath.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {   // 1)

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) { // 2)

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation &&  isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,    // 3)
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        return httpSession.getAttribute("user");
    }

}



// 1) HandlerMethodArgumentResolver
//      조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver의 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있다.
//      HandlerMethodArgumentResolver를 상속받은 객체는 두개의 메서드를 구현해야 한다.
//              1-1. supportsParameter 메서드는 현재 파라미터를 resolver이 지원하는지에 대한 boolean을 리턴
//              1-2. resolveArgument 메서드는 실제로 바인딩을 할 객체를 리턴
//
// 2) supportParameter()
//      컨트롤러 메서드의 특정 파라미터를 지원하는지 판단
//      여기서는 파라미터에 @LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionUser.class인 경우 true를 반환
//
// 3) resolveArgument()
//      파라미터에 전달할 객체를 생성
//      여기서는 세션에서 객체를 가져온다.

