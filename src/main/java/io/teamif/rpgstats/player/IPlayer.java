package io.teamif.rpgstats.player;

import io.teamif.rpgstats.tribes.ITribe;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Singular;

@SuppressWarnings("unused")
public abstract class IPlayer{
    @Getter(AccessLevel.PUBLIC)
    ITribe Tribe;
    @Getter(AccessLevel.PUBLIC)
    int Level;

    public IPlayer(ITribe tribe) {
        Tribe = tribe;
    }

    public void addLevel() {
        addLevel(1);
    }

    public void addLevel(int lev) {
        Level += lev;
    }
}
