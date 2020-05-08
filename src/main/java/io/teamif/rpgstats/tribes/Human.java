package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;

public class Human extends ITribe {
    public Human() {
        tribeType = TribeType.Human;
        hostileType = TribeType.Jinn;
    }
}
