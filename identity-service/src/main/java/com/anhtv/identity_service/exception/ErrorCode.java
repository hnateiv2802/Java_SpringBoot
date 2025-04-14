package com.anhtv.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User already existed"),
    USERNAME_INVALID(1002, "Username must be at least 6 characters"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters"),
    USER_NOT_FOUND(1004, "User not found"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
