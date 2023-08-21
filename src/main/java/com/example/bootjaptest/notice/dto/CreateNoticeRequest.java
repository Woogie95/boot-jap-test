package com.example.bootjaptest.notice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateNoticeRequest {
    private String title;
    private String content;

}
