package com.example.bootjaptest.user.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {
    private String email;
    private String username;
    private String phoneNumber;

}
