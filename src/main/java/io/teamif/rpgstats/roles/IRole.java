package io.teamif.rpgstats.roles;

import io.teamif.rpgstats.enums.RoleType;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Role interface - will be used as RPG roles.
 */
public abstract class IRole {

    @Getter(AccessLevel.PUBLIC)
    RoleType roleType;
}