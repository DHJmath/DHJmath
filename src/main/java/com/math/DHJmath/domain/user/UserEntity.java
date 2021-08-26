package com.math.DHJmath.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserEntity {

    // 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)    // 1)
    @Column(nullable = false)
    private Role role;  // 2)

    
    // 생성자
    @Builder
    public UserEntity(Long user_id, String name, String email, String picture, Role role){
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
    
    @Builder
    public UserEntity update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        
        return this;
    }
    
    public String getRoleKey() {
        return this.role.getKey();
    }



}

// 1)
// Enum 은 스프링 부트 2.0부터 추가된 값으로, 인증을 위한 url 주소들을 담고 있다.
// @Enumerated() 은 JPA로 데이터베이스로 저장할 때 Enum값을 어떤 형태로 저장할지 결정
// EnumType.STRING 은 문자열로 저장되도록 선언

// 2)
// Role 은 각 사용자의 권한을 관리할 Enum 클래스

//구글 api에서 얻을 수 있는 정보
//{
//        'sub': '<unique_id>',
//        'name': '<full>',
//        'given_name': '<first>',
//        'family_name': '<last>',
//        'picture': '<pic>',
//        'email': '<email>',
//        'email_verified': True,
//        'locale': 'en'
//        }
