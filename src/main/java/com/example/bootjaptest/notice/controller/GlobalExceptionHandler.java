package com.example.bootjaptest.notice.controller;

import com.example.bootjaptest.notice.exception.DuplicateNoticeException;
import com.example.bootjaptest.notice.exception.NoticeAlreadyDeletedException;
import com.example.bootjaptest.notice.exception.NoticeNotFoundException;
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

}
