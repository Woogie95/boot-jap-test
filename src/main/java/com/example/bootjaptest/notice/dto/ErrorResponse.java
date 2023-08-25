package com.example.bootjaptest.notice.dto;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

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
