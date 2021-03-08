package me.aaron.timer.projects;

import me.aaron.timer.Main;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AllDeathMessages {
    public static HashMap<Player, BossBar> bossBars = new HashMap<>();
    public static ArrayList<String> deathMessages = new ArrayList<>();
    public static String currentDeathMessage;

    public static void start() {
        if (deathMessages.isEmpty()) {
            add("<Player> was shot by [Mob]");
            add("<Player> was pricked to death");
            add("<Player> drowned");
            add("<Player> experienced kinetic energy");
            add("<Player> blew up");
            add("<Player> was blown up by [Mob]");
            add("<Player> was killed by [Intentional Game Design]");
            add("<Player> hit the ground too hard");
            add("<Player> fell from a high place");
            add("<Player> fell off a ladder");
            add("<Player> fell off some vines");
            add("<Player> fell off some weeping vines");
            add("<Player> fell off some twisting vines");
            add("<Player> fell off scaffolding");
            add("<Player> fell while climbing");
            add("<Player> was squashed by anvil");
            add("<Player> went up in flames");
            add("<Player> burned to death");
            add("<Player> went off with a bang");
            add("<Player> tried to swim in lava");
            add("<Player> was struck down by lightning");
            add("<Player> discovered the floor was lava");
            add("<Player> was killed by magic");
            add("<Player> was slain by [Mob]");
            add("<Player> was fireballed by [Mob]");
            add("<Player> was stung to death");
            add("<Player> suffocated in a wall");
            add("<Player> was poked to death by a sweet berry bush");
            add("<Player> was killed trying to hurt [Mob]");
            add("<Player> was impaled by [Mob]");
            add("<Player> fell out of the world");
            add("<Player> withered away");
            add("<Player> was roasted in dragon breath");
            add("<Player> was shot by a skull from [Mob]");
            add("<Player> walked into fire whilst fighting [Mob]");
            add("<Player> walked into a cactus whilst trying to escape [Mob]");
        }
        if (currentDeathMessage == null) {
            Random random = new Random();
            currentDeathMessage = deathMessages.get(random.nextInt(deathMessages.size()));
        }
        for (Player pl : Bukkit.getOnlinePlayers()) {
            BossBar bossBar = Bukkit.createBossBar(currentDeathMessage.replace("<Player>", pl.getName()), BarColor.BLUE, BarStyle.SOLID);
            bossBar.setVisible(true);
            bossBar.addPlayer(pl);
            bossBars.put(pl, bossBar);
        }
        update();
    }

    public static void update() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS) == SettingsItems.ItemState.ENABLED) {
                if (!deathMessages.isEmpty()) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        bossBars.get(pl).setVisible(true);
                        bossBars.get(pl).addPlayer(pl);
                        bossBars.get(pl).setTitle(currentDeathMessage.replace("<Player>", pl.getName()));
                    }
                } else {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        bossBars.get(pl).setTitle("You became all Deathmessages!");
                    }
                }
            } else {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    bossBars.get(pl).removeAll();
                }
            }
        }, 0, 10);
    }

    public static void add(String message) {
        deathMessages.add(message);
    }

    public static void addPlayer(Player p) {
        BossBar bossBar = Bukkit.createBossBar(currentDeathMessage.replace("<Player>", p.getName()), BarColor.BLUE, BarStyle.SOLID);
        bossBar.setVisible(true);
        bossBar.addPlayer(p);
        bossBars.put(p, bossBar);
    }
}
