package io.teamif.rpgstats.roles.jobs;

import io.teamif.rpgstats.enums.RoleType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Wizard extends IRole {
    public Wizard() {
        super(RoleType.Wizard, 0.0); // 체력지정
    }
}
