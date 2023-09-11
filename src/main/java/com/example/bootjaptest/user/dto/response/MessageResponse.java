package com.example.bootjaptest.user.dto.response;

import com.example.bootjaptest.user.entity.UserEntity;
import lombok.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private MessageHeaderResponse header;
    private Object body;

    private long totalUserCount;
    private List<UserEntity> userData;

    public static MessageResponse fail(String message) {
        return MessageResponse.builder().header(MessageHeaderResponse.builder()
                        .result(false)
                        .resultCode("")
                        .message(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build())
                .body(null)
                .build();
    }

    public static MessageResponse success(Object data) {
        return MessageResponse.builder().header(MessageHeaderResponse.builder()
                        .result(true)
                        .resultCode("")
                        .message("")
                        .status(HttpStatus.OK.value())
                        .build())
                .body(data)
                .build();
    }

    public static MessageResponse success() {
        return MessageResponse.builder().header(MessageHeaderResponse.builder()
                        .result(true)
                        .resultCode("")
                        .message("")
                        .status(HttpStatus.OK.value())
                        .build())
                .body(null)
                .build();
    }
}
