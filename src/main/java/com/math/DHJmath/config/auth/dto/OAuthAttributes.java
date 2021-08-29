package com.math.DHJmath.config.auth.dto;

import com.math.DHJmath.domain.user.Role;
import com.math.DHJmath.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    // -- 필드 --
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    // -- 생성자 --
    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String name,
                           String email,
                           String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // -- 메소드 --

    // 로그인 진행 서비스가 어디인지 구분하여 알맞게 매핑
    // registrationId : OAuth2 로그인을 처리한 서비스 구분 값 ("google", "naver", "kakao")
    // userNameAttributeName : OAuth2 로그인 시 키가 되는 필드 값.
    // OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 반환해야함
    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {

        if("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        }

        if("kakao".equals(registrationId)){
            return ofKakao(userNameAttributeName, attributes);
        }


        return ofGoogle(userNameAttributeName, attributes);
    }


    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName,
                                           Map<String, Object> attributes) {

        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String,Object> response = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) response.get("profile");
        return OAuthAttributes.builder()
                .name((String)profile.get("nickname"))
                .email((String)response.get("email"))
                .picture((String)profile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }



    // User 엔티티 생성
    public User toEntity() {

        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }

}



// 카카오 JSON
//{
//        "id": ----,
//        "connected_at": "2020-08-15T16:08:16Z",
//        "properties": {
//        "nickname": "----",
//        "profile_image": ""----",
//        "thumbnail_image": "----"
//        },
//        "kakao_account": {
//        "profile_needs_agreement": false,
//        "profile": {
//        "nickname": "---",
//        "thumbnail_image_url": "----",
//        "profile_image_url": "----"
//        },
//        "has_email": true,
//        "email_needs_agreement": false,
//        "is_email_valid": true,
//        "is_email_verified": true,
//        "email": "ventulus95@gmail.com",
//        "has_age_range": false,
//        "age_range_needs_agreement": false,
//        "has_birthday": false,
//        "birthday_needs_agreement": false,
//        "has_gender": true,
//        "gender_needs_agreement": false,
//        "gender": "male"
//        }
//        }
//