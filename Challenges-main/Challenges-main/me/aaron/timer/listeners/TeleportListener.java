package me.aaron.timer.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Objects;

public class TeleportListener implements Listener {
    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        Player p = e.getPlayer();

        Location to = e.getTo();

        //p.teleport(to);

        //p.sendMessage("§8[§6Teleport§8] §6§l" + p.getName() + "§7 was teleported §9" + to.getBlockX() + ", " + to.getBlockY() + ", " + to.getBlockZ() + "§7.");
    }
}
