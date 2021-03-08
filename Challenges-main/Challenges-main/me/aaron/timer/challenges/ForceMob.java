package me.aaron.timer.challenges;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class ForceMob implements Listener {
    public static int ForceMobScheduler;
    private Main plugin;
    private BossBar bossBar;
    private int neededtime;
    private int currenttime;
    public static EntityType forcedMob;
    private int lefttime;
    String MobNameWithDash;
    String MobName;
    public static int FreeTimeMin;
    public static int FreeTimeMax;
    public static int SearchTimeMin;
    public static int SearchTimeMax;

    public ForceMob (Main plugin) {
        this.plugin = plugin;
    }

    public void start() {
        forcedMob = null;
        neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
        currenttime = 0;
        bossBar = Bukkit.createBossBar("The Timer is paused.", BarColor.WHITE, BarStyle.SOLID);
        bossBar.setVisible(true);
        for (Player pl : Bukkit.getOnlinePlayers()) {
            addPlayer(pl);
        }
        update();
    }

    public void update() {
        ForceMobScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    addPlayer(pl);
                }
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (!(currenttime >= neededtime)) {
                        if (forcedMob == null) {
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle("Wait for new §9Statement §7...");
                            bossBar.setProgress(1);
                            currenttime++;
                        } else {
                            lefttime = neededtime - currenttime;
                            bossBar.setProgress(Utils.getBossBarProgress(neededtime, currenttime, true));
                            bossBar.setTitle("§7Kill in " + Timer.ConvertTimerTime(lefttime, "§9") + " §9" + Utils.firstLatterCapitalized(MobName));
                            bossBar.setColor(BarColor.BLUE);
                            currenttime ++;
                        }
                    } else {
                        if (forcedMob == null) {
                            forcedMob = getRandomEntity();
                            neededtime = Utils.getRandomInt(SearchTimeMin, SearchTimeMax);
                            currenttime = 0;
                            MobNameWithDash = forcedMob.toString();
                            MobName = MobNameWithDash.replace("_", " ");
                            bossBar.setTitle("§7Töte in " + Timer.ConvertTimerTime(neededtime - currenttime, "§9") + " §9" + Utils.firstLatterCapitalized(MobName));
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage(Main.getPrefix("Force-Mob", "§9New Statement: §7Kill in " + Timer.ConvertTimerTime(neededtime - currenttime, "§6") + " §9" + Utils.firstLatterCapitalized(MobName)));
                            }
                        } else {
                            forcedMob = null;
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.setHealth(0);
                            }
                        }
                    }
                } else {
                    bossBar.setColor(BarColor.WHITE);
                    bossBar.setTitle("The Timer is paused.");
                    bossBar.setProgress(1);
                }
            } else {
                bossBar.setVisible(false);
                stop();
            }
        }, 0, 20);
    }

    public EntityType getRandomEntity() {
        EntityType mob = null;
        Random random = new Random();
        while (mob == null) {
            mob = EntityType.values()[random.nextInt(EntityType.values().length)];
            if (!mob.isAlive()) {
                mob = null;
            }
            if (mob == EntityType.ENDER_DRAGON || mob == EntityType.WITHER || mob == EntityType.ENDER_SIGNAL || mob == EntityType.ENDER_CRYSTAL || mob == EntityType.ILLUSIONER || mob == EntityType.GIANT || mob == EntityType.AREA_EFFECT_CLOUD || mob == EntityType.ARROW || mob == EntityType.ARMOR_STAND) {
                mob = null;
            }
        }
        return mob;
    }

    public void stop() {
        Bukkit.getScheduler().cancelTask(ForceMobScheduler);
    }

    public void addPlayer(Player p) {
        bossBar.addPlayer(p);
    }

    @EventHandler
    public void onEntityKill(EntityDeathEvent e) {
        Entity ent = e.getEntity();
        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                if (ent.getType().equals(forcedMob)) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage(Main.getPrefix("Force-Mob", "The Mob was killed."));
                    }
                    neededtime = Utils.getRandomInt(FreeTimeMin, FreeTimeMax);
                    currenttime = 0;
                    forcedMob = null;
                }
            }
        }
    }
}
