package me.aaron.timer.challenges;

import me.aaron.timer.Main;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ForceHeight {
    public static int ForceHeightScheduler;
    private BossBar bossBar;
    private int neededtime;
    private int currenttime;
    public static int forcedheight;
    public static int FreeTimeMin;
    public static int FreeTimeMax;
    public static int SearchTimeMin;
    public static int SearchTimeMax;

    public void start() {
        forcedheight = 0;
        neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
        currenttime = 0;
        bossBar = Bukkit.createBossBar("The Timer is Paused.", BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(true);
        for (Player pl : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(pl);
        }
        update();
    }

    public void update() {
        ForceHeightScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    bossBar.addPlayer(pl);
                }
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (!(currenttime >= neededtime)) {
                        if (forcedheight == 0) {
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle("Wait for new §9Height§7 ...");
                            bossBar.setProgress(1);
                        } else {
                            bossBar.setProgress(Utils.getBossBarProgress(neededtime, currenttime, true));
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle("§7Height: §9" + forcedheight + " §8| §7Time: " + Timer.ConvertTimerTime((neededtime - currenttime), "§9"));
                        }
                        currenttime++;
                    } else {
                        if (forcedheight == 0) {
                            forcedheight = Utils.getRandomInt(1, 256);
                            neededtime = Utils.getRandomInt(SearchTimeMin, SearchTimeMax);
                            currenttime = 0;
                            bossBar.setTitle("§7Height: §9" + forcedheight + " §8| §7Time: " + Timer.ConvertTimerTime((neededtime - currenttime), "§9"));
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage(Main.getPrefix("Force Height", "§9New Statement: §7Stand in " + Timer.ConvertTimerTime(neededtime, "§9") + " §7on Height §9" + forcedheight));
                            }
                        } else {
                            int checkedplayers = 0;
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                if (pl.getLocation().getBlockY() != forcedheight) {
                                    pl.setHealth(0);
                                    for (Player pl2 : Bukkit.getOnlinePlayers()) {
                                        pl2.sendMessage(Main.getPrefix("Force Height", "§cThe Player §9" + pl.getName() + " §7was not on the Height §9" + forcedheight + "§7."));
                                    }
                                } else {
                                    checkedplayers++;
                                }
                            }
                            if (checkedplayers == Bukkit.getOnlinePlayers().size()) {
                                for (Player pl : Bukkit.getOnlinePlayers()) {
                                    pl.sendMessage(Main.getPrefix("Force Height", "§aAll Players §7were on the Height §9" + forcedheight));
                                }
                            }
                            neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
                            currenttime = 0;
                            forcedheight = 0;
                        }
                    }
                } else {
                    bossBar.setColor(BarColor.WHITE);
                    bossBar.setTitle("The Timer is paused.");
                    bossBar.setProgress(1);
                }
            } else {
                bossBar.removeAll();
                bossBar.setVisible(false);
                Bukkit.getScheduler().cancelTask(ForceHeightScheduler);
            }
        }, 0, 20);
    }
}
