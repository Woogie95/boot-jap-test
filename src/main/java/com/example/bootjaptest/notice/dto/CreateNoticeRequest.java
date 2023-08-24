package com.example.bootjaptest.notice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateNoticeRequest {

    @NotBlank
    private String title;
    private String content;

}
