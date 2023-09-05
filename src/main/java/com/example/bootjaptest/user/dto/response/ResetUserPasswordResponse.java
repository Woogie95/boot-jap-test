package com.example.bootjaptest.user.dto.response;

import com.example.bootjaptest.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetUserPasswordResponse {

    private String username;
    private String password;

    public static ResetUserPasswordResponse from(UserEntity userEntity) {
        return ResetUserPasswordResponse.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }
}
