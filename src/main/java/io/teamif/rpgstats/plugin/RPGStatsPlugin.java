package io.teamif.rpgstats.plugin;

import org.bukkit.plugin.java.JavaPlugin;

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
        getLogger().info("========================================");
		getLogger().info("Enabling RPGStats Plugin...");
		getLogger().info("Plugin Made By. Team IF (PatrickKR, Coder-Iro)");
        getLogger().info("========================================");
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
