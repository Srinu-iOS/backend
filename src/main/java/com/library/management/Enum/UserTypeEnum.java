package com.library.management.Enum;

import java.util.Objects;

public enum UserTypeEnum {
    ADMIN(1, "admin"),
    USER(2,"user");

    private int id;
    private String userTypeRef;

    UserTypeEnum(int id, String userTypeRef) {
        this.id = id;
    }

    public int getUserTypeId() {
        return this.id;
    }

    public static UserTypeEnum getById(int id) {
        for(UserTypeEnum e : values()) {
            if(Objects.equals(e.id, id)) {
                return e;
            }
        }
        return null;
    }
}
