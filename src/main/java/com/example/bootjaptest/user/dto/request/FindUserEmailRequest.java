package com.example.bootjaptest.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindUserEmailRequest {

    @NotBlank(message = "이름은 필수 항목 입니다.")
    private String username;

    @Size(min = 13, message = "-를 포함해서 13자리 입력해주세요.")
    @NotBlank(message = "핸드폰 번호는 필수 항목 입니다.")
    private String phoneNumber;

}
