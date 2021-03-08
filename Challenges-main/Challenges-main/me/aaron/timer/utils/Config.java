package me.aaron.timer.utils;

import javafx.geometry.Pos;
import me.aaron.timer.Main;
import me.aaron.timer.challenges.*;
import me.aaron.timer.commands.BackpackCommand;
import me.aaron.timer.projects.AllDeathMessages;
import me.aaron.timer.projects.AllItems;
import me.aaron.timer.projects.AllMobs;
import me.aaron.timer.tabCompletes.PositionTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Config {

    private static File file;
    private static YamlConfiguration config;

    public Config() {
        File dir = new File("./plugins/Challenges");
        if(!dir.exists()) {
            dir.mkdir();
        }

        file = new File(dir, "config.yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);

    }

    public static boolean contains(String path) {
        return config.contains(path);
    }
    public static void set(String path, Object value) throws IOException {
        config.set(path, value);
        config.save(file);
    }

    public Object get(String path) {
        if(!contains(path)) {
            return null;
        }
        return config.get(path);
    }
    public void delete(String path) throws IOException {
        config.set(path, null);
        config.save(file);
    }

    public static int getInt(String path) {
        return config.getInt(path);
    }

    public static String getString(String path) {
        return config.getString(path);
    }

    public static Double getDouble(String path) {
        return config.getDouble(path);
    }

    public static ArrayList getArrayList(String path) {
        return (ArrayList) config.getList(path);
    }

    public static Boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public File getFile() {
        return file;
    }

    public static boolean saveConfig() {
        try {
            config.set("dev.debugmode", Main.debug);
            config.set("timer.currenttime", SettingsModes.currentTime);
            config.set("timer.reverse", SettingsModes.timer.get(SettingsItems.ItemType.REVERSE).name());
            config.set("timer.starttime", SettingsModes.startTime);
            config.set("timer.autostart", SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART).name());
            config.set("timer.state", Timer.state.name());
            config.set("settings.onelife", SettingsModes.settings.get(SettingsItems.ItemType.ONELIFE).name());
            config.set("settings.geteilteherzen", SettingsModes.settings.get(SettingsItems.ItemType.GEITEILTEHERZEN).name());
            config.set("settings.respawn", SettingsModes.settings.get(SettingsItems.ItemType.RESPAWN).name());
            config.set("settings.dmgalert", SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT).name());
            config.set("settings.timer", SettingsModes.settings.get(SettingsItems.ItemType.TIMER).name());
            config.set("settings.backpack", SettingsModes.settings.get(SettingsItems.ItemType.BACKPACK).name());
            config.set("settings.scoreboard", SettingsModes.settings.get(SettingsItems.ItemType.SCOREBOARD).name());
            config.set("settings.maxhp", SettingsModes.maxHP);
            config.set("settings.sendtitle", SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE).name());
            config.set("settings.showcoordsondeath", SettingsModes.settings.get(SettingsItems.ItemType.SHOWCOORDSONDEAETH).name());
            config.set("settings.resetconfirm", SettingsModes.settings.get(SettingsItems.ItemType.RESETCONFIRM).name());
            config.set("settings.hardcore", SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE).name());
            config.set("settings.bungeecord", SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD).name());
            config.set("settings.backup", SettingsModes.ints.get(SettingsItems.ItemType.BACKUP));
            config.set("settings.backuptimer", Backup.timertime);
            config.set("settings.afk", SettingsModes.settings.get(SettingsItems.ItemType.AFK).name());
            config.set("settings.stats", SettingsModes.settings.get(SettingsItems.ItemType.STATS).name());
            config.set("settings.update-checker", SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER).name());
            config.set("scoreboard.tabhp", SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP).name());
            config.set("gamerule.naturalregeneration", SettingsModes.gamerule.get(SettingsItems.ItemType.NATURALREGENERATION).name());
            config.set("gamerule.otherregeneration", SettingsModes.gamerule.get(SettingsItems.ItemType.OTHERREGENERATION).name());
            config.set("gamerule.pvp", SettingsModes.gamerule.get(SettingsItems.ItemType.PVP).name());
            config.set("gamerule.keepinventory", SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY).name());
            config.set("challenge.wither", SettingsModes.challenge.get(SettingsItems.ItemType.WITHER).name());
            config.set("challenge.enderdragon", SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON).name());
            config.set("positions.list", Position.positionlist.toArray());

            //challenges
            config.set("challenge.flyondamage", SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE).name());
            config.set("challenge.speed.state", SettingsModes.challenge.get(SettingsItems.ItemType.SPEED).name());
                config.set("challenge.speed.speed", SettingsModes.speed);
            config.set("challenge.dirt", SettingsModes.challenge.get(SettingsItems.ItemType.DIRT).name());
            config.set("challenge.tenhearts", SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS).name());
            config.set("challenge.trafficlight.state", SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT).name());
                config.set("challenge.trafficlight.min_green", Trafficlight.min_green);
                config.set("challenge.trafficlight.max_green", Trafficlight.max_green);
                config.set("challenge.trafficlight.min_yellow", Trafficlight.min_yellow);
                config.set("challenge.trafficlight.max_yellow", Trafficlight.max_yellow);
                config.set("challenge.trafficlight.min_red", Trafficlight.min_red);
                config.set("challenge.trafficlight.max_red", Trafficlight.max_red);
            config.set("challenge.oneblockoneheart.state", SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART).name());
                config.set("challenge.oneblockoneheart.blocks", SettingsModes.distanceToGetDamaged);
            config.set("challenge.damagemirror.state", SettingsModes.challenge.get(SettingsItems.ItemType.DAMAGEMIRROR).name());
                config.set("challenge.damagemirror.probability", SettingsModes.probabilityToMirrorDamage);
            config.set("challenge.forceblock.state", SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK).name());
                config.set("challenge.forceblock.freetimemin", ForceBlock.FreeTimeMin);
                config.set("challenge.forceblock.freetimemax", ForceBlock.FreeTimeMax);
                config.set("challenge.forceblock.searchtimemin", ForceBlock.SearchTimeMin);
                config.set("challenge.forceblock.searchtimemax", ForceBlock.SearchTimeMax);
            config.set("challenge.bedrockwall.state", SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL).name());
                config.set("challenge.bedrockwall.delay", SettingsModes.BedrockDelay);
            config.set("challenge.thefloorislava.state", SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA).name());
                config.set("challenge.thefloorislava.magmatime", SettingsModes.MagmaTime);
                config.set("challenge.thefloorislava.lavatime", SettingsModes.LavaTime);
                config.set("challenge.thefloorislava.resettime", SettingsModes.ResetTime);
            config.set("challenge.forcemob.state", SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB).name());
                config.set("challenge.forcemob.freetimemin", ForceMob.FreeTimeMin);
                config.set("challenge.forcemob.freetimemax", ForceMob.FreeTimeMax);
                config.set("challenge.forcemob.searchtimemin", ForceMob.SearchTimeMin);
                config.set("challenge.forcemob.searchtimemax", ForceMob.SearchTimeMax);
            config.set("challenge.no_crafting", SettingsModes.challenge.get(SettingsItems.ItemType.NO_CRAFTING).name());
            config.set("challenge.no_trading", SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING).name());
            config.set("challenge.forceheight.state", SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT).name());
                config.set("challenge.forceheight.freetimemin", ForceHeight.FreeTimeMin);
                config.set("challenge.forceheight.freetimemax", ForceHeight.FreeTimeMax);
                config.set("challenge.forceheight.searchtimemin", ForceHeight.SearchTimeMin);
                config.set("challenge.forceheight.searchtimemax", ForceHeight.SearchTimeMax);
            config.set("challenge.forcebiome.state", SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME).name());
                config.set("challenge.forcebiome.freetimemin", ForceBiome.FreeTimeMin);
                config.set("challenge.forcebiome.freetimemax", ForceBiome.FreeTimeMax);
                config.set("challenge.forcebiome.searchtimemin", ForceBiome.SearchTimeMin);
                config.set("challenge.forcebiome.searchtimemax", ForceBiome.SearchTimeMax);
            config.set("challenge.random_drops.state", SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS).name());
                config.set("challenge.random_drops.allrandom", RandomDrops.allRandom);
            config.set("challenge.disappearing_blocks", SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER).name());

            //projects
            config.set("project.allitems.state", SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS).name());
            if (AllItems.items.size() != 0) {
                config.set("project.allitems.items", AllItems.items.toArray());
            }
            if (AllItems.item != null) {
                config.set("project.allitems.current", AllItems.item.name());
            }
            config.set("project.allmobs.state", SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS).name());
            if (AllMobs.mobnames.size() != 0) {
                config.set("project.allmobs.mobs", AllMobs.mobnames);
            }
            config.set("project.alldeaths.state", SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS).name());
            if (AllDeathMessages.deathMessages.size() != 0) {
                config.set("project.alldeaths.messages", AllDeathMessages.deathMessages);
            }
            if (AllDeathMessages.currentDeathMessage != null) {
                config.set("project.alldeaths.current", AllDeathMessages.currentDeathMessage);
            }
            for (int i = 0; i < BackpackCommand.inventory.getSize(); i ++) {
                config.set("backpack." + i + ".type", BackpackCommand.inventory.getItem(i) == null ? "AIR" : BackpackCommand.inventory.getItem(i).getType().name());
                config.set("backpack." + i + ".amount", BackpackCommand.inventory.getItem(i) == null ? 0 : BackpackCommand.inventory.getItem(i).getAmount());
            }
            if (SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS) == SettingsItems.ItemState.ENABLED) {
                for (int i = 0; i < Material.values().length; i ++) {
                    try {
                        config.set("random_drops.drops." + Material.values()[i].name(), RandomDrops.drops.get(RandomDrops.makeToItemStack(Material.values()[i])).getType().name());
                    } catch (Exception ignored) { }
                }
            }
            config.save(file);
            return true;
        } catch (IOException e) {
            resetConfig();
            return false;
        }
    }

    public static boolean loadConfig() {
        if (Config.file.exists()) {
            try {
                Main.debug = Config.getBoolean("dev.debugmode");
                SettingsModes.timer.put(SettingsItems.ItemType.REVERSE, SettingsItems.ItemState.valueOf(Config.getString("timer.reverse")));
                SettingsModes.startTime = Config.getInt("timer.starttime");
                SettingsModes.currentTime = Config.getInt("timer.currenttime");
                SettingsModes.timer.put(SettingsItems.ItemType.AUTOSTART, SettingsItems.ItemState.valueOf(Config.getString("timer.autostart")));
                Timer.state = Timer.TimerState.valueOf(Config.getString("timer.state"));
                SettingsModes.settings.put(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.valueOf(Config.getString("settings.onelife")));
                SettingsModes.settings.put(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsItems.ItemState.valueOf(Config.getString("settings.geteilteherzen")));
                SettingsModes.settings.put(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.valueOf(Config.getString("settings.respawn")));
                SettingsModes.settings.put(SettingsItems.ItemType.DMGALERT, SettingsItems.ItemState.valueOf(Config.getString("settings.dmgalert")));
                SettingsModes.settings.put(SettingsItems.ItemType.TIMER, SettingsItems.ItemState.valueOf(Config.getString("settings.timer")));
                SettingsModes.settings.put(SettingsItems.ItemType.BACKPACK, SettingsItems.ItemState.valueOf(Config.getString("settings.backpack")));
                SettingsModes.settings.put(SettingsItems.ItemType.SCOREBOARD, SettingsItems.ItemState.valueOf(Config.getString("settings.scoreboard")));
                SettingsModes.settings.put(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsItems.ItemState.valueOf(Config.getString("settings.showcoordsondeath")));
                SettingsModes.maxHP = Config.getDouble("settings.maxhp");
                SettingsModes.settings.put(SettingsItems.ItemType.SENDTITLE, SettingsItems.ItemState.valueOf(Config.getString("settings.sendtitle")));
                SettingsModes.settings.put(SettingsItems.ItemType.RESETCONFIRM, SettingsItems.ItemState.valueOf(Config.getString("settings.resetconfirm")));
                SettingsModes.settings.put(SettingsItems.ItemType.HARDCORE, SettingsItems.ItemState.valueOf(Config.getString("settings.hardcore")));
                SettingsModes.settings.put(SettingsItems.ItemType.BUNGEECORD, SettingsItems.ItemState.valueOf(Config.getString("settings.bungeecord")));
                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, Config.getInt("settings.backup"));
                SettingsModes.settings.put(SettingsItems.ItemType.BACKUP, (Config.getInt("settings.backup") == 0) ? SettingsItems.ItemState.DISABLED : SettingsItems.ItemState.ENABLED);
                Backup.timertime = Config.getInt("settings.backuptimer");
                SettingsModes.settings.put(SettingsItems.ItemType.AFK, SettingsItems.ItemState.valueOf(Config.getString("settings.afk")));
                SettingsModes.settings.put(SettingsItems.ItemType.STATS, SettingsItems.ItemState.valueOf(Config.getString("settings.stats")));
                SettingsModes.settings.put(SettingsItems.ItemType.UPDATE_CHECKER, SettingsItems.ItemState.valueOf(Config.getString("settings.update-checker")));
                SettingsModes.scoreboard.put(SettingsItems.ItemType.TABHP, SettingsItems.ItemState.valueOf(Config.getString("scoreboard.tabhp")));
                SettingsModes.gamerule.put(SettingsItems.ItemType.NATURALREGENERATION, SettingsItems.ItemState.valueOf(Config.getString("gamerule.naturalregeneration")));
                SettingsModes.gamerule.put(SettingsItems.ItemType.OTHERREGENERATION, SettingsItems.ItemState.valueOf(Config.getString("gamerule.otherregeneration")));
                SettingsModes.gamerule.put(SettingsItems.ItemType.PVP, SettingsItems.ItemState.valueOf(Config.getString("gamerule.pvp")));
                SettingsModes.gamerule.put(SettingsItems.ItemType.KEEP_INVENTORY, SettingsItems.ItemState.valueOf(Config.getString("gamerule.keepinventory")));
                SettingsModes.challenge.put(SettingsItems.ItemType.WITHER, SettingsItems.ItemState.valueOf(Config.getString("challenge.wither")));
                SettingsModes.challenge.put(SettingsItems.ItemType.ENDER_DRAGON, SettingsItems.ItemState.valueOf(Config.getString("challenge.enderdragon")));
                if (contains("positions.list")) {
                    Position.positionlist = getArrayList("positions.list");
                }

                //challenges
                SettingsModes.challenge.put(SettingsItems.ItemType.FLYONDAMAGE, SettingsItems.ItemState.valueOf(Config.getString("challenge.flyondamage")));
                SettingsModes.challenge.put(SettingsItems.ItemType.SPEED, SettingsItems.ItemState.valueOf(Config.getString("challenge.speed.state")));
                    SettingsModes.speed = getInt("challenge.speed.speed");
                SettingsModes.challenge.put(SettingsItems.ItemType.DIRT, SettingsItems.ItemState.valueOf(Config.getString("challenge.dirt")));
                SettingsModes.challenge.put(SettingsItems.ItemType.TENHEARTS, SettingsItems.ItemState.valueOf(Config.getString("challenge.tenhearts")));
                SettingsModes.challenge.put(SettingsItems.ItemType.TRAFFICLIGHT, SettingsItems.ItemState.valueOf(Config.getString("challenge.trafficlight.state")));
                    Trafficlight.min_green = Config.getInt("challenge.trafficlight.min_green");
                    Trafficlight.max_green = Config.getInt("challenge.trafficlight.max_green");
                    Trafficlight.min_yellow = Config.getInt("challenge.trafficlight.min_yellow");
                    Trafficlight.max_yellow = Config.getInt("challenge.trafficlight.max_yellow");
                    Trafficlight.min_red = Config.getInt("challenge.trafficlight.min_red");
                    Trafficlight.max_red = Config.getInt("challenge.trafficlight.max_red");
                SettingsModes.challenge.put(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsItems.ItemState.valueOf(Config.getString("challenge.oneblockoneheart.state")));
                    SettingsModes.distanceToGetDamaged = Config.getInt("challenge.oneblockoneheart.blocks");
                SettingsModes.challenge.put(SettingsItems.ItemType.DAMAGEMIRROR, SettingsItems.ItemState.valueOf(Config.getString("challenge.damagemirror.state")));
                    SettingsModes.probabilityToMirrorDamage = Config.getInt("challenge.damagemirror.probability");
                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEBLOCK, SettingsItems.ItemState.valueOf(Config.getString("challenge.forceblock.state")));
                    ForceBlock.FreeTimeMin = Config.getInt("challenge.forceblock.freetimemin");
                    ForceBlock.FreeTimeMax = Config.getInt("challenge.forceblock.freetimemax");
                    ForceBlock.SearchTimeMin = Config.getInt("challenge.forceblock.searchtimemin");
                    ForceBlock.SearchTimeMax = Config.getInt("challenge.forceblock.searchtimemax");
                SettingsModes.challenge.put(SettingsItems.ItemType.BEDROCKWALL, SettingsItems.ItemState.valueOf(Config.getString("challenge.bedrockwall.state")));
                    SettingsModes.BedrockDelay = Config.getInt("challenge.bedrockwall.delay");
                SettingsModes.challenge.put(SettingsItems.ItemType.THEFLOORISLAVA, SettingsItems.ItemState.valueOf(Config.getString("challenge.thefloorislava.state")));
                    SettingsModes.MagmaTime = Config.getInt("challenge.thefloorislava.magmatime");
                    SettingsModes.LavaTime = Config.getInt("challenge.thefloorislava.lavatime");
                    SettingsModes.ResetTime = Config.getInt("challenge.thefloorislava.resettime");
                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEMOB, SettingsItems.ItemState.valueOf(Config.getString("challenge.forcemob.state")));
                    ForceMob.FreeTimeMin = Config.getInt("challenge.forcemob.freetimemin");
                    ForceMob.FreeTimeMax = Config.getInt("challenge.forcemob.freetimemax");
                    ForceMob.SearchTimeMin = Config.getInt("challenge.forcemob.searchtimemin");
                    ForceMob.SearchTimeMax = Config.getInt("challenge.forcemob.searchtimemax");
                SettingsModes.challenge.put(SettingsItems.ItemType.NO_CRAFTING, SettingsItems.ItemState.valueOf(Config.getString("challenge.no_crafting")));
                SettingsModes.challenge.put(SettingsItems.ItemType.NO_TRADING, SettingsItems.ItemState.valueOf(Config.getString("challenge.no_trading")));
                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_HEIGHT, SettingsItems.ItemState.valueOf(Config.getString("challenge.forceheight.state")));
                    ForceHeight.FreeTimeMin = Config.getInt("challenge.forceheight.freetimemin");
                    ForceHeight.FreeTimeMax = Config.getInt("challenge.forceheight.freetimemax");
                    ForceHeight.SearchTimeMin = Config.getInt("challenge.forceheight.searchtimemin");
                    ForceHeight.SearchTimeMax = Config.getInt("challenge.forceheight.searchtimemax");
                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_BIOME, SettingsItems.ItemState.valueOf(Config.getString("challenge.forcebiome.state")));
                    ForceBiome.FreeTimeMin = Config.getInt("challenge.forcebiome.freetimemin");
                    ForceBiome.FreeTimeMax = Config.getInt("challenge.forcebiome.freetimemax");
                    ForceBiome.SearchTimeMin = Config.getInt("challenge.forcebiome.searchtimemin");
                    ForceBiome.SearchTimeMax = Config.getInt("challenge.forcebiome.searchtimemax");
                SettingsModes.challenge.put(SettingsItems.ItemType.RANDOM_DROPS, SettingsItems.ItemState.valueOf(Config.getString("challenge.random_drops.state")));
                    RandomDrops.allRandom = getBoolean("challenge.random_drops.allrandom");
                SettingsModes.challenge.put(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsItems.ItemState.valueOf(Config.getString("challenge.disappearing_blocks")));

                //lists
                SettingsModes.projects.put(SettingsItems.ItemType.ALL_ITEMS, SettingsItems.ItemState.valueOf(Config.getString("project.allitems.state")));
                if (contains("project.allitems.items")) {
                    AllItems.items = getArrayList("project.allitems.items");
                }
                if (contains("project.allitems.current")) {
                    AllItems.item = Material.valueOf(Config.getString("project.allitems.current"));
                }
                SettingsModes.projects.put(SettingsItems.ItemType.ALL_MOBS, SettingsItems.ItemState.valueOf(Config.getString("project.allmobs.state")));
                if (contains("project.allmobs.mobs")) {
                    AllMobs.mobnames = getArrayList("project.allmobs.mobs");
                    for (String name : AllMobs.mobnames) {
                        AllMobs.entities.add(EntityType.valueOf(name));
                    }
                }
                if (contains("random_drops.drops")) {
                    for (int i = 0; i < Material.values().length; i++) {
                        try {
                            RandomDrops.drops.put(RandomDrops.makeToItemStack(Material.values()[i]), RandomDrops.makeToItemStack(Material.valueOf(Config.getString("random_drops.drops." + Material.values()[i].name()))));
                        } catch (Exception ignored) {
                        }
                    }
                }
                SettingsModes.projects.put(SettingsItems.ItemType.ALL_DEATHS, SettingsItems.ItemState.valueOf(Config.getString("project.alldeaths.state")));
                if (contains("project.alldeaths.messages")) {
                    AllDeathMessages.deathMessages = getArrayList("project.alldeaths.messages");
                }
                if (contains("project.alldeaths.current")) {
                    AllDeathMessages.currentDeathMessage = Config.getString("project.alldeaths.current");
                }
            } catch (Exception e) {
                resetConfig();
            }
        } else {
            resetConfig();
        }
        return true;
    }

    public static boolean resetConfig() {
        try {
            setIfAbsent("dev.debugmode", false);
            setIfAbsent("timer.currenttime", 0);
            setIfAbsent("timer.reverse", "DISABLED");
            setIfAbsent("timer.starttime", 0);
            setIfAbsent("timer.autostart", "DISABLED");
            setIfAbsent("timer.state", "PAUSED");
            setIfAbsent("settings.onelife", "DISABLED");
            setIfAbsent("settings.geteilteherzen", "DISABLED");
            setIfAbsent("settings.respawn", "ENABLED");
            setIfAbsent("settings.dmgalert", "ENABLED");
            setIfAbsent("settings.timer", "ENABLED");
            setIfAbsent("settings.backpack", "ENABLED");
            setIfAbsent("settings.scoreboard", "ENABLED");
            setIfAbsent("settings.maxhp", 20);
            setIfAbsent("settings.sendtitle", "ENABLED");
            setIfAbsent("settings.showcoordsondeath", "ENABLED");
            setIfAbsent("settings.resetconfirm", "DISABLED");
            setIfAbsent("settings.hardcore", "DISABLED");
            setIfAbsent("settings.bungeecord", "DISABLED");
            setIfAbsent("settings.backup", 0);
            setIfAbsent("settings.backuptimer", 0);
            setIfAbsent("settings.afk", "ENABLED");
            setIfAbsent("settings.stats", "ENABLED");
            setIfAbsent("settings.update-checker", "ENABLED");
            setIfAbsent("scoreboard.tabhp", "ENABLED");
            setIfAbsent("gamerule.naturalregeneration", "ENABLED");
            setIfAbsent("gamerule.otherregeneration", "ENABLED");
            setIfAbsent("gamerule.pvp", "ENABLED");
            setIfAbsent("gamerule.keepinventory", "DISABLED");
            setIfAbsent("challenge.wither", "DISABLED");
            setIfAbsent("challenge.enderdragon", "ENABLED");
            setIfAbsent("positions.list", null);

            //challenges
            setIfAbsent("challenge.flyondamage", "DISABLED");
            setIfAbsent("challenge.speed.state", "DISABLED");
                setIfAbsent("challenge.speed.speed", 10);
            setIfAbsent("challenge.dirt", "DISABLED");
            setIfAbsent("challenge.tenhearts", "DISABLED");
            setIfAbsent("challenge.trafficlight.state", "DISABLED");
                setIfAbsent("challenge.trafficlight.min_green", 180);
                setIfAbsent("challenge.trafficlight.max_green", 360);
                setIfAbsent("challenge.trafficlight.min_yellow", 4);
                setIfAbsent("challenge.trafficlight.max_yellow", 6);
                setIfAbsent("challenge.trafficlight.min_red", 2);
                setIfAbsent("challenge.trafficlight.max_red", 5);
            setIfAbsent("challenge.oneblockoneheart.state", "DISABLED");
                setIfAbsent("challenge.oneblockoneheart.blocks", 1);
            setIfAbsent("challenge.damagemirror.state", "DISABLED");
                setIfAbsent("challenge.damagemirror.probability", 50);
            setIfAbsent("challenge.forceblock.state", "DISABLED");
                setIfAbsent("challenge.forceblock.freetimemin", 360);
                setIfAbsent("challenge.forceblock.freetimemax", 480);
                setIfAbsent("challenge.forceblock.searchtimemin", 300);
                setIfAbsent("challenge.forceblock.searchtimemax", 480);
            setIfAbsent("challenge.bedrockwall.state", "DISABLED");
                setIfAbsent("challenge.bedrockwall.delay", 10);
            setIfAbsent("challenge.thefloorislava.state", "DISABLED");
                setIfAbsent("challenge.thefloorislava.magamatime", 1);
                setIfAbsent("challenge.thefloorislava.lavatime", 5);
                setIfAbsent("challenge.thefloorislava.resettime", 20);
            setIfAbsent("challenge.forcemob.state", "DISABLED");
                setIfAbsent("challenge.forcemob.freetimemin", 180);
                setIfAbsent("challenge.forcemob.freetimemax", 360);
                setIfAbsent("challenge.forcemob.searchtimemin", 180);
                setIfAbsent("challenge.forcemob.searchtimemax", 360);
            setIfAbsent("challenge.no_crafting", "DISABLED");
            setIfAbsent("challenge.no_trading", "DISABLED");
            setIfAbsent("challenge.forceheight.state", "DISABLED");
                setIfAbsent("challenge.forceheight.freetimemin", 180);
                setIfAbsent("challenge.forceheight.freetimemax", 360);
                setIfAbsent("challenge.forceheight.searchtimemin", 180);
                setIfAbsent("challenge.forceheight.searchtimemax", 360);
            setIfAbsent("challenge.forcebiome.state", "DISABLED");
                setIfAbsent("challenge.forcebiome.freetimemin", 180);
                setIfAbsent("challenge.forcebiome.freetimemax", 360);
                setIfAbsent("challenge.forcebiome.searchtimemin", 180);
                setIfAbsent("challenge.forcebiome.searchtimemax", 360);
            setIfAbsent("challenge.random_drops.state", "DISABLED");
                setIfAbsent("challenge.random_drops.allrandom", false);
            setIfAbsent("challenge.disappearing_blocks", "DISABLED");

            //lists
            setIfAbsent("project.allitems.state", "DISABLED");
            setIfAbsent("project.allitems.items", null);
            setIfAbsent("project.allitems.current", null);

            setIfAbsent("project.allmobs.state", "DISABLED");
            setIfAbsent("project.allmobs.mobs", null);

            setIfAbsent("project.alldeaths.state", "DISABLED");
            setIfAbsent("project.alldeaths.messages", null);
            setIfAbsent("project.alldeaths.current", null);

            setIfAbsent("random_drops.drops", null);

            //backpack
            setIfAbsent("backpack", null);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadConfig();
        return true;
    }

    public static void resetProject(SettingsItems.ItemType type) {
        try {
            switch (type) {
                case ALL_ITEMS:
                    Config.set("project.allitems.items", null);
                    Config.set("project.allitems.current", null);
                    AllItems.items.clear();
                    for (Material mat : Material.values()) {
                        AllItems.items.add(mat.toString());
                    }
                    AllItems.items.removeIf(str -> str.contains("WALL_") || str.contains("SPAWN_EGG") || str.equalsIgnoreCase("AIR") || str.equalsIgnoreCase("BEDROCK") || str.contains("PORTAL"));
                    break;
                case ALL_MOBS:
                    Config.set("project.allmobs.mobs", null);
                    AllMobs.entities.clear();
                    AllMobs.mobnames.clear();
                    for (EntityType entType : EntityType.values()) {
                        if (entType.isAlive() && entType != EntityType.ARMOR_STAND && entType != EntityType.PLAYER && entType != EntityType.GIANT) {
                            AllMobs.entities.add(entType);
                            AllMobs.mobnames.add(entType.name());
                        }
                    }
                    break;
                case ALL_DEATHS:
                    AllDeathMessages.deathMessages.clear();
                    AllDeathMessages.deathMessages.add("<Player> was shot by [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> was pricked to death");
                    AllDeathMessages.deathMessages.add("<Player> drowned");
                    AllDeathMessages.deathMessages.add("<Player> experienced kinetic energy");
                    AllDeathMessages.deathMessages.add("<Player> blew up");
                    AllDeathMessages.deathMessages.add("<Player> was blown up by [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> was killed by [Intentional Game Design]");
                    AllDeathMessages.deathMessages.add("<Player> hit the ground too hard");
                    AllDeathMessages.deathMessages.add("<Player> fell from a high place");
                    AllDeathMessages.deathMessages.add("<Player> fell off a ladder");
                    AllDeathMessages.deathMessages.add("<Player> fell off some vines");
                    AllDeathMessages.deathMessages.add("<Player> fell off some weeping vines");
                    AllDeathMessages.deathMessages.add("<Player> fell off some twisting vines");
                    AllDeathMessages.deathMessages.add("<Player> fell off scaffolding");
                    AllDeathMessages.deathMessages.add("<Player> fell while climbing");
                    AllDeathMessages.deathMessages.add("<Player> was squashed by anvil");
                    AllDeathMessages.deathMessages.add("<Player> went up in flames");
                    AllDeathMessages.deathMessages.add("<Player> burned to death");
                    AllDeathMessages.deathMessages.add("<Player> went off with a bang");
                    AllDeathMessages.deathMessages.add("<Player> tried to swim in lava");
                    AllDeathMessages.deathMessages.add("<Player> was struck down by lightning");
                    AllDeathMessages.deathMessages.add("<Player> discovered the floor was lava");
                    AllDeathMessages.deathMessages.add("<Player> was killed by magic");
                    AllDeathMessages.deathMessages.add("<Player> was slain by [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> was fireballed by [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> was stung to death");
                    AllDeathMessages.deathMessages.add("<Player> suffocated in a wall");
                    AllDeathMessages.deathMessages.add("<Player> was poked to death by a sweet berry bush");
                    AllDeathMessages.deathMessages.add("<Player> was killed trying to hurt [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> was impaled by [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> fell out of the world");
                    AllDeathMessages.deathMessages.add("<Player> withered away");
                    AllDeathMessages.deathMessages.add("<Player> was roasted in dragon breath");
                    AllDeathMessages.deathMessages.add("<Player> was shot by a skull from [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> walked into fire whilst fighting [Mob]");
                    AllDeathMessages.deathMessages.add("<Player> walked into a cactus whilst trying to escape [Mob]");
                    Random random = new Random();
                    AllDeathMessages.currentDeathMessage = AllDeathMessages.deathMessages.get(random.nextInt(AllDeathMessages.deathMessages.size()));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setToNull(String path) {
        try {
            Config.set(path, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setIfAbsent(String path, Object value) throws IOException {
        if (!Config.contains(path)) {
            Config.set(path, value);
        }
    }
}
