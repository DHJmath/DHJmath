package com.math.DHJmath.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
    
}

// 스프링 시큐리티에서 권한 코드는 항상 앞에 ROLE이 있어야만 함
// 따라서 코드별 키 값을 ROLE_GUEST, ROLE_USER 등으로 지정