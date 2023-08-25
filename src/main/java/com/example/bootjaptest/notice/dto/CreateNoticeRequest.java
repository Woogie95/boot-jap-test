package com.example.bootjaptest.notice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateNoticeRequest {

    @NotBlank(message = "제목은 필수 항목 입니다.")
    @Size(min = 2,max = 100, message = "제목은 2-100자 사이입니다.")
    private String title;

    @Size(min = 2,max = 1000, message = "제목은 2-1000자 사이입니다.")
    @NotBlank(message = "내용은 필수 항목 입니다.")
    private String content;

}
