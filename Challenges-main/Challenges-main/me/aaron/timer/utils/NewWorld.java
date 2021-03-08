package me.aaron.timer.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Player;

public class NewWorld {
    String name = "default";

    public void nameWorld(String name) {
        this.name = name;
    }

    WorldCreator wc = new WorldCreator(name);
    WorldCreator def = new WorldCreator("default");
    WorldCreator nether = new WorldCreator("default_nether");
    WorldCreator end = new WorldCreator("default_the_end");
    public void setWc(WorldCreator wc, Player p, World.Environment environment) {
        this.wc = wc;
        wc.environment(environment);
        wc.createWorld();
        Location spawn = p.getBedSpawnLocation() == null ? Bukkit.getWorld(name).getSpawnLocation() : p.getBedSpawnLocation();
        p.teleport(spawn);
    }

    public void tpall(WorldCreator wc) {
        this.wc = wc;
        wc.createWorld();
        Location spawn = Bukkit.getWorld(name).getSpawnLocation();
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.teleport(spawn);
        }
    }

    public void reset(WorldCreator wc, WorldCreator nether, WorldCreator end) {
        this.def = wc;
        this.nether = nether;
        this.end = end;
        def.createWorld();
        nether.createWorld();
        end.createWorld();
        Location spawn = Bukkit.getWorld("default").getSpawnLocation();
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.teleport(spawn);
        }
    }

    public void getWorld(Player p) {
        p.sendMessage("§8[§6World§8] §fYou are now in World §6" + p.getWorld().getName());
    }
}
