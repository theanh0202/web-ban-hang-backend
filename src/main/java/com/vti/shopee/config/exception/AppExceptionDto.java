package com.vti.shopee.config.exception;

import java.time.Instant;

public class AppExceptionDto {
    private Instant timestamp;//thoi gian xay ra loi
    private int status;//ma loi
    private String message;//nguyen nhan loi
    private String path;//api xay ra loi

    public AppExceptionDto(int status, String error) {
        this.timestamp=Instant.now();
        this.status = status;
        this.message = error;
    }
    public AppExceptionDto(int status, String error,String path) {

        this.status = status;
        this.message = error;
        this.path=path;
        this.timestamp=Instant.now();
    }

    public AppExceptionDto(ErrorResponseEnum responseEnum) {
        this.timestamp=Instant.now();
        this.status = responseEnum.status;
        this.message = responseEnum.message;
    }
}
