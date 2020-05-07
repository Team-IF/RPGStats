package io.teamif.rpgstats.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class RPGStatsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("========================================");
		getLogger().info("Enabling RPGStats Plugin...");
		getLogger().info("Plugin Made By. Team IF (PatrickKR, Coder-Iro)");
        getLogger().info("========================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("========================================");
		getLogger().info("Disabling RPGStats Plugin...");
        getLogger().info("========================================");
    }
}
