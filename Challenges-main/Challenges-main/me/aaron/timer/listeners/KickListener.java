package me.aaron.timer.listeners;

import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickListener implements Listener {
    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        e.setLeaveMessage("8[§6Kick§8] §9§l" + p.getName() + "§7was kicked");
        if (SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD) == SettingsItems.ItemState.ENABLED && !e.getReason().contains("gebannt")) {
            e.setCancelled(true);
            Utils.SendToServer(p, "hub");
        }
    }
}
