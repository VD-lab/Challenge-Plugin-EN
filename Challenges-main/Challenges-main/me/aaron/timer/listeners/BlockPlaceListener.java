package me.aaron.timer.listeners;

import me.aaron.timer.utils.Permissions;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onPlayer(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Timer.state == Timer.TimerState.PAUSED && SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                e.setCancelled(true);
                p.sendMessage("§cThe Timer is paused!");
            }
        }

        if (Permissions.getRank(p) == Permissions.Rank.GUEST) {
            e.setCancelled(true);
            p.sendMessage("§7You are Rank §9Guest, §7Guests cant place Blocks. The Command §9/rank <guest | user | op | admin> §7can be only used by a Server Admin.");
        }
    }
}
