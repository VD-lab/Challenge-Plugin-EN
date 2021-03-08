package me.aaron.timer.listeners;

import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Timer;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class InteractEntityListener implements Listener {
    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            if (SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING) == SettingsItems.ItemState.ENABLED) {
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
