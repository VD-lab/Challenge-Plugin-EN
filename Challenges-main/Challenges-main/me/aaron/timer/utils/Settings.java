package me.aaron.timer.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Settings {
    public static Inventory getMenu() {
        Inventory Settings = Bukkit.createInventory(null, 27, "Settings");
        Utils.fillWithGlass(Settings);

        Settings.setItem(10, ChallengesSettings());
        Settings.setItem(12, Health());
        Settings.setItem(14, Projects());
        Settings.setItem(16, Other());

        return Settings;
    }

    public static Inventory getHealthMenu() {
        Inventory HealthSettings = Bukkit.createInventory(null, 27, "Lebenseinstellungen");
        Utils.fillWithGlass(HealthSettings);

        HealthSettings.setItem(1, GeteilteHerzen());
        HealthSettings.setItem(2, AllowRespawn());
        HealthSettings.setItem(3, EinLebenFurAlle());
        HealthSettings.setItem(5, MaxHealth());
        HealthSettings.setItem(6, NaturalRegeneration());
        HealthSettings.setItem(7, OtherRegeneration());
        HealthSettings.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsModes.settings.get(SettingsItems.ItemType.GEITEILTEHERZEN)));
        HealthSettings.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.RESPAWN, SettingsModes.settings.get(SettingsItems.ItemType.RESPAWN)));
        HealthSettings.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.ONELIFE, SettingsModes.settings.get(SettingsItems.ItemType.ONELIFE)));
        HealthSettings.setItem(14, MaxHealthButton());
        HealthSettings.setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.NATURALREGENERATION, SettingsModes.gamerule.get(SettingsItems.ItemType.NATURALREGENERATION)));
        HealthSettings.setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.OTHERREGENERATION, SettingsModes.gamerule.get(SettingsItems.ItemType.OTHERREGENERATION)));
        HealthSettings.setItem(18, Back());

        return HealthSettings;
    }

    public static Inventory getChallengesMenu() {
        Inventory inv = Bukkit.createInventory(null, 36, "Challenges §7» §8Seite 1");
        Utils.fillWithGlass(inv);

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.FLYONDAMAGE, SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SPEED, SettingsModes.challenge.get(SettingsItems.ItemType.SPEED)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.DIRT, SettingsModes.challenge.get(SettingsItems.ItemType.DIRT)));
        inv.setItem(13, SettingsItems.getMenuItem(SettingsItems.ItemType.TENHEARTS, SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS)));
        inv.setItem(14, SettingsItems.getMenuItem(SettingsItems.ItemType.TRAFFICLIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT)));
        inv.setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART)));
        inv.setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.DAMAGEMIRROR, SettingsModes.challenge.get(SettingsItems.ItemType.DAMAGEMIRROR)));
        inv.setItem(19, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEBLOCK, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK)));
        inv.setItem(20, SettingsItems.getMenuItem(SettingsItems.ItemType.BEDROCKWALL, SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL)));
        inv.setItem(21, SettingsItems.getMenuItem(SettingsItems.ItemType.THEFLOORISLAVA, SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA)));
        inv.setItem(22, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEMOB, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB)));
        inv.setItem(23, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_CRAFTING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_CRAFTING)));
        inv.setItem(24, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_TRADING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING)));
        inv.setItem(25, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_HEIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT)));

        inv.setItem(27, Back());
        inv.setItem(35, Next());

        return inv;
    }

    public static Inventory getChallengesMenu2() {
        Inventory inv = Bukkit.createInventory(null, 36, "Challenges §7» §8Seite 2");
        Utils.fillWithGlass(inv);

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_BIOME, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.RANDOM_DROPS, SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER)));

        inv.setItem(27, Back());

        return inv;
    }

    public static Inventory getOtherMenu() {
        Inventory inv = Bukkit.createInventory(null, 27, "Restliche Einstellungen §7» §8Seite 1");
        Utils.fillWithGlass(inv);

        inv.setItem(1, TimerSettings());
        inv.setItem(2, SendTitle());
        inv.setItem(3, SendDamageMessage());
        inv.setItem(4, KeepInventorySettings());
        inv.setItem(5, ShowCoordsOnDeath());
        inv.setItem(6, PVP());
        inv.setItem(7, NeedResetConfirm());

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SENDTITLE, SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.DMGALERT, SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT)));
        inv.setItem(13, SettingsItems.getMenuItem(SettingsItems.ItemType.KEEP_INVENTORY, SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY)));
        inv.setItem(14, SettingsItems.getMenuItem(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsModes.settings.get(SettingsItems.ItemType.SHOWCOORDSONDEAETH)));
        inv.setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.PVP, SettingsModes.gamerule.get(SettingsItems.ItemType.PVP)));
        inv.setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.RESETCONFIRM, SettingsModes.settings.get(SettingsItems.ItemType.RESETCONFIRM)));

        inv.setItem(26, Next());
        inv.setItem(18, Back());

        return inv;
    }

    public static Inventory resetPrompt(String title) {
        Inventory inv = Bukkit.createInventory(null, 27, "§c" + title + " §rzurücksetzen?");
        Utils.fillWithGlass(inv);

        inv.setItem(11, Confirm());
        inv.setItem(15, Cancel());

        return inv;
    }

    public static Inventory getOtherMenu2() {
        Inventory inv = Bukkit.createInventory(null, 27, "Restliche Einstellungen §7» §8Seite 2");
        Utils.fillWithGlass(inv);

        inv.setItem(1, Enderdragon());
        inv.setItem(2, Wither());
        inv.setItem(3, TABHP());
        inv.setItem(4, Hardcore());
        inv.setItem(5, BUNGEECORD());
        inv.setItem(6, Backup());
        inv.setItem(7, AFK());

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.ENDER_DRAGON, SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.WITHER, SettingsModes.challenge.get(SettingsItems.ItemType.WITHER)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.TABHP, SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP)));
        inv.setItem(13, SettingsItems.getMenuItem(SettingsItems.ItemType.HARDCORE, SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE)));
        inv.setItem(14, SettingsItems.getMenuItem(SettingsItems.ItemType.BUNGEECORD, SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD)));
        inv.setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
        inv.setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.AFK, SettingsModes.settings.get(SettingsItems.ItemType.AFK)));

        inv.setItem(26, Next());
        inv.setItem(18, Back());

        return inv;
    }

    public static Inventory getOtherMenu3() {
        Inventory inv = Bukkit.createInventory(null, 27, "Restliche Einstellungen §7» §8Seite 3");
        Utils.fillWithGlass(inv);

        inv.setItem(1, Backpack());
        inv.setItem(2, Stats());
        inv.setItem(3, Update_Checker());

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKPACK, SettingsModes.settings.get(SettingsItems.ItemType.BACKPACK)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.STATS, SettingsModes.settings.get(SettingsItems.ItemType.STATS)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.UPDATE_CHECKER, SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER)));

        inv.setItem(18, Back());

        return inv;
    }

    public static Inventory TimerMenu() {
        Inventory inv = Bukkit.createInventory(null, 54, "Timer Einstellungen");
        Utils.fillWithGlass(inv);

        inv.setItem(11, ButtonPlus("hours"));
        inv.setItem(20, Clock("hours"));
        inv.setItem(29, ButtonMinus("hours"));
        inv.setItem(13, ButtonPlus("min"));
        inv.setItem(22, Clock("min"));
        inv.setItem(31, ButtonMinus("min"));
        inv.setItem(15, ButtonPlus("sec"));
        inv.setItem(24, Clock("sec"));
        inv.setItem(33, ButtonMinus("sec"));
        inv.setItem(47, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
        inv.setItem(49, SettingsItems.getMenuItem(SettingsItems.ItemType.REVERSE, SettingsModes.timer.get(SettingsItems.ItemType.REVERSE)));
        inv.setItem(51, SettingsItems.getMenuItem(SettingsItems.ItemType.AUTOSTART, SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART)));

        inv.setItem(45, Back());

        return inv;
    }

    public static Inventory ProjectMenu() {
        Inventory inv = Bukkit.createInventory(null, 36, "Projekte");
        Utils.fillWithGlass(inv);

        inv.setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_ITEMS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS)));
        inv.setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_MOBS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS)));
        inv.setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_DEATHS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS)));

        inv.setItem(27, Back());

        return inv;
    }

    public static ItemStack TABHP() {
        ItemStack itemStack = new ItemStack(Material.POPPY);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6TAB-HP");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Zeigt die Leben der Spieler");
        itemLore.add("§7an, wenn man TAB drückt");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Accept() {
        ItemStack itemStack = Utils.getHead(Heads.getValue(Heads.Head.GREEN_CHECKMARK));
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§9Bestätigen");
        itemLore.add(" ");
        itemLore.add("§aÄnderungen speichern");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Confirm() {
        ItemStack itemStack = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§aBestätigen");
        itemLore.add(" ");
        itemLore.add("§cIch verstehe, dass ich den Reset");
        itemLore.add("§cnicht mehr rückgängig machen kann.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7Zurücksetzen");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Cancel() {
        ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§cAbbrechen");
        itemLore.add(" ");
        itemLore.add("§7Nicht zurücksetzen.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7Abbrechen");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Stats() {
        ItemStack itemStack = new ItemStack(Material.DAYLIGHT_DETECTOR);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Stats in der Tablist");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7In der Tablist steht die");
        itemLore.add("§7RAM-Auslastung und die TPS.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack AFK() {
        ItemStack itemStack = new ItemStack(Material.DEAD_TUBE_CORAL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6AFK");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Wenn ein Spieler AFK ist,");
        itemLore.add("§7steht AFK neben seinem Namen.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Update_Checker() {
        ItemStack itemStack = new ItemStack(Material.GHAST_TEAR);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Update Checker");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Das Plugin prüft automatisch, ob");
        itemLore.add("§7die neuste Version installiert ist.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Backpack() {
        ItemStack itemStack = new ItemStack(Material.ENDER_CHEST);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Backpack");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Erlaubt den Spielern ein Backpack");
        itemLore.add("§7mit §9/backpack §7zu öffnen.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Clock(String type) {
        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        switch (type) {
            case "sec":
                itemMeta.setDisplayName("§6Sekunden");
                break;
            case "min":
                itemMeta.setDisplayName("§6Minuten");
                break;
            case "hours":
                itemMeta.setDisplayName("§6Stunden");
                break;
        }
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Ändert die Zeit des Timers.");
        itemLore.add(" ");
        itemLore.add("§7Momentan: " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6§l"));
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack ButtonPlus(String type) {
        ItemStack itemStack = new ItemStack(Material.OAK_BUTTON);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        switch (type) {
            case "sec":
                itemMeta.setDisplayName("§6Sekunden");
                break;
            case "min":
                itemMeta.setDisplayName("§6Minuten");
                break;
            case "hours":
                itemMeta.setDisplayName("§6Stunden");
                break;
        }
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Ändert die Zeit des Timers.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7+ 1");
        itemLore.add("§8[§9Shift-Klick§8] §7+ 10");
        itemLore.add(" ");
        itemLore.add("§7Momentan: " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6§l"));
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack ButtonMinus(String type) {
        ItemStack itemStack = new ItemStack(Material.OAK_BUTTON);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        switch (type) {
            case "sec":
                itemMeta.setDisplayName("§6Sekunden");
                break;
            case "min":
                itemMeta.setDisplayName("§6Minuten");
                break;
            case "hours":
                itemMeta.setDisplayName("§6Stunden");
                break;
        }
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Ändert die Zeit des Timers.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7- 1");
        itemLore.add("§8[§9Shift-Klick§8] §7- 10");
        itemLore.add(" ");
        itemLore.add("§7Momentan: " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6§l"));
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }


    public static ItemStack Backup() {
        ItemStack itemStack = new ItemStack(Material.ELYTRA);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Backup");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7In den angegebenen Intervallen wird ein");
        itemLore.add("§7Backup von allen Welt-Ordnern gemacht.");
        itemLore.add(" ");
        itemLore.add("§8[§9Links-Klick§8] §7+ 1");
        itemLore.add("§8[§9Rechts-Klick§8] §7- 1");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack BUNGEECORD() {
        ItemStack itemStack = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6BungeeCord");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Wenn diese Funktion aktiviert");
        itemLore.add("§7ist, werden die Spieler zum Beispiel");
        itemLore.add("§7Bei einem Reset nicht gekickt sondern");
        itemLore.add("§7zum Server §a\"Hub\" §7weitergeleitet.");
        itemLore.add(" ");
        itemLore.add("§7Funktioniert wenn ein BungeeCord-Netzwerk");
        itemLore.add("§7mit einem Server §a\"Hub\" §7 existiert");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Hardcore() {
        ItemStack itemStack = new ItemStack(Material.CRIMSON_FUNGUS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Hardcore");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Setzt die Schwierigkeit auf");
        itemLore.add("§7Hardcore.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack SendTitle() {
        ItemStack itemStack = new ItemStack(Material.NAME_TAG);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Titel");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Sendet einen Titel an alle Spieler");
        itemLore.add("§7wenn sich die Einstellungen ändern.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Enderdragon() {
        ItemStack itemStack = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Enderdrache");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die Challenge ist absolviert, wenn");
        itemLore.add("§7der Enderdrache besiegt wird.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Wither() {
        ItemStack itemStack = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Wither");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die Challenge ist absolviert, wenn");
        itemLore.add("§7der Wither besiegt wird.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Next() {
        ItemStack itemStack = Utils.getHead(Heads.getValue(Heads.Head.WOOD_ARROW_RIGHT));
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Weiter");
        itemLore.add(" ");
        itemLore.add("§7Bringt dich auf die nächste Seite.");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Exit() {
        ItemStack itemStack = Utils.getHead(Heads.getValue(Heads.Head.WOOD_EXIT));
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Schließen");
        itemLore.add(" ");
        itemLore.add("§7Schließt das Menü.");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack SendDamageMessage() {
        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Schaden im Chat");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Zeigt den Schaden den");
        itemLore.add("§7Spieler bekommen im Chat an.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack KeepInventorySettings() {
        ItemStack itemStack = new ItemStack(Material.CHEST);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Keep Inventory");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Erlaubt den Spielern, nach dem");
        itemLore.add("§7Tod, ihr Inventar zu behalten.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack ShowCoordsOnDeath() {
        ItemStack itemStack = new ItemStack(Material.BEACON);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Koordinaten bei Tod");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Zeigt die Koordinaten vom Todesort");
        itemLore.add("§7eines Spielers hinter der Todesnachricht an.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack PVP() {
        ItemStack itemStack = new ItemStack(Material.IRON_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6PVP");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Erlaubt, dass sich Spieler");
        itemLore.add("§7gegenseitig Schaden machen können.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack NeedResetConfirm() {
        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();

        itemMeta.setDisplayName("§6Reset Confirm");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Benötigt ein nach §9/reset §7ein");
        itemLore.add("§9/reset confirm §7damit die Welten");
        itemLore.add("§7zurückgesetzt werden.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7An / Aus");
        itemLore.add(" ");

        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static String getOtherMenuName() {
        return "Restliche Einstellungen §7» §8Seite 1";
    }

    public static void openInv(Player p) {
        p.openInventory(getMenu());
    }

    public static String getMenuName() {
        return "Settings";
    }

    public static ItemStack TimerSettings() {
        ItemStack itemStack = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Timer");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Zeigt am unteren Bildschirmrand");
        itemLore.add("§7einen §9Timer §7an.");
        itemLore.add(" ");
        itemLore.add("§8[§9Klick§8] §7öffnet Einstellungen");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack ChallengesSettings() {
        ItemStack Challenges = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta ChallengesMeta = Challenges.getItemMeta();
        ArrayList<String> ChallengesLore = new ArrayList<>();
        ChallengesMeta.setDisplayName("§9Challenges");
        ChallengesLore.add(" ");
        ChallengesLore.add("§7Öffnet die §9Einstellungen §7für die §9Challenges§7.");
        ChallengesLore.add(" ");

        ChallengesMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChallengesMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        ChallengesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ChallengesMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        ChallengesMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        ChallengesMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ChallengesMeta.setLore(ChallengesLore);
        Challenges.setItemMeta(ChallengesMeta);

        return Challenges;
    }

    public static ItemStack MaxHealth() {
        ItemStack itemStack = new ItemStack(Material.RED_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Maximale Leben");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die maximalen Leben, die die Spieler");
        itemLore.add("§7haben können.");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack MaxHealthButton() {
        ItemStack itemStack = new ItemStack(Material.STONE_BUTTON);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Maximale Leben");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die maximalen Leben, die die Spieler");
        itemLore.add("§7haben können.");
        itemLore.add(" ");
        itemLore.add("§8[§9Links-Klick§8] §7+ 1 HP");
        itemLore.add("§8[§9Rechts-Klcik§8] §7- 1 HP");
        itemLore.add(" ");
        itemLore.add("§7Momentan: §6" + SettingsModes.maxHP + "HP/ " + SettingsModes.maxHP / 2D + "❤");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Health() {
        ItemStack Health = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta HealthMeta = Health.getItemMeta();
        ArrayList<String> HealthLore = new ArrayList<>();
        HealthMeta.setDisplayName("§9Lebensanzeige");
        HealthLore.add(" ");
        HealthLore.add("§7Öffnet die §9Lebenseinstellungen§7.");
        HealthLore.add(" ");

        HealthMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        HealthMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        HealthMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        HealthMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        HealthMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        HealthMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        HealthMeta.setLore(HealthLore);
        Health.setItemMeta(HealthMeta);

        return Health;
    }

    public static ItemStack Projects() {
        ItemStack itemStack = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§9Projekte");
        itemLore.add(" ");
        itemLore.add("§7Öffnet die Einstellungen für Projekte,");
        itemLore.add("§7wie zum Beispiel §9Alle Achievements,");
        itemLore.add("§9Alle Items, Alle Tode §7und weitere ...");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack Other() {
        ItemStack Other = new ItemStack(Material.STRING);
        ItemMeta OtherMeta = Other.getItemMeta();
        ArrayList<String> OtherLore = new ArrayList<>();
        OtherMeta.setDisplayName("§9Andere Einstellungen");
        OtherLore.add(" ");
        OtherLore.add("§7Öffnet §9restliche Einstellungen§7.");
        OtherLore.add(" ");

        OtherMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        OtherMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        OtherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        OtherMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        OtherMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        OtherMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        OtherMeta.setLore(OtherLore);
        Other.setItemMeta(OtherMeta);

        return Other;
    }

    public static ItemStack GeteilteHerzen() {

        ItemStack itemStack = new ItemStack(Material.GLISTERING_MELON_SLICE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Geteilte Herzen");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die Spieler teilen sich ihre");
        itemLore.add("§7Herzen.");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack NaturalRegeneration() {

        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Natürliche Regeneration");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Spieler können auf natürliche");
        itemLore.add("§7Art regenerieren");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack OtherRegeneration() {

        ItemStack itemStack = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Restliche Regeneration");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Erlaubt den Spielern unnatürlich");
        itemLore.add("§7zu regenerieren.");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }


    public static ItemStack Back() {

        ItemStack Back = Utils.getHead(Heads.getValue(Heads.Head.WOOD_ARROW_LEFT));
        ItemMeta BackMeta = Back.getItemMeta();
        ArrayList<String> BackLore = new ArrayList<>();
        BackMeta.setDisplayName("§6Zurück");
        BackLore.add(" ");
        BackLore.add("§7Bringt dich auf die vorherige Seite.");
        BackLore.add(" ");

        BackMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        BackMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        BackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        BackMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        BackMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        BackMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        BackMeta.setLore(BackLore);
        Back.setItemMeta(BackMeta);

        return Back;
    }

    public static ItemStack AllowRespawn() {
        ItemStack itemStack = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Respawn");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Die Spieler können nach einem");
        itemLore.add("§7Tod respawnen.");
        itemLore.add(" ");
        itemLore.add("§8§oÜberschreibt Ein Leben für Alle");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack EinLebenFurAlle() {
        ItemStack itemStack = new ItemStack(Material.POPPY);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        itemMeta.setDisplayName("§6Ein Leben für alle");
        itemLore.add(" ");
        itemLore.add("§9Beschreibung:");
        itemLore.add("§7Stirbt ein Spieler, ist die");
        itemLore.add("§7Challenge vorbei.");
        itemLore.add(" ");
        itemLore.add("§8§oÜberschreibt Respawn");
        itemLore.add(" ");

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItemStack(Material type, String name, String lore) {
        ItemStack itemStack = new ItemStack(type);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(stringToLoreList(lore));
        itemStack.setItemMeta(itemMeta);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        return itemStack;
    }

    public static ArrayList<String> stringToLoreList(String string) {
        ArrayList<String> lore = new ArrayList<>();
        string += "\n";
        string = string.replaceAll("(.{1,35})\\s", "$1\n");
        String[] lines = string.split("\n");
        for (String line : lines) {
            lore.add("§7" + line);
        }
        return lore;
    }
}
