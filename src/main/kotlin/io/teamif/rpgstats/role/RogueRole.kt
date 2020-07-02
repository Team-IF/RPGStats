package io.teamif.rpgstats.role

import io.teamif.rpgstats.listener.EntityDamageByEntityEventHandler
import io.teamif.rpgstats.listener.PlayerInteractEventHandler
import io.teamif.rpgstats.plugin.RPGStatsPlugin
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import kotlin.random.Random

class RogueRole : AbstractRole(RoleType.Rogue), PlayerInteractEventHandler, EntityDamageByEntityEventHandler {
    private var count = 0

    override fun playerInteractAction(event: PlayerInteractEvent) {
        val player = event.player
        when (val material = event.item?.type?: return) {
            Material.RED_MUSHROOM -> {
                if (!player.hasCooldown(material)) {
                    event.isCancelled = true
                    player.setCooldown(material, 1200)
                    with(RPGStatsPlugin.instance) {
                        Bukkit.getOnlinePlayers().forEach {
                            it.hidePlayer(this, player)
                        }
                        player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 60, 5, false, false))
                        server.scheduler.runTaskLater(this, {
                            Bukkit.getOnlinePlayers().forEach {
                                it.showPlayer(this, player)
                            }
                        }, 60)
                    }
                }
            }
        }
    }

    override fun entityDamageByEntityAction(event: EntityDamageByEntityEvent) {
        val player = event.damager as Player

        if (isCritical(player))
            event.damage /= 1.5

        if (Random.nextDouble() < 0.1 || ++count == 7) {
            count = 0
            event.damage *= 1.5
        }

        player.sendMessage("Damage: ${event.finalDamage}")
    }
}