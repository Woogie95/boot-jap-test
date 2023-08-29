package com.example.bootjaptest.notice.exception;

public class DuplicateNoticeException extends RuntimeException{
    public DuplicateNoticeException(String message) {
        super(message);
    }

}
