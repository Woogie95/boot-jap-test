package com.example.bootjaptest.user.dto;

import com.example.bootjaptest.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String username;
    private String phoneNumber;

    public static UserResponse from(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .username(userEntity.getUsername())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
}
