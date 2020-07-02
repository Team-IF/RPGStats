package io.teamif.rpgstats.player

import io.teamif.rpgstats.role.AbstractRole
import io.teamif.rpgstats.role.RoleType
import io.teamif.rpgstats.tribe.TribeType
import org.bukkit.Bukkit
import java.util.UUID

class Player(private val uuid: String, tribeType: TribeType, roleType: RoleType) {
    val role: AbstractRole = roleType.roleClass.newInstance()

    var level = 0
        internal set

    private var maxHealth = role.maxHealth

    var health = maxHealth
        internal set(value) {
            val player = Bukkit.getPlayer(UUID.fromString(uuid))?: return
            var temp = value.coerceIn(0.0..maxHealth)
            player.health = temp * 20.0 / maxHealth
            if (temp == 0.0)
                temp = maxHealth
            field = temp
        }
}