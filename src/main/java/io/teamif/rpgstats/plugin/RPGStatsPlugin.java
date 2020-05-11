package io.teamif.rpgstats.plugin;

import io.teamif.rpgstats.listener.CommonListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.util.logging.Logger;

/**
 * Main class of the plugin
 */
@SuppressWarnings("unused")
public final class RPGStatsPlugin extends JavaPlugin {

    public static RPGStatsPlugin instance;

    /**
     * Called on enabling process
     */
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
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
