package com.example.bootjaptest.user.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserNoticeCount {

    private Long id;
    private String email;
    private String username;
    private long noticeCount;

}
