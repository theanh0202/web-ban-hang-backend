package com.vti.shopee.modal.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * implements GrantedAuthority :đang coi đói tượng trong enum Role là ă quyền trong security
 */
public enum Role implements GrantedAuthority {
    CUSTOMER,SELLER,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
