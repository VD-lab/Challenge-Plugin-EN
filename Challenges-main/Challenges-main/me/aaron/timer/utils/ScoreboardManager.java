package me.aaron.timer.utils;

import me.aaron.timer.Main;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import net.minecraft.server.v1_16_R3.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.Arrays;

public class ScoreboardManager extends JavaPlugin {
    public static void createScoreboard(Player p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
            if (SettingsModes.settings.get(SettingsItems.ItemType.STATS) == SettingsItems.ItemState.ENABLED) {
                p.setPlayerListHeader("§8§m                        §8[§6AlphaNoodle§8]§m                        §7\n \nWellcome §9" + p.getName() + " \n §7Player Online: §9" + Bukkit.getOnlinePlayers().size() + "\n\n§7 RAM-Stats: §9" + Utils.getPercent(Integer.parseInt(Runtime.getRuntime().maxMemory() + ""), Integer.parseInt((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) + "")) + "% §8 | §7TPS: §9" + Utils.getTPS() + "\n");
            } else {
                p.setPlayerListHeader("§8§m                        §8[§6AlphaNoodle§8]§m                        §7\n \nWellcome §9" + p.getName() + " \n §7Player Online: §9" + Bukkit.getOnlinePlayers().size() + "\n");
            }
            if (Bukkit.getServer().hasWhitelist()) {
                p.setPlayerListFooter("\n §7§oThese Network is private! \n §c§oIf these an Error please Contact the Admin!");
            } else {
                p.setPlayerListFooter("\n §7§oThese Network is public! \n §a§oHave fun!");
            }
            if (SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP) == SettingsItems.ItemState.ENABLED) {
                try {
                    if (Bukkit.getOnlinePlayers().size() != 0) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            Scoreboard board = pl.getScoreboard();
                            Objective objective = board.getObjective("showhealth");
                            if (objective == null) {
                                String dname = ChatColor.RED + "\u2665";
                                objective = board.registerNewObjective("showhealth", "health", dname, RenderType.HEARTS);
                                objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if (Bukkit.getOnlinePlayers().size() != 0) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            Scoreboard board = pl.getScoreboard();
                            Objective objective = board.getObjective("showhealth");
                            objective.unregister();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 20);
    }
}
