package com.example.bootjaptest.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {
    @Size(min = 13, message = "-를 포함해서 13자리 입력해주세요.")
    @NotBlank(message = "핸드폰 번호는 필수 항목 입니다.")
    private String phoneNumber;
}
