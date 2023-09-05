package com.example.bootjaptest.user.dto.response;

import com.example.bootjaptest.user.dto.UserResponse;
import com.example.bootjaptest.user.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindUserEmailResponse {

    private String email;

    public static FindUserEmailResponse from(UserEntity userEntity) {
        return FindUserEmailResponse.builder()
                .email(userEntity.getEmail())
                .build();
    }
}
