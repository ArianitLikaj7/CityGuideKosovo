package com.arianit.CityGuideKosovo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),

    MANAGER_READ("manager:read"),
    MANAGER_CREATE("manager:create");


    @Getter
    private final String permission;
}
