package com.cloud.common.auth.entity;

import org.springframework.security.core.GrantedAuthority;

public interface IAuthority extends GrantedAuthority {
    String getName();

    void setName(String var1);

    String getDescription();

    void setDescription(String var1);
}
