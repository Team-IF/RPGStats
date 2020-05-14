package io.teamif.rpgstats.tribes;

import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Human extends ITribe {
    public Human(IRole role) {
        super(TribeType.Human, TribeType.Jinn, role);
    }
}
