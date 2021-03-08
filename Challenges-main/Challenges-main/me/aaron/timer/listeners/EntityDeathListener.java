package me.aaron.timer.listeners;

import me.aaron.timer.Main;
import me.aaron.timer.projects.AllMobs;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if (SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON) == SettingsItems.ItemState.ENABLED) {
            if (e.getEntity() instanceof EnderDragon) {
                if (Timer.state == Timer.TimerState.RUNNING) {
                    Timer.sendTimer(Timer.getCurrentTime());
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage("§7§m                                                 ");
                        pl.sendMessage(Main.getPrefix("Enderdragon", "The §5§lEnderdragon §7died."));
                        pl.sendMessage(Main.getPrefix("Enderdragon", "§aThe Challange is solved."));
                        pl.sendMessage(Main.getPrefix("Enderdragon", "Time needed: " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6§l")));
                        pl.sendMessage("§7§m                                                 ");
                    }
                    Timer.pause(false);
                }
            }
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.WITHER) == SettingsItems.ItemState.ENABLED) {
            if (e.getEntity() instanceof Wither) {
                if (Timer.state == Timer.TimerState.RUNNING) {
                    Timer.sendTimer(Timer.getCurrentTime());
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage("§7§m                                                 ");
                        pl.sendMessage(Main.getPrefix("Wither", "The §0§lW§7§li§0§lt§7§lh§0§le§7§lr §7died."));
                        pl.sendMessage(Main.getPrefix("Wither", "§aThe Challenge is finished."));
                        pl.sendMessage(Main.getPrefix("Wither", "Needed Time: " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6§l")));
                        pl.sendMessage("§7§m                                                 ");
                    }
                    Timer.pause(false);
                }
            }
        }

        if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS) == SettingsItems.ItemState.ENABLED) {
            if (e.getEntity().getKiller() != null) {
                AllMobs.killed(e.getEntityType());
            }
        }
    }
}
