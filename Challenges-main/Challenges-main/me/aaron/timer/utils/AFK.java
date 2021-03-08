package me.aaron.timer.utils;

import me.aaron.timer.Main;
import me.aaron.timer.listeners.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class AFK {
    public static ArrayList<Player> afk = new ArrayList<>();
    public static HashMap<Player, Long> oldTime = new HashMap<>();
    public static void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            if (SettingsModes.settings.get(SettingsItems.ItemType.AFK) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    if (MoveListener.lastMovement.get(pl) < System.currentTimeMillis() / 1000 - 300) {
                        if (!afk.contains(pl)) {
                            afk.add(pl);
                            pl.setDisplayName("§8[§7AFK§8] §7" + pl.getName());
                            pl.setPlayerListName("§8§o[§7§oAFK§8§o] §7§o" + pl.getName());
                            for (Player pl2 : Bukkit.getOnlinePlayers()) {
                                if (pl2 == pl) {
                                    pl.sendMessage(Main.getPrefix("AFK", "You now AFK."));
                                } else {
                                    pl2.sendMessage(Main.getPrefix("AFK", "The Player §6" + pl.getName() + " §7is now AFK."));
                                }
                            }
                        }
                    } else {
                        if (afk.contains(pl)) {
                            afk.remove(pl);
                            Utils.setNewRankPrefix(pl, Permissions.getRank(pl));
                            for (Player pl2 : Bukkit.getOnlinePlayers()) {
                                if (pl2 == pl) {
                                    pl.sendMessage(Main.getPrefix("AFK", "You now not AFKed"));
                                    pl.sendMessage(Main.getPrefix("AFK", "You was for the last " + Timer.ConvertTimerTime(Integer.parseInt("" + ((System.currentTimeMillis() / 1000 - 300) - oldTime.get(pl))), "§9§l") + " §7AFK."));
                                } else {
                                    pl2.sendMessage(Main.getPrefix("AFK", "The Player §6" + pl.getName() + " §7is now not any more AFK."));
                                }
                            }
                        }
                    }
                }
            }
        }, 0, 5);
    }

    public static void newMovement(Player p, Long time) {
        oldTime.put(p, time);
    }
}
