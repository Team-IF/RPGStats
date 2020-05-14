package io.teamif.rpgstats.player;

import io.teamif.rpgstats.tribes.ITribe;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class IPlayer{
    @Getter(AccessLevel.PUBLIC)
    ITribe Tribe;
}
