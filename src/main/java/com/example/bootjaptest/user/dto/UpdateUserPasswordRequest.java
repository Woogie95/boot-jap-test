package com.example.bootjaptest.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserPasswordRequest {

    @NotBlank(message = "현재 비밀번호는 필수 항목입니다.")
    private String password;

    @Size(min = 1, max = 20, message = "신규 비밀번호는 1-20자리의 길이로 입력해 주세요.")
    @NotBlank(message = "신규 비밀번호는 필수 항목입니다.")
    private String newPassword;

}
