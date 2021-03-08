package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener {
    @EventHandler
    public void onFoodRegain(FoodLevelChangeEvent e) {
        if (SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                e.setCancelled(true);
            }
        }
        if (Timer.state == Timer.TimerState.PAUSED && SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
            e.setCancelled(true);
        }
    }
}
