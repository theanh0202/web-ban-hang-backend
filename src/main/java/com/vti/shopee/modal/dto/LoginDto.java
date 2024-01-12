package com.vti.shopee.modal.dto;

import com.vti.shopee.modal.entity.Role;
import lombok.Data;

@Data
public class LoginDto {
    private int userId;
    private String name;
    private Role role;
    private String fullName;
    private String userAgent;//tên trình duyệt đang sử dụng
    private String token;

}
