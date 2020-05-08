package io.teamif.rpgstats.enums;

import lombok.AccessLevel;
import lombok.Getter;

public enum RoleType {

    Warrior("전사");

    @Getter(AccessLevel.PUBLIC)
    private String roleName;

    RoleType(String roleName) {
        this.roleName = roleName;
    }
}
