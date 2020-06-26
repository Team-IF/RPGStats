package io.teamif.rpgstats.player

import io.teamif.rpgstats.role.RoleType
import io.teamif.rpgstats.tribe.TribeType

class Player(val tribeType: TribeType, val roleType: RoleType) {
    var level = 0
        internal set
}