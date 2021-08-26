package com.math.DHJmath.config.auth.dto;

import com.math.DHJmath.domain.user.User;
import lombok.Getter;

import javax.mail.Session;
import java.io.Serializable;

@Getter
// 인증된 사용자 정보를 저장하는 Dto
public class SessionUser implements Serializable {  // HttpSession에 넣을것이라서 직렬화

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }


}
