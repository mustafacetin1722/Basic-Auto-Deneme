package com.mustafa.security.basicautodeneme.dto;

import com.mustafa.security.basicautodeneme.model.Role;
import lombok.Builder;

import java.util.Set;
@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {
}
