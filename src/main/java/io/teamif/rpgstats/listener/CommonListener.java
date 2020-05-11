package io.teamif.rpgstats.listener;

import io.teamif.rpgstats.plugin.RPGStatsPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CommonListener implements Listener {
    private final RPGStatsPlugin plugin;

    public CommonListener(RPGStatsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info(event.getPlayer().getName() + " joined.");
    }
}
