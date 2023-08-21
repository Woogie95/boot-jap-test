package com.example.bootjaptest.notice.exception;

public class NoticeAlreadyDeletedException extends RuntimeException {
    public NoticeAlreadyDeletedException(String message) {
        super(message);
    }

}
