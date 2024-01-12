package com.vti.shopee.config.exception;

public enum     ErrorResponseEnum {

        NOT_FOUND_PRODUCT(404, "Không tìm thấy sản phẩm"),
        NOT_FOUND_ACCOUNT(404, "Không tìm thấy người dùng"),
        USERNAME_NOT_EXIT(401, "sai username"),
        ERR_PASSWORD(404, "PASS WORD KHONG DUNG");


        public final int status;
        public final String message;
        ErrorResponseEnum(int status, String message) {
            this.status = status;
            this.message = message;
        }

    }
