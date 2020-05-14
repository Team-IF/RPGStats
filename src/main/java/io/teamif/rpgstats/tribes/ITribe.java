package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract tribe class
 */
public abstract class ITribe {
    public ITribe(TribeType tribeType, TribeType hostileType, IRole roleType) {
        this.tribeType = tribeType;
        this.hostileType = hostileType;
        this.roleType = roleType;
    }
    @Getter(AccessLevel.PUBLIC)
    TribeType tribeType;
    @Getter(AccessLevel.PUBLIC)
    TribeType hostileType;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    IRole roleType;
}