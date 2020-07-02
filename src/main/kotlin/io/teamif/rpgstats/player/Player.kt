package io.teamif.rpgstats.player

import io.teamif.rpgstats.role.AbstractRole
import io.teamif.rpgstats.role.RoleType
import io.teamif.rpgstats.tribe.TribeType

class Player(tribeType: TribeType, roleType: RoleType) {
    var level = 0
        internal set

    val role: AbstractRole = roleType.roleClass.newInstance()

    init {
        println("Check out")
    }
}