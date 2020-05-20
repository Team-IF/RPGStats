package io.teamif.rpgstats.player;

import io.teamif.rpgstats.enums.RoleType;
import io.teamif.rpgstats.enums.TribeType;
import io.teamif.rpgstats.roles.IRole;
import io.teamif.rpgstats.roles.jobs.Rogue;
import io.teamif.rpgstats.tribes.Demon;
import io.teamif.rpgstats.tribes.Human;
import io.teamif.rpgstats.tribes.ITribe;
import io.teamif.rpgstats.tribes.Jinn;
import lombok.AccessLevel;
import lombok.Getter;

@SuppressWarnings("unused")
public abstract class IPlayer {
    @Getter(AccessLevel.PUBLIC)
    ITribe Tribe;
    @Getter(AccessLevel.PUBLIC)
    int Level;

    /**
     * 플레이어 데이터
     *
     * @param tribeType 종족명
     * @param roleName  역할
     */
    public IPlayer(String tribeType, String roleName) {
        try {
            final RoleType roleType = RoleType.valueOf(roleName);
            final IRole role = new IRole(roleType) {
                @Override
                public RoleType getRoleType() {
                    return super.getRoleType();
                }
            };

            switch (TribeType.valueOf(tribeType)) {
                case Jinn:
                    Tribe = new Jinn(role);
                    break;
                case Demon:
                    Tribe = new Demon(role);
                    break;
                case Human:
                    Tribe = new Human(role);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Level = 0;
    }

    public void addLevel() {
        addLevel(1);
    }

    public void addLevel(int lev) {
        Level += lev;
    }
}
