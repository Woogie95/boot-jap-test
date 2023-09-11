package com.example.bootjaptest.user.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageHeaderResponse {
    private boolean result;
    private String resultCode;
    private String message;
    private int status;
}
