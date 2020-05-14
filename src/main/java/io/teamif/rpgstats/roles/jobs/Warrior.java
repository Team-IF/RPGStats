package io.teamif.rpgstats.roles.jobs;

import io.teamif.rpgstats.enums.RoleType;
import io.teamif.rpgstats.roles.IRole;

@SuppressWarnings("unused")
public class Warrior extends IRole {
    public Warrior() {
        super(RoleType.Warrior, 0.0); // 체력 지정
    }
}
