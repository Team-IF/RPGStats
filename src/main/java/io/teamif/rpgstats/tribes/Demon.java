package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Demon extends ITribe {
    public Demon(IRole role) {
        super(TribeType.Demon, TribeType.Human, role);
    }
}
