package me.aaron.timer.challenges;

import me.aaron.timer.Main;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Random;

public class ForceBiome {
    public static int ForceBiomeScheduler;
    public BossBar bossBar;
    public int neededtime;
    public int currenttime;
    public static Biome forcedbiome;
    public static int FreeTimeMin;
    public static int FreeTimeMax;
    public static int SearchTimeMin;
    public static int SearchTimeMax;

    public void start() {
        forcedbiome = null;
        neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
        currenttime = 0;
        bossBar = Bukkit.createBossBar("The Timer is paused.", BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(true);
        for (Player pl : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(pl);
        }
        update();
    }

    public void update() {
        ForceBiomeScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    bossBar.addPlayer(pl);
                }
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (!(currenttime >= neededtime)) {
                        if (forcedbiome == null) {
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle("Wait for a new §9Biom§7 ...");
                            bossBar.setProgress(1);
                        } else {
                            bossBar.setProgress(Utils.getBossBarProgress(neededtime, currenttime, true));
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle("§7Biom: §9" + Utils.firstLatterCapitalized(forcedbiome.toString().replace("_", " ")) + " §8| §7Zeit: " + Timer.ConvertTimerTime((neededtime - currenttime), "§9"));
                        }
                        currenttime++;
                    } else {
                        if (forcedbiome == null) {
                            forcedbiome = randomBiome();
                            neededtime = Utils.getRandomInt(SearchTimeMin, SearchTimeMax);
                            currenttime = 0;
                            bossBar.setTitle("§7Biom: §9" + Utils.firstLatterCapitalized(forcedbiome.toString().replace("_", " ")) + " §8| §7Zeit: " + Timer.ConvertTimerTime((neededtime - currenttime), "§9"));
                            Utils.sendTitle("§9New Biom", "§7Find §9" + Utils.firstLatterCapitalized(forcedbiome.toString().replace("_", " ")));
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage(Main.getPrefix("Force Biome", "§9Find §9" +  Utils.firstLatterCapitalized(forcedbiome.toString().replace("_", " ")) + " §7in §9" + Timer.ConvertTimerTime(neededtime, "§9")));
                            }
                        } else {
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.setHealth(0);
                            }
                            neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
                            currenttime = 0;
                            forcedbiome = null;
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
                Bukkit.getScheduler().cancelTask(ForceBiomeScheduler);
            }
        }, 0, 20);
    }

    public Biome randomBiome() {
        Random random = new Random();
        ArrayList<Player> OnlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Player p = OnlinePlayers.get(random.nextInt(OnlinePlayers.size()));
        Biome biome = null;
        Location loc = p.getLocation();
        World w = p.getWorld();
        boolean found = false;
        Location location;
        while (biome == null) {
            biome = Biome.values()[random.nextInt(Biome.values().length)];
            for (int ix = 0; ix < 1500; ix += 10) {
                for (int iy = 0; iy < 1500; iy += 10) {
                    location = new Location(w, ix, p.getLocation().getBlockY(), iy);
                    if (location.getBlock().getBiome() == biome) {
                        found = true;
                        break;
                    }
                    if (found) {
                        break;
                    }
                }
            }
            if (found) {
                return biome;
            } else {
                biome = null;
            }
        }
        return biome;
    }
}
