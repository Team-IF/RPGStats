package io.teamif.rpgstats.plugin

//import io.teamif.rpgstats.player.Player
//import io.teamif.rpgstats.role.RoleType
//import io.teamif.rpgstats.tribe.TribeType
import io.teamif.rpgstats.listener.CommonListener
import io.teamif.rpgstats.listener.RoleEventListener
import io.teamif.rpgstats.util.json.io.JsonIOHandler
import io.teamif.rpgstats.util.json.io.JsonIOManager
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
//import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

/**
 * Main class of the plugin
 */
class RPGStatsPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: RPGStatsPlugin
            private set
        internal lateinit var IOManager: JsonIOManager
    }

    /**
     * Called on enabling process
     */
    override fun onEnable() {
        instance = this
        IOManager = JsonIOManager()

        JsonIOHandler.FOLDER.mkdirs()
//        server.scheduler.runTaskTimer(this, {
//            IOManager.saveJson()
//            Bukkit.broadcastMessage("서버 파일 자동 저장중입니다!")
//        }, 0, 12000)

        server.pluginManager.run {
            registerEvents(RoleEventListener(), instance)
            registerEvents(CommonListener(), instance)
        }

        server.scheduler.runTaskTimer(this, {
            IOManager.playerData.data.forEach {
                server.getPlayer(UUID.fromString(it.key))?.spigot()?.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("HEALTH: ${it.value.health}").first())
            }
        }, 0, 1)

        logger.info("========================================")
        logger.info("Enabling RPGStats Plugin...")
        logger.info("Plugin Made By. Team IF (PatrickKR, Coder-Iro, GPL_Developer)")
        logger.info("========================================")

//        IOManager.run {
//            loadJsons()
//            playerData.data["b10b8b62-92b2-40c8-9838-d97470b9f62c"] = Player(TribeType.Human, RoleType.Rogue)
//            saveJson()
//            loadJsons()
//            println(playerData.data["b10b8b62-92b2-40c8-9838-d97470b9f62c"]?.run { "${tribeType.tribeName} + ${roleType.roleName}" })
//        }
    }

    /**
     * Called on disabling process
     */
    override fun onDisable() {
        logger.info("========================================")
        logger.info("Disabling RPGStats Plugin...")
        logger.info("========================================")
    }
}