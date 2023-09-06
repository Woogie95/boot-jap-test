package com.example.bootjaptest.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {

    @Email(message = "이메일 형식에 맞게 입력해 주세요.")
    @NotBlank(message = "이메일은 필수 항목 입니다.")
    private String email;

    @Size(min = 4, message = "비밀번호는 4자리 이상 입력해주세요.")
    @NotBlank(message = "비밀번호는 필수 항목 입니다.")
    private String password;

}
