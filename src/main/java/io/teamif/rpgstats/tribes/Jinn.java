package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Jinn extends ITribe {
    public Jinn(IRole role) {
        super(TribeType.Jinn, TribeType.Monster, role);
    }
}
