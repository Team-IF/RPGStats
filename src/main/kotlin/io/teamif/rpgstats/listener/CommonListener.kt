package io.teamif.rpgstats.listener

import io.teamif.rpgstats.player.Player
import io.teamif.rpgstats.plugin.RPGStatsPlugin
import io.teamif.rpgstats.role.RoleType
import io.teamif.rpgstats.tribe.TribeType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

internal class CommonListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val uuid = event.player.uniqueId.toString()
        RPGStatsPlugin.IOManager.playerData.data[uuid] = Player(uuid, TribeType.Human, RoleType.Rogue)
    }
}