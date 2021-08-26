package com.math.DHJmath.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // 1)
}

// JpaRepository<엔티티, 기본키 형>

// 1) 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메소드
// Optional은 null 또는 실제 값을 value로 갖는 wrapper로 감싸서 NPE(NullPointerException)로부터 자유로워지기 위해 나온 Wrapper 클래스이다
// 즉, Optional은 메소드의 결과가 null이 될 수 있으며, 클라이언트가 이 상황을 처리해야 할 때 사용하는 것이 좋다.
