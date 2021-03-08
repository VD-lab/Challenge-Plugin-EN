package me.aaron.timer.utils;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Backup {
    public static int timertime;
    public void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), () -> {
            if (Bukkit.getOnlinePlayers().size() != 0) {
                timertime ++;
            }
            int current = SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) * 3600;
            if (timertime == current) {
                timertime = 0;
                Bukkit.savePlayers();
                backup();
            }
        }, 0, 20);
    }

    public static void backup() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
            File backupdir = new File("./Backups");
            File dir = new File("./");
            if (!backupdir.exists()) {
                backupdir.mkdir();
            }
            try {
                copy(dir.getAbsolutePath(), backupdir.getAbsolutePath(), dtf.format(LocalDateTime.now()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Bukkit.broadcastMessage("§7§o[Server]: Backup wurde gespeichert.");
        Config.saveConfig();
    }

    public static void copy(String source, String destination, String name) {
        Bukkit.getScheduler().runTaskAsynchronously(JavaPlugin.getPlugin(Main.class), () -> {
            File srcWorld = new File(source + "/world");
            File srcNether = new File(source + "/world_nether");
            File srcEnd = new File(source + "/world_the_end");
            File destWorld = new File(destination + "/" + name + "/world");
            File destNether = new File(destination + "/" + name +  "/world_nether");
            File destEnd = new File(destination + "/" + name + "/world_the_end");

            if (!destWorld.exists()) {
                destWorld.mkdir();
            }
            if (!destNether.exists()) {
                destNether.mkdir();
            }
            if (!destEnd.exists()) {
                destEnd.mkdir();
            }

            try {
                FileUtils.copyDirectory(srcWorld, destWorld);
                FileUtils.copyDirectory(srcNether, destNether);
                FileUtils.copyDirectory(srcEnd, destEnd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}