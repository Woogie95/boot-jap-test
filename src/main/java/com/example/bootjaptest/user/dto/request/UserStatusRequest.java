package com.example.bootjaptest.user.dto.request;

import com.example.bootjaptest.user.model.UserStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusRequest {

    UserStatus userStatus;
}
