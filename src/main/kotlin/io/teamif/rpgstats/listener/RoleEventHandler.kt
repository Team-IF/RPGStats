package io.teamif.rpgstats.listener

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.potion.PotionEffectType

interface PlayerInteractEventHandler {
    fun playerInteractAction(event: PlayerInteractEvent)
}

interface PlayerHitEntityEventHandler {
    fun playerHitEntityAction(event: EntityDamageByEntityEvent)

    fun isCritical(player: Player): Boolean {
        return player.fallDistance > 0.0f &&
                !player.isOnGround &&
                !player.isInsideVehicle &&
                !player.hasPotionEffect(PotionEffectType.BLINDNESS) &&
                player.location.block.type !== Material.LADDER &&
                player.location.block.type !== Material.VINE
    }
}

interface PlayerDamageEventHandler {
    fun playerDamageAction(event: EntityDamageEvent)
}

interface PlayerKillEntityEventHandler {
    fun playerKillEntityAction(event: EntityDeathEvent)
}