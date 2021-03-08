package me.aaron.timer.listeners;

import me.aaron.timer.utils.Permissions;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(p.getGameMode().equals(GameMode.SPECTATOR)) {
            e.setFormat("§8§oSpectator|" + Permissions.getPrefix(Permissions.getRank(p)) + "§7" + p.getName() + "§7§o » " + e.getMessage());
        } else {
            e.setFormat("§3" + Permissions.getPrefix(Permissions.getRank(p)) + "§9" + p.getName() + "§7 » §f" + e.getMessage());
        }
    }
}
