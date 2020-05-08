package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;

public class Jinn extends ITribe {
    public Jinn() {
        tribeType = TribeType.Jinn;
        hostileType = TribeType.Monster;
    }
}
