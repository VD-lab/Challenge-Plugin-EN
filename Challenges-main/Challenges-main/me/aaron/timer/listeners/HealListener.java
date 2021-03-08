package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class HealListener implements Listener {
    @EventHandler
    public void onHeal(EntityRegainHealthEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            if (SettingsModes.settings.get(SettingsItems.ItemType.GEITEILTEHERZEN) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    pl.setHealth(p.getHealth());
                }
            }
            if (SettingsModes.gamerule.get(SettingsItems.ItemType.OTHERREGENERATION) == SettingsItems.ItemState.DISABLED || Timer.state == Timer.TimerState.PAUSED) {
                if (e.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC || e.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC_REGEN) {
                    e.setCancelled(true);
                }
            }
            if (SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS) == SettingsItems.ItemState.ENABLED) {
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (p.getHealth() == SettingsModes.maxHP - 1) {
                        p.setHealth(0);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendMessage(" ");
                            pl.sendMessage("§8[§6Full Hearth§8] §e§l" + p.getName() + " §7had full Hearths.");
                            pl.sendMessage(" ");
                        }
                    }
                }
            }
        }
    }
}
