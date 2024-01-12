package com.vti.shopee.config.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
public class AppException extends RuntimeException{
    private Instant timestamp;//thoi gian xay ra loi
    private int status;//ma loi
    private String message;//nguyen nhan loi
    private String path;//api xay ra loi

    public AppException(int status, String error) {
        this.timestamp=Instant.now();
        this.status = status;
        this.message = error;
    }

    public AppException(ErrorResponseEnum responseEnum) {
        this.timestamp=Instant.now();
        this.status = responseEnum.status;
        this.message = responseEnum.message;
    }

}
