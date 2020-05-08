package io.teamif.rpgstats.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CommonListener implements Listener {
    public CommonListener(RPGStatsPlugin plugin) {
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        // register??
    }
}
