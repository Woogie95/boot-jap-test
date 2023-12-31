package com.example.bootjaptest.common;

import com.example.bootjaptest.notice.exception.DuplicateNoticeException;
import com.example.bootjaptest.notice.exception.NoticeAlreadyDeletedException;
import com.example.bootjaptest.notice.exception.NoticeNotFoundException;
import com.example.bootjaptest.user.exception.ExistEmailException;
import com.example.bootjaptest.user.exception.PasswordNotMatchException;
import com.example.bootjaptest.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoticeNotFoundException.class)
    public ResponseEntity<String> handlerNoticeNotFoundException(NoticeNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoticeAlreadyDeletedException.class)
    public ResponseEntity<String> handlerNoticeAlreadyDeletedException(NoticeAlreadyDeletedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(DuplicateNoticeException.class)
    public ResponseEntity<String> handlerDuplicateNoticeException(DuplicateNoticeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handlerUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ExistEmailException.class, PasswordNotMatchException.class})
    public ResponseEntity<String> RunTimeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
