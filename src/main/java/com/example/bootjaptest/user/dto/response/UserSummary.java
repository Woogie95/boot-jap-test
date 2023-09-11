package com.example.bootjaptest.user.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSummary {

    private long stopUserCount;
    private long usingUserCount;
    private long totalUserCount;

}
