package com.example.bootjaptest.common;

import lombok.*;
import org.springframework.validation.FieldError;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String field;
    private String message;

    public static ErrorResponse of(FieldError error) {
        return ErrorResponse.builder()
                .field(error.getField())
                .message(error.getDefaultMessage())
                .build();
    }
}
