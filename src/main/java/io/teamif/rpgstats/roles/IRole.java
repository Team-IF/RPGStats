package io.teamif.rpgstats.roles;

import io.teamif.rpgstats.enums.RoleType;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Abstract role class
 */
public abstract class IRole {

    public IRole(RoleType roleType, double health) {
        this.roleType = roleType;
        this.health = health;
    }

    /**
     * Role Health
     */
    @Getter(AccessLevel.PUBLIC)
    public double health;
    /**
     * Role type of this role.
     */
    @Getter(AccessLevel.PUBLIC)
    public RoleType roleType;
}