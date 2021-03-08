package me.aaron.timer;
//import me.aaron.timer.commands.BetterTimerCommand;
import me.aaron.timer.challenges.*;
import me.aaron.timer.projects.AllDeathMessages;
import me.aaron.timer.projects.AllItems;
import me.aaron.timer.projects.AllMobs;
import me.aaron.timer.tabCompletes.*;
import me.aaron.timer.commands.*;
import me.aaron.timer.commands.DorfCommand;
import me.aaron.timer.listeners.*;
import me.aaron.timer.utils.Position;
import me.aaron.timer.commands.ReloadCommand;
import me.aaron.timer.utils.*;
import me.aaron.timer.commands.ResetCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.aaron.timer.commands.HubCommand;
import me.aaron.timer.commands.WorldCommand;
import me.aaron.timer.commands.GmCommand;
import me.aaron.timer.commands.BackpackCommand;
import me.aaron.timer.commands.PositionCommand;
import me.aaron.timer.commands.InvseeCommand;
import me.aaron.timer.commands.HealCommand;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import static me.aaron.timer.utils.Permissions.ranks;


public final class Main extends JavaPlugin {
    //todo:
    //multiworld-plugin
    //hub
    //test-command

    public static boolean debug = false;

    public static final String version = "2.6";

    public Trafficlight trafficlight;

    public static boolean started = false;
    public static Main plugin;
    public static boolean deletedFolders = false;

