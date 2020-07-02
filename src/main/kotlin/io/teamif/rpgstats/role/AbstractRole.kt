package io.teamif.rpgstats.role

import io.teamif.rpgstats.listener.PlayerDamageEventHandler
import io.teamif.rpgstats.plugin.RPGStatsPlugin
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

abstract class AbstractRole : PlayerDamageEventHandler {
    abstract val maxHealth: Double

    override fun playerDamageAction(event: EntityDamageEvent) {
        val data = RPGStatsPlugin.IOManager.playerData.data[((event.entity?: return) as Player).uniqueId?.toString()?: return]?: return
        data.health -= event.finalDamage
        event.damage = 0.0
    }
}