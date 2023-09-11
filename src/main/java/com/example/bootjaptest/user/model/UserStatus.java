package com.example.bootjaptest.user.model;

public enum UserStatus {
    NONE,
    USING,
    STOP;

    int value;

    UserStatus() {

    }

    public int getValue() {
        return this.value;
    }
}
