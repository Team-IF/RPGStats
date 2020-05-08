package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;

@SuppressWarnings("unused")
public class Demon extends ITribe {
    public Demon() {
        tribeType = TribeType.Demon;
        hostileType = TribeType.Human;
    }
}
