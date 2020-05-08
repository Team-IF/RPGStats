package io.teamif.rpgstats.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Main class of the plugin
 */
@SuppressWarnings("unused")
public final class RPGStatsPlugin extends JavaPlugin {
    /**
     * Called on enabling process
     */
    @Override
    public void onEnable() {
        final Logger logger = getLogger();
        logger.info("========================================");
        logger.info("Enabling RPGStats Plugin...");
        logger.info("Plugin Made By. Team IF (PatrickKR, Coder-Iro, GPL_Developer)");
        logger.info("========================================");
        getServer().getPluginManager().registerEvents(new CommonListener(this), this);
    }

    /**
     * Called on disabling process
     */
    @Override
    public void onDisable() {
        getLogger().info("========================================");
        getLogger().info("Disabling RPGStats Plugin...");
        getLogger().info("========================================");
    }
}
