package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class ITribe {
    @Getter(AccessLevel.PUBLIC)
    TribeType tribeType;
    @Getter(AccessLevel.PUBLIC)
    TribeType hostileType;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
    IRole roleType;
}
