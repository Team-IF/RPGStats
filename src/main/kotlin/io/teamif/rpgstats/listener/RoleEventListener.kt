package io.teamif.rpgstats.listener

import io.teamif.rpgstats.plugin.RPGStatsPlugin
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

internal class RoleEventListener : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val role = event.player.role?: return
        if (role is PlayerInteractEventHandler) {
            (role as PlayerInteractEventHandler).playerInteractAction(event)
        }
    }

    @EventHandler
    fun onEntityDamageByEntity(event: EntityDamageByEntityEvent) {
        val entity = event.damager
        if (entity is Player && entity.role is EntityDamageByEntityEventHandler) {
            (entity.role as EntityDamageByEntityEventHandler).entityDamageByEntityAction(event)
        }
    }

    val Player.role
        get() = RPGStatsPlugin.IOManager.playerData.data[player.uniqueId.toString()]?.role
}