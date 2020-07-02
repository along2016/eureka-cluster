package com.cloud.common.auth.entity;

import java.io.Serializable;
import java.util.Collection;

public interface IUser<T> extends Serializable {

    Long getId();

    String getUsername();

    String getName();

    String getPassword();

    String getSalt();

    String getEmail();

    String getPhone();

    Collection<T> getAuthorities();
}