    @Override
    public void onLoad() {
        Position pos = new Position();
        if(Config.contains("reset.isReset") && Config.getBoolean("reset.isReset")) {
            deleteFolder("world");
            deleteFolder("world_nether");
            deleteFolder("world_the_end");
            pos.reset();
            Timer.reset();
        }
        deletedFolders = true;
        if(Config.contains("reset.isReset") && Config.getBoolean("reset.isReset")) {
            try {
                Config.set("reset.isReset", false);
                Config.set("project.allmobs.mobs", null);
                Config.set("project.allitems.items", null);
                Config.set("project.allitems.current", null);
                Config.set("positions.list", null);
                Config.set("random_drops.drops", null);
                Config.set("positions.list", null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
        }
    }

    @Override
    public void onEnable() {
        Timer.firststart = true;
        Config config = new Config();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Config.resetConfig();
        Bukkit.getLogger().info("§aDas Plugin §8[§6Challenges§8]§a wurde erfolgreich gestartet.");
        for (World wl : Bukkit.getWorlds()) {
            wl.setGameRule(GameRule.KEEP_INVENTORY, SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY) == SettingsItems.ItemState.ENABLED);
            wl.setPVP(SettingsModes.gamerule.get(SettingsItems.ItemType.PVP) == SettingsItems.ItemState.ENABLED);
        }
        plugin = this;
        started = true;
        Timer.setCurrentTime(Config.getInt("timer.currenttime"));
        Timer.run();

        listenerRegistration();
        commandRegistration();
        TabCompleterRegistration();

        if (SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT) == SettingsItems.ItemState.ENABLED) {
            trafficlight = new Trafficlight(this);
            trafficlight.start();
        }

        if (SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE) == SettingsItems.ItemState.ENABLED) {
            for (World wl : Bukkit.getWorlds()) {
                wl.setHardcore(true);
            }
        } else {
            for (World wl : Bukkit.getWorlds()) {
                wl.setHardcore(false);
            }
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK) == SettingsItems.ItemState.ENABLED) {
            ForceBlock forceBlock = new ForceBlock(getInstance());
            forceBlock.start();
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB)  == SettingsItems.ItemState.ENABLED) {
            ForceMob forceMob = new ForceMob(getInstance());
            forceMob.start();
        }

        for (Player pl : Bukkit.getOnlinePlayers()) {
            Permissions.setRank(pl, Permissions.Rank.valueOf(Config.getString("permissions." + pl.getUniqueId())));
        }

        if (SettingsModes.settings.get(SettingsItems.ItemType.BACKUP) == SettingsItems.ItemState.ENABLED) {
            Backup backup = new Backup();
            backup.start();
        }
        if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS) == SettingsItems.ItemState.ENABLED) {
            AllItems.start();
        }
        if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS) == SettingsItems.ItemState.ENABLED) {
            AllMobs.start();
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT) == SettingsItems.ItemState.ENABLED) {
            ForceHeight forceHeight = new ForceHeight();
            forceHeight.start();
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME) == SettingsItems.ItemState.ENABLED) {
            ForceBiome forceBiome = new ForceBiome();
            forceBiome.start();
        }
        BackpackCommand.getBackpack();

        for (Player pl : Bukkit.getOnlinePlayers()) {
            MoveListener.lastMovement.put(pl, System.currentTimeMillis() * 1000);
            AFK.afk.clear();
            Utils.setNewRankPrefix(pl, Permissions.getRank(pl));
        }
        AFK.start();
        Permissions.start();

        TextComponent component = new TextComponent(" Download");
        component.setColor(ChatColor.BLUE);
        component.setBold(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.spigotmc.org/resources/bastighg-challenge-plugin.86023/"));
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Du wirst zur Update-Seite weitergeleitet").color(ChatColor.WHITE).italic(true).create()));


        if (SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER) == SettingsItems.ItemState.ENABLED) {
            new UpdateChecker(this, 86023).Check(vers -> Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
                if (!vers.equalsIgnoreCase(version) && SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER) == SettingsItems.ItemState.ENABLED) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage(Main.getPrefix("Challenge-Plugin", "Es ist ein neues Update des Challenge-Plugins verfügbar §8(§9" + version + " §8» §9" + vers + "§8)§7. Bitte lade es hier herunter:"));
                        pl.spigot().sendMessage(component);
                    }
                    Bukkit.getLogger().info(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Challenge-Plugin" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Es ist ein neues Update des Challenge-Plugins verfügbar bitte lade es dir hier herunter: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/bastighg-challenge-plugin.86023/");
                } else if (SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER) == SettingsItems.ItemState.DISABLED && !vers.equalsIgnoreCase(version)){
                    Bukkit.getLogger().info(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Challenge-Plugin" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " Es ist ein neues Update des Challenge-Plugins verfügbar bitte lade es dir hier herunter: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/bastighg-challenge-plugin.86023/");
                }
            }, 0, Utils.TimeToTicks(0, 30, 0)));
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS) == SettingsItems.ItemState.ENABLED) {
            RandomDrops.start();
        }

        for (Player pl : Bukkit.getOnlinePlayers()) {
            ScoreboardManager.createScoreboard(pl);
        }

        if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS) == SettingsItems.ItemState.ENABLED) {
            AllDeathMessages.start();
        }
    }

    @Override
    public void onDisable() {
        Config.saveConfig();
        for (Player pl : Bukkit.getOnlinePlayers()) {
            try {
                Config.set("permissions." + pl.getUniqueId(), ranks.get(pl).name());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void listenerRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new TeleportListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new TriggerListener(), this);
        pm.registerEvents(new EntityDeathListener(), this);
        pm.registerEvents(new KickListener(), this);
        pm.registerEvents(new DamageRemover(), this);
        pm.registerEvents(new HealListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new FoodListener(), this);
        pm.registerEvents(new AdvancementsListener(), this);
        pm.registerEvents(new DamageByEntityListener(), this);
        pm.registerEvents(new ForceMob(getInstance()), this);
        pm.registerEvents(new GamemodeChangeListener(), this);
        pm.registerEvents(new PreLoginListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new InteractEntityListener(), this);
        pm.registerEvents(new BucketListener(), this);
    }

    private void commandRegistration() {
        this.getCommand("timer").setExecutor(new TimerCommand());
        this.getCommand("hub").setExecutor(new HubCommand());
        this.getCommand("world").setExecutor(new WorldCommand());
        this.getCommand("gm").setExecutor(new GmCommand());
        this.getCommand("gamemode").setExecutor(new GmCommand());
        this.getCommand("backpack").setExecutor(new BackpackCommand());
        this.getCommand("bp").setExecutor(new BackpackCommand());
        this.getCommand("position").setExecutor(new PositionCommand());
        this.getCommand("pos").setExecutor(new PositionCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("nv").setExecutor(new NvCommand());
        this.getCommand("invsee").setExecutor(new InvseeCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("reset").setExecutor(new ResetCommand());
        this.getCommand("refresh").setExecutor(new ReloadCommand());
        this.getCommand("rl").setExecutor(new ReloadCommand());
        this.getCommand("sun").setExecutor(new SunCommand());
        this.getCommand("rain").setExecutor(new RainCommand());
        this.getCommand("thunder").setExecutor(new ThunderCommand());
        this.getCommand("settings").setExecutor(new SettingsCommand());
        this.getCommand("challenges").setExecutor(new SettingsCommand());
        this.getCommand("trash").setExecutor(new TrashCommand());
        this.getCommand("seed").setExecutor(new SeedCommand());
        this.getCommand("l").setExecutor(new HubCommand());
        this.getCommand("dorf").setExecutor(new DorfCommand());
        this.getCommand("save").setExecutor(new SaveCommand());
        this.getCommand("rank").setExecutor(new RankCommand());
        this.getCommand("ban").setExecutor(new BanCommand());
        this.getCommand("pardon").setExecutor(new UnbanCommand());
        this.getCommand("unban").setExecutor(new UnbanCommand());
        this.getCommand("tempban").setExecutor(new TempBanCommand());
        this.getCommand("timeout").setExecutor(new TempBanCommand());
        this.getCommand("stilletreppe").setExecutor(new TempBanCommand());
        this.getCommand("backup").setExecutor(new BackupCommand());
        this.getCommand("skipitem").setExecutor(new SkipitemCommand());
        this.getCommand("mobs").setExecutor(new MobsCommand());
        this.getCommand("moboverview").setExecutor(new MobsCommand());
    }

    private void TabCompleterRegistration() {
        this.getCommand("timer").setTabCompleter(new TimerTabComplete());
        this.getCommand("hub").setTabCompleter(new HubTabCompleter());
        this.getCommand("world").setTabCompleter(new WorldTabCompleter());
        this.getCommand("gm").setTabCompleter(new GmTabCompleter());
        this.getCommand("gamemode").setTabCompleter(new GmTabCompleter());
        this.getCommand("position").setTabCompleter(new PositionTabCompleter());
        this.getCommand("pos").setTabCompleter(new PositionTabCompleter());
        this.getCommand("rank").setTabCompleter(new RankTabCompleter());
        this.getCommand("mobs").setTabCompleter(new MobsTabCompleter());
    }

    public void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    private void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    private void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    private void deleteFolder(String folder) {
        if(Files.exists(Paths.get(folder))) {
            try {
                Files.walk(Paths.get(folder)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Main getInstance() {
        return plugin;
    }

    public static String getPrefix(String name, String Content) {
        return "§8[§6" + name + "§8] §7" + Content;
    }

    public ArrayList<String> getPermissions(Player p) {
        ArrayList<String> permissions = new ArrayList<>();
        if (getConfig().contains(p.getUniqueId().toString() + ".permissions")) {
            permissions = (ArrayList<String>) getConfig().getStringList(p.getUniqueId().toString() + ".permissions");
        }

        return permissions;
    }

}
