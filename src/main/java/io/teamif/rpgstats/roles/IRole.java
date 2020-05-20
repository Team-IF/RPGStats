package io.teamif.rpgstats.roles;

import io.teamif.rpgstats.enums.RoleType;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Abstract role class
 */
public abstract class IRole {

    public IRole(RoleType roleType) {
        this.roleType = roleType;
    }

    /**
     * Role type of this role.
     */
    @Getter(AccessLevel.PUBLIC)
    private RoleType roleType;
}