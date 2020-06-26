package io.teamif.rpgstats.plugin

//DEBUG START
//import io.teamif.rpgstats.player.Player
//import io.teamif.rpgstats.role.RoleType
//import io.teamif.rpgstats.tribe.TribeType
//DEBUG END
import io.teamif.rpgstats.util.json.io.JsonIOHandler
import io.teamif.rpgstats.util.json.io.JsonIOManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

/**
 * Main class of the plugin
 */
class RPGStatsPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: RPGStatsPlugin
            private set
        private lateinit var IOManager: JsonIOManager
    }

    /**
     * Called on enabling process
     */
    override fun onEnable() {
        instance = this
        IOManager = JsonIOManager()

        saveDefaultConfig()
        JsonIOHandler.FOLDER.mkdir()
        server.scheduler.runTaskTimer(this, {
            IOManager.saveJson()
            Bukkit.broadcastMessage("서버 파일 자동 저장중입니다!")
        }, 0, 12000)

        logger.info("========================================")
        logger.info("Enabling RPGStats Plugin...")
        logger.info("Plugin Made By. Team IF (PatrickKR, Coder-Iro, GPL_Developer)")
        logger.info("========================================")

//        DEBUG START
//        IOManager.run {
//            loadJsons()
//            playerData.data["b10b8b6292b240c89838d97470b9f62c"] = Player(TribeType.Human, RoleType.Wizard)
//            saveJson()
//            loadJsons()
//            println(playerData.data["b10b8b6292b240c89838d97470b9f62c"]?.run { "${tribeType.tribeName} + ${roleType.roleName}" })
//        }
//        DEBUG END
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