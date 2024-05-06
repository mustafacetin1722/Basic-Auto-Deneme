package com.mustafa.security.basicautodeneme.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MOD,
    FSK;

    @Override
    public String getAuthority() {
        return name();
    }
}
