package com.example.bootjaptest.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @Email(message = "이메일 형식에 맞게 입력해 주세요.")
    @NotBlank(message = "이메일은 필수 항목 입니다.")
    private String email;

    @NotBlank(message = "이름은 필수 항목 입니다.")
    private String username;

    @Size(min = 4, message = "비밀번호는 4자리 이상 입력해주세요.")
    @NotBlank(message = "비밀번호는 필수 항목 입니다.")
    private String password;

    @Size(min = 13, message = "-를 포함해서 13자리 입력해주세요.")
    @NotBlank(message = "핸드폰 번호는 필수 항목 입니다.")
    private String phoneNumber;
}
