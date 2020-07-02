package io.teamif.rpgstats.role

import io.teamif.rpgstats.listener.PlayerInteractEventHandler
import io.teamif.rpgstats.listener.PlayerKillEntityEventHandler
import io.teamif.rpgstats.plugin.RPGStatsPlugin
import org.bukkit.Material
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.util.Vector

abstract class ThiefRole : AbstractRole(), PlayerInteractEventHandler, PlayerKillEntityEventHandler {
    override fun playerInteractAction(event: PlayerInteractEvent) {
        val player = event.player
        when (val material = event.item?.type?: return) {
            Material.FEATHER -> {
                if (!player.hasCooldown(material)) {
                    event.isCancelled = true
                    player.location.direction?.normalize()?.run {
                        if (x == 0.0 && z == 0.0) {
                            player.sendMessage("위/아래를 바라보고 사용하지 말아주세요")
                            return
                        }
                        player.setCooldown(material, 120)
                        Vector(x, 0.0, z).normalize()?.multiply(2)?.run {
                            player.velocity = add(Vector(0.0, 0.4, 0.0))
                        }
                    }
                }
            }
        }
    }

    override fun playerKillEntityAction(event: EntityDeathEvent) {
        val data = RPGStatsPlugin.IOManager.playerData.data[event.entity?.killer?.uniqueId?.toString()?: return]?: return
        data.health += maxHealth / 20
    }
}