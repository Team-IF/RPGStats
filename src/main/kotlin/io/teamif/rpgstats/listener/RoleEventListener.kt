package io.teamif.rpgstats.listener

import io.teamif.rpgstats.plugin.RPGStatsPlugin
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
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
        val damager = event.damager
        if (damager != null && damager is Player && damager.role is PlayerHitEntityEventHandler) {
            (damager.role as PlayerHitEntityEventHandler).playerHitEntityAction(event)
        }
    }

    @EventHandler
    fun onEntityDamage(event: EntityDamageEvent) {
        val entity = event.entity?: return
        if (entity is Player && entity.role is PlayerHitEntityEventHandler) {
            (entity.role as PlayerDamageEventHandler).playerDamageAction(event)
        }
    }

    @EventHandler
    fun onEntityDeath(event: EntityDeathEvent) {
        val entity = event.entity?: return
        val killer = entity.killer?: return
        if (killer.role is PlayerKillEntityEventHandler) {
            (killer.role as PlayerKillEntityEventHandler).playerKillEntityAction(event)
        }
    }

    val Player.role
        get() = RPGStatsPlugin.IOManager.playerData.data[player.uniqueId.toString()]?.role
}