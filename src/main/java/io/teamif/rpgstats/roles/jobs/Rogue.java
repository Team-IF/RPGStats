package io.teamif.rpgstats.roles.jobs;

import io.teamif.rpgstats.enums.RoleType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Rogue extends IRole {

    public Rogue() {
        super(RoleType.Rogue, 100.0);// 체력 지정
    }
}
