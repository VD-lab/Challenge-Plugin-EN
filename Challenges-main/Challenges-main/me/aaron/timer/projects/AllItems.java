package me.aaron.timer.projects;

import me.aaron.timer.Main;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AllItems {
    public static int ItemScheduler;
    public static BossBar bossBar;
    public static Material item;
    public static List<String> items = new ArrayList<>();

    public static void start() {
        if (items.size() == 0) {
            for (Material mat : Material.values()) {
                items.add(mat.toString());
            }
            items.removeIf(str -> str.contains("WALL_") || str.contains("SPAWN_EGG") || str.equalsIgnoreCase("AIR") || str.equalsIgnoreCase("BEDROCK") || str.contains("PORTAL"));
        }
        if (item == null) {
            item = Material.valueOf(items.get(Utils.getRandomInt(0, items.size() - 1)));
        }
        bossBar = Bukkit.createBossBar("", BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(true);
        for (Player pl : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(pl);
        }
        update();
    }

    public static void update() {
        ItemScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS) == SettingsItems.ItemState.ENABLED) {
                if (items.size() != 0) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        bossBar.addPlayer(pl);
                        if (pl.getInventory().contains(item)) {
                            next();
                        }
                    }
                    bossBar.setTitle("§7Item §8» §f§o" + Utils.firstLatterCapitalized(item.getKey().getKey().replace("_", " ")));
                } else {
                    bossBar.removeAll();
                    bossBar.setVisible(false);
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage("§lAlle Items §8» §a§lAlle Items gesammelt!");
                        pl.playSound(pl.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 30, 1);
                    }
                    Bukkit.getScheduler().cancelTask(ItemScheduler);
                }
            } else {
                bossBar.removeAll();
            }
        }, 0, 10);
    }

    public static void next() {
        Material old = item;
        items.remove(old.toString());
        if (items.size() != 0) {
            item = Material.valueOf(items.get(Utils.getRandomInt(0, items.size() - 1)));
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.sendMessage("§lAll Items §8» §7An Item was detected: §e§l" + Utils.firstLatterCapitalized(old.getKey().getKey().replace("_", " ")) + "§7. New Item: §a§l" + Utils.firstLatterCapitalized(item.getKey().getKey().replace("_", " ")) + " §8(§7Only §f§l" + (items.size()) + " §7Items missing, keep going!§8)");
            }
        }
    }
}
