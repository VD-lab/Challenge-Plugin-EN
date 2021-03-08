package me.aaron.timer.utils;

import me.aaron.timer.Main;
import me.aaron.timer.challenges.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Set;

public class SettingsItems {
    public static ItemStack getMenuItem(ItemType type, ItemState state) {
        ItemStack itemStack = new ItemStack(Material.STONE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> itemLore = new ArrayList<>();
        if (type == ItemType.DMGALERT) {
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemMeta.setDisplayName("§6Schaden im Chat");
                itemLore.add(" ");
                itemLore.add("§9Beschreibung:");
                itemLore.add("§7Zeigt den Schaden den");
                itemLore.add("§7Spieler bekommen im Chat an.");
                itemLore.add(" ");
                itemLore.add("§8[§9Klick§8] §7An / Aus");
                itemLore.add(" ");
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemMeta.setDisplayName("§6Schaden im Chat");
                itemLore.add(" ");
                itemLore.add("§9Beschreibung:");
                itemLore.add("§7Zeigt den Schaden den");
                itemLore.add("§7Spieler bekommen im Chat an.");
                itemLore.add(" ");
                itemLore.add("§8[§9Klick§8] §7An / Aus");
                itemLore.add(" ");
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.GEITEILTEHERZEN) {
            itemMeta.setDisplayName("§6Geteilte Herzen");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler teilen sich ihre");
            itemLore.add("§7Herzen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.RESPAWN) {
            itemMeta.setDisplayName("§6Respawn");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler können nach einem");
            itemLore.add("§7Tod respawnen.");
            itemLore.add(" ");
            itemLore.add("§8§oÜberschreibt Ein Leben für Alle");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.ONELIFE) {
            itemMeta.setDisplayName("§6Ein Leben für alle");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Stirbt ein Spieler, ist die");
            itemLore.add("§7Challenge vorbei.");
            itemLore.add(" ");
            itemLore.add("§8§oÜberschreibt Respawn");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.FLYONDAMAGE) {
            itemStack.setType(Material.FEATHER);
            itemMeta.setDisplayName("§6Bei Schaden in die Luft fliegen");
            if (state == ItemState.DISABLED) {
                itemLore.add(" ");
                itemLore.add("§9Beschreibung:");
                itemLore.add("§7Wenn ein Spieler Schaden bekommt,");
                itemLore.add("§7wird er in die Luft geschleudert.");
                itemLore.add(" ");
                itemLore.add("§8[§9Klick§8] §7An / Aus");
                itemLore.add(" ");
                itemLore.add("§8[§4Inaktiv§8]");
                itemLore.add(" ");
            } else {
                itemLore.add(" ");
                itemLore.add("§9Beschreibung:");
                itemLore.add("§7Wenn ein Spieler Schaden bekommt,");
                itemLore.add("§7wird er in die Luft geschleudert.");
                itemLore.add(" ");
                itemLore.add("§8[§9Klick§8] §7An / Aus");
                itemLore.add(" ");
                itemLore.add("§8[§2Aktiv§8]");
                itemLore.add(" ");
            }
        } else if (type == ItemType.NATURALREGENERATION) {
            itemMeta.setDisplayName("§6Natürliche Regeneration");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Spieler können auf natürliche");
            itemLore.add("§7Art regenerieren");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.TIMER) {
            itemMeta.setDisplayName("§6Timer");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Zeigt am unteren Bildschirmrand");
            itemLore.add("§7einen §9Timer §7an.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.REVERSE) {
            itemMeta.setDisplayName("§6Rückwärts");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Lässt den Timer vorwärts");
            itemLore.add("§7oder rückwärts laufen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7Vorwärts / Rückwärts");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.ARROW);
                itemLore.add("§8[§2Vorwärts§8]");
            } else {
                itemStack.setType(Material.SPECTRAL_ARROW);
                itemLore.add("§8[§4Rückwärts§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.SENDTITLE) {
            itemMeta.setDisplayName("§6Titel");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Sendet einen Titel an alle Spieler");
            itemLore.add("§7wenn sich die Einstellungen ändern.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.AUTOSTART) {
            itemMeta.setDisplayName("§6Automatischer Timer");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Startet den Timer bei einem Player-Join");
            itemLore.add("§7automatisch und stoppt den Timer wenn kein");
            itemLore.add("§7Spieler mehr auf dem Server ist automatisch");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.CRIMSON_STEM);
                itemLore.add("§8[§4Aus§8]");
            } else {
                itemStack.setType(Material.WARPED_STEM);
                itemLore.add("§8[§2An§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.SPEED) {
            itemStack.setType(Material.DIAMOND_BOOTS);
            itemMeta.setDisplayName("§6Speed");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Gibt allen Entitäten Speed.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.OTHERREGENERATION) {
            itemMeta.setDisplayName("§6Restliche Regeneration");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Erlaubt den Spielern unnatürlich");
            itemLore.add("§7zu regenerieren.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.KEEP_INVENTORY) {
            itemMeta.setDisplayName("§6Keep Inventory");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Erlaubt den Spielern, nach dem");
            itemLore.add("§7Tod, ihr Inventar zu behalten.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.SHOWCOORDSONDEAETH) {
            itemMeta.setDisplayName("§6Koordinaten bei Tod");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Zeigt die Koordinaten vom Todesort");
            itemLore.add("§7eines Spielers hinter der Todesnachricht an.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.PVP) {
            itemMeta.setDisplayName("§6PVP");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Erlaubt, dass sich Spieler");
            itemLore.add("§7gegenseitig Schaden machen können.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.RESETCONFIRM) {
            itemMeta.setDisplayName("§6Reset Confirm");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Benötigt ein nach §9/reset §7ein");
            itemLore.add("§9/reset confirm §7damit die Welten");
            itemLore.add("§7zurückgesetzt werden.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.ENDER_DRAGON) {
            itemMeta.setDisplayName("§6Enderdrache");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Challenge ist absolviert, wenn");
            itemLore.add("§7der Enderdrache besiegt wird.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.WITHER) {
            itemMeta.setDisplayName("§6Wither");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Challenge ist absolviert, wenn");
            itemLore.add("§7der Wither besiegt wird.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Deaktiviert§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiviert§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.DIRT) {
            itemStack.setType(Material.DIRT);
            itemMeta.setDisplayName("§6Nur auf Dirt");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Jeder Spieler darf nur auf");
            itemLore.add("§7Dirt stehen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.TENHEARTS) {
            itemStack.setType(Material.REDSTONE);
            itemMeta.setDisplayName("§6Niemals volle Herzen");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Sobald ein Spieler volle");
            itemLore.add("§7Herzen hat, stirbt er.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.TRAFFICLIGHT) {
            ItemStack trafficLight = Utils.getHead(Heads.getValue(Heads.Head.TRAFFIC_LIGHT));
            ItemMeta trafficMeta = trafficLight.getItemMeta();
            ArrayList<String> trafficLore = new ArrayList<>();
            trafficMeta.setDisplayName("§6Ampel Challenge");
            trafficLore.add(" ");
            trafficLore.add("§9Beschreibung:");
            trafficLore.add("§7Am oberen Bildschrimrand");
            trafficLore.add("§7ist eine Ampel, die vorgibt, ob");
            trafficLore.add("§7sich die Spieler bewegen dürfen.");
            trafficLore.add(" ");
            trafficLore.add("§8[§9Links-Klick§8] §7An / Aus");
            trafficLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            trafficLore.add(" ");
            if (state == ItemState.DISABLED) {
                trafficLore.add("§8[§4Inaktiv§8]");
            } else {
                trafficLore.add("§8[§2Aktiv§8]");
            }
            trafficLore.add(" ");

            trafficMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            trafficMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            trafficMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            trafficMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            trafficMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            trafficMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            trafficMeta.setLore(trafficLore);
            trafficLight.setItemMeta(trafficMeta);

            return trafficLight;
        } else if (type == ItemType.ONEBLOCKONEHEART) {
            itemStack.setType(Material.GRASS_BLOCK);
            itemMeta.setDisplayName("§6Laufen = Schaden");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Wenn sich ein Spieler die angegebene");
            itemLore.add("§7Blockzahl bewegt, bekommt er 1 Herz Schaden.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.DAMAGEMIRROR) {
            itemStack.setType(Material.BOW);
            itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
            itemMeta.setDisplayName("§6Gespiegelter Schaden");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Mit einer §a50 % §7Wahrscheinlichkeit");
            itemLore.add("§7wird der Schaden, den ein Spieler");
            itemLore.add("§7einem Mob zufügt, gespiegelt.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.TABHP) {
            itemMeta.setDisplayName("§6TAB-HP");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Zeigt die Leben der Spieler");
            itemLore.add("§7an, wenn man TAB drückt");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
                itemLore.add(" ");
                itemLore.add("§7Falls, die Herzen nicht");
                itemLore.add("§7angezeigt werden, musst Du");
                itemLore.add("§7einmal Schaden nehmen oder");
                itemLore.add("§7reloggen.");
            }
            itemLore.add(" ");
        } else if (type == ItemType.HARDCORE) {
            itemMeta.setDisplayName("§6Hardcore");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Setzt die Schwierigkeit auf");
            itemLore.add("§7Hardcore.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.FORCEBLOCK) {
            itemStack.setType(Material.DIAMOND_ORE);
            itemMeta.setDisplayName("§6Force-Block");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Gibt den Spielern vor");
            itemLore.add("§7auf welchem Block sie als");
            itemLore.add("§7nächstes stehen müssen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.BUNGEECORD) {
            itemMeta.setDisplayName("§6BungeeCord");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Wenn diese Funktion aktiviert");
            itemLore.add("§7ist, werden die Spieler zum Beispiel");
            itemLore.add("§7Bei einem Reset nicht gekickt sondern");
            itemLore.add("§7zum Server §a\"Hub\" §7weitergeleitet.");
            itemLore.add(" ");
            itemLore.add("§7Funktioniert wenn ein BungeeCord-Netzwerk");
            itemLore.add("§7mit einem Server §a\"Hub\" §7existiert");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.BEDROCKWALL) {
            itemStack.setType(Material.BEDROCK);
            itemMeta.setDisplayName("§6Bedrock-Wand");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Eine §a10 Sekunden §7verzögerte");
            itemLore.add("§7Bedrock-Wand verfolgt alle Spieler.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.THEFLOORISLAVA) {
            itemStack.setType(Material.LAVA_BUCKET);
            itemMeta.setDisplayName("§6Der Boden ist Lava");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Blöcke auf denen die Spieler stehen");
            itemLore.add("§7werden erst mit Magmablöcken und dann");
            itemLore.add("§7mit Lava ersetzt.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.FORCEMOB) {
            itemStack.setType(Material.ZOMBIE_HEAD);
            itemMeta.setDisplayName("§6Force-Mob");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler müssen in einer bestimmten");
            itemLore.add("§7Zeit ein Mob vorgegebenes Mob töten.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.BACKUP) {
            itemMeta.setDisplayName("§6Backup");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7In den angegebenen Intervallen wird ein");
            itemLore.add("§7Backup von allen Welt-Ordnern gemacht.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7+ 1");
            itemLore.add("§8[§9Rechts-Klick§8] §7- 1");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
                itemLore.add(" ");
                itemLore.add("§7Alle §6§l" + SettingsModes.ints.get(ItemType.BACKUP) + " Stunden");
                itemStack.setAmount((SettingsModes.ints.get(ItemType.BACKUP) == 0) ? 1 : SettingsModes.ints.get(ItemType.BACKUP));
            }
            itemLore.add(" ");
        } else if (type == ItemType.ALL_ITEMS){
            itemStack.setType(Material.BEACON);
            itemMeta.setDisplayName("§6Alle Items");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Ihr müsst alle Items in Minecraft");
            itemLore.add("§7in einer vorgegebenen Reihenfolge sammeln.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Zurücksetzen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.BACKPACK) {
            itemMeta.setDisplayName("§6Backpack");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Erlaubt den Spielern ein Backpack");
            itemLore.add("§7mit §9/backpack §7zu öffnen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.NO_CRAFTING) {
            itemStack.setType(Material.CRAFTING_TABLE);
            itemMeta.setDisplayName("§6Kein Crafting");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Es ist den Spielern nicht erlaubt,");
            itemLore.add("§7einen §9Crafting Table §7zu nutzen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.NO_TRADING) {
            itemStack.setType(Material.EMERALD);
            itemMeta.setDisplayName("§6Kein Traden");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Es ist den Spielern nicht erlaubt,");
            itemLore.add("§7mit §9Villagern §7zu traden.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.ALL_MOBS) {
            itemStack.setType(Material.ZOMBIE_HEAD);
            itemMeta.setDisplayName("§6Alle Mobs");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler müssen alle Mobs töten,");
            itemLore.add("§7die es in Minecraft gibt.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Zurücksetzen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.AFK) {
            itemMeta.setDisplayName("§6AFK");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Wenn ein Spieler AFK ist,");
            itemLore.add("§7steht AFK neben seinem Namen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.FORCE_HEIGHT) {
            itemStack.setType(Material.TWISTING_VINES);
            itemMeta.setDisplayName("§6Force Height");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler müssen zu einer vorgegebenen");
            itemLore.add("§7Zeit auf einer vorgegebenen Höhe sein.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.FORCE_BIOME) {
            itemStack.setType(Material.MYCELIUM);
            itemMeta.setDisplayName("§6Force Biome");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Die Spieler müssen zu einer vorgegebenen");
            itemLore.add("§7Zeit in einem vorgegebenen Biom stehen.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Eistellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.STATS) {
            itemMeta.setDisplayName("§6Stats in der Tablist");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7In der Tablist steht die");
            itemLore.add("§7RAM-Auslastung und die TPS.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.UPDATE_CHECKER) {
            itemMeta.setDisplayName("§6Update Checker");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Das Plugin prüft automatisch, ob");
            itemLore.add("§7die neuste Version installiert ist.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemStack.setType(Material.RED_DYE);
                itemLore.add("§8[§4Inaktiv§8] (§7Nicht Empfohlen§8)");
            } else {
                itemStack.setType(Material.LIME_DYE);
                itemLore.add("§8[§2Aktiv§8] (§7Empfohlen§8)");
            }
            itemLore.add(" ");
        } else if (type == ItemType.RANDOM_DROPS) {
            itemStack.setType(Material.CORNFLOWER);
            itemMeta.setDisplayName("§6Random Drops");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Alle Drops sind zufälling.");
            itemLore.add(" ");
            itemLore.add("§8[§9Links-Klick§8] §7An / Aus");
            itemLore.add("§8[§9Rechts-Klick§8] §7Einstellungen");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        } else if (type == ItemType.ALL_DEATHS) {
            ItemStack skullStack = Utils.getHead(Heads.getValue(Heads.Head.SKULL));
            ItemMeta skullMeta = skullStack.getItemMeta();
            ArrayList<String> skullLore = new ArrayList<>();
            skullMeta.setDisplayName("§6Alle Todesnachrichten");
            skullLore.add(" ");
            skullLore.add("§9Beschreibung:");
            skullLore.add("§7Am oberen Bildschrimrand wird");
            skullLore.add("§7vorgegeben, welche Todesnachricht");
            skullLore.add("§7der Spieler als nächstes bekommen muss.");
            skullLore.add(" ");
            skullLore.add("§8[§9Links-Klick§8] §7An / Aus");
            skullLore.add("§8[§9Rechts-Klick§8] §7Zurücksetzen");
            skullLore.add(" ");
            if (state == ItemState.DISABLED) {
                skullLore.add("§8[§4Inaktiv§8]");
            } else {
                skullLore.add("§8[§2Aktiv§8]");
            }
            skullLore.add(" ");

            skullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            skullMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            skullMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            skullMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            skullMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            skullMeta.setLore(skullLore);
            skullStack.setItemMeta(skullMeta);

            return skullStack;
        } else if (type == ItemType.BLOCKS_WITH_PLAYER) {
            itemStack.setType(Material.SCAFFOLDING);
            itemMeta.setDisplayName("§6Alle Blöcke, auf denen ein Spieler steht, verschwinden");
            itemLore.add(" ");
            itemLore.add("§9Beschreibung:");
            itemLore.add("§7Alle Blöcke, des Typs auf dem ein");
            itemLore.add("§7Spieler steht, verschwinden in dem");
            itemLore.add("§7Chunk in dem er steht. Der Block");
            itemLore.add("§7auf dem er steht wird mit Glas ersetzt.");
            itemLore.add(" ");
            itemLore.add("§8[§9Klick§8] §7An / Aus");
            itemLore.add(" ");
            if (state == ItemState.DISABLED) {
                itemLore.add("§8[§4Inaktiv§8]");
            } else {
                itemLore.add("§8[§2Aktiv§8]");
            }
            itemLore.add(" ");
        }

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

    public static Inventory getMenuInv(ItemType type) {
        if (type == ItemType.SPEED) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cSpeed");
            Utils.fillWithGlass(inv);
            inv.setItem(13, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Speed", "\n§9Beschreibung:\nDie Geschwindigkeit, die alle Spieler und Mobs haben werden.\n \n§8[§9Links-Klick§8] §7+ 1\n§8[§9Rechts-Klick§8] §7- 1\n \nMomentan: §6" + SettingsModes.speed));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.TRAFFICLIGHT) {
            Inventory inv = Bukkit.createInventory(null, 36, "§8Settings: §cAmpel-Challenge");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimale Grünzeit", "\n§9Beschreibung:\nDie minimale Zeit, die die Ampel grün bleibt.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + Trafficlight.min_green / 60 + " Minuten"));
            inv.setItem(20, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximale Grünzeit", "\n§9Beschreibung:\nDie maximale Zeit, die die Ampel grün bleibt.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + Trafficlight.max_green / 60 + " Minuten"));
            inv.setItem(13, Settings.createItemStack(Material.YELLOW_CONCRETE, "§6Minimale Gelbzeit", "\n§9Beschreibung:\nDie minimale Zeit, die die Ampel gelb bleibt.\n\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + Trafficlight.min_yellow + " Sekunden"));
            inv.setItem(22, Settings.createItemStack(Material.YELLOW_CONCRETE, "§6Maximale Gelbzeit", "\n§9Beschreibung:\nDie maximale Zeit, die die Ampel gelb bleibt.\n\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + Trafficlight.max_yellow + " Sekunden"));
            inv.setItem(15, Settings.createItemStack(Material.RED_CONCRETE, "§6Minimale Rotzeit", "\n§9Beschreibung:\nDie minimale Zeit, die die Ampel rot belibt.\n\n§8[§9Links-Klick§8] §7 + 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + Trafficlight.min_red + " Sekunden"));
            inv.setItem(24, Settings.createItemStack(Material.RED_CONCRETE, "§6Maximale Rotzeit", "\n§9Beschreibung:\nDie maximale Zeit, die die Ampel rot bleibt.\n\n§8[§9Links-Klick§8] §7 + 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + Trafficlight.max_red + " Sekunden"));
            inv.setItem(27, Settings.Accept());
            return inv;
        } else if (type == ItemType.ONEBLOCKONEHEART) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cLaufen = Schaden");
            Utils.fillWithGlass(inv);
            inv.setItem(13, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Blöcke", "\n§9Beschreibung:\nDie Blöcke, die ein Spieler gehen muss, um Schaden zu bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + SettingsModes.distanceToGetDamaged + " §7Blöcke"));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.RANDOM_DROPS) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cZufällige Drops");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Alle Drops Random", "\n§9Beschreibung:\nJeder Block gibt einen unterschiedlichen Drop.\n\n§8[§9Klick§8] §7An / Aus\n\nMomentan: §6" + (!RandomDrops.allRandom ? "§8[§4Inaktiv§8]" : "§8[§2Aktiv§8]")));
            inv.setItem(15, Settings.createItemStack(Material.RED_CONCRETE, "§6Zurücksetzen", "\n§9Beschreibung:\nAlle Drops werden neu gemischt."));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.DAMAGEMIRROR) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cGespiegelter Schaden");
            Utils.fillWithGlass(inv);
            inv.setItem(13, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Wahrscheinlichkeit", "\n§9Beschreibung:\nDie Wahrscheinlichkeit, dass der Schaden gespiegelt wird.\n\n§8[§9Links-Klick§8] §7+ 10%\n§8[§9Rechts-Klick§8] §7- 10%\n\nMomentan: §6" + SettingsModes.probabilityToMirrorDamage + "%"));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.FORCEBLOCK) {
            Inventory inv = Bukkit.createInventory(null, 36, "§8Settings: §cForce Block");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimaler Anweisungsintervall", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBlock.FreeTimeMin / 60 + " Minuten"));
            inv.setItem(20, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximaler Anweisungsintervall", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBlock.FreeTimeMax / 60 + " Minuten"));
            inv.setItem(15, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimale Suchzeit", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBlock.SearchTimeMin / 60 + " Minuten"));
            inv.setItem(24, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximale Suchzeit", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBlock.SearchTimeMax / 60 + " Minuten"));
            inv.setItem(27, Settings.Accept());
            return inv;
        } else if (type == ItemType.BEDROCKWALL) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cBedrock-Wand");
            Utils.fillWithGlass(inv);
            inv.setItem(13, Settings.createItemStack(Material.BEDROCK, "§6Verzögerung", "\n§9Beschreibung:\nDie Verzögerung, die die Bedrock zu den Spielern hat.\n\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n\nMomentan: §6" + SettingsModes.BedrockDelay + " Sekunden"));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.THEFLOORISLAVA) {
            Inventory inv = Bukkit.createInventory(null, 27, "§8Settings: §cDer Boden ist Lava");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.MAGMA_BLOCK, "§6Magma", "\n§9Beschreibung:\nDie Zeit, bis der Boden zu Magma wird.\n\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + SettingsModes.MagmaTime + " Sekunden"));
            inv.setItem(13, Settings.createItemStack(Material.LAVA_BUCKET, "§6Lava", "\n§9Beschreibung:\nDie Zeit, bis der Boden zu Lava wird.\n\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n§8[§9Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + SettingsModes.LavaTime + " Sekunden"));
            inv.setItem(15, Settings.createItemStack(Material.GRASS_BLOCK, "§6Reset", "\n§9Beschreibung:\nDie Zeit, bis der Boden wieder zum orginalen Block zurückgesetzt wird.\n§8[§9Links-Klick§8] §7+ 1 Sekunde\n§8[Rechts-Klick§8] §7- 1 Sekunde\n\nMomentan: §6" + SettingsModes.ResetTime + " Sekunden"));
            inv.setItem(18, Settings.Accept());
            return inv;
        } else if (type == ItemType.FORCEMOB) {
            Inventory inv = Bukkit.createInventory(null, 36, "§8Settings: §cForce Mob");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimaler Anweisungsintervall", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceMob.FreeTimeMin / 60 + " Minuten"));
            inv.setItem(20, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximaler Anweisungsintervall", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceMob.FreeTimeMax / 60 + " Minuten"));
            inv.setItem(15, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimale Suchzeit", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceMob.SearchTimeMin / 60 + " Minuten"));
            inv.setItem(24, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximale Suchzeit", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceMob.SearchTimeMax / 60 + " Minuten"));
            inv.setItem(27, Settings.Accept());
            return inv;
        } else if (type == ItemType.FORCE_HEIGHT) {
            Inventory inv = Bukkit.createInventory(null, 36, "§8Settings: §cForce Height");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimaler Anweisungsintervall", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceHeight.FreeTimeMin / 60 + " Minuten"));
            inv.setItem(20, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximaler Anweisungsintervall", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceHeight.FreeTimeMax / 60 + " Minuten"));
            inv.setItem(15, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimale Suchzeit", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceHeight.SearchTimeMin / 60 + " Minuten"));
            inv.setItem(24, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximale Suchzeit", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceHeight.SearchTimeMax / 60 + " Minuten"));
            inv.setItem(27, Settings.Accept());
            return inv;
        } else if (type == ItemType.FORCE_BIOME) {
            Inventory inv = Bukkit.createInventory(null, 36, "§8Settings: §cForce Biome");
            Utils.fillWithGlass(inv);
            inv.setItem(11, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimaler Anweisungsintervall", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBiome.FreeTimeMin / 60 + " Minuten"));
            inv.setItem(20, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximaler Anweisungsintervall", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler keine Anweisung bekommen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBiome.FreeTimeMax / 60 + " Minuten"));
            inv.setItem(15, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimale Suchzeit", "\n§9Beschreibung:\nDie minimale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBiome.SearchTimeMin / 60 + " Minuten"));
            inv.setItem(24, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximale Suchzeit", "\n§9Beschreibung:\nDie maximale Zeit, in der die Spieler die Anweisung ausführen müssen.\n\n§8[§9Links-Klick§8] §7+ 1 Minute\n§8[§9Rechts-Klick§8] §7- 1 Minute\n\nMomentan: §6" + ForceBiome.SearchTimeMax / 60 + " Minuten"));
            inv.setItem(27, Settings.Accept());
            return inv;
        }
        else {
            return null;
        }
    }


    public enum ItemType {
        // settings
        DMGALERT,
        TIMER,
        BACKPACK,
        SCOREBOARD,
        GEITEILTEHERZEN,
        RESPAWN,
        ONELIFE,
        SENDTITLE,
        SHOWCOORDSONDEAETH,
        RESETCONFIRM,
        HARDCORE,
        CANCELLDAMAGE,
        BUNGEECORD,
        BACKUP,
        AFK,
        STATS,
        UPDATE_CHECKER,

        // timer
        RESUME,
        REVERSE,
        AUTOSTART,

        // scoreboard
        TABHP,

        // gamerules
        NATURALREGENERATION,
        OTHERREGENERATION,
        PVP,
        KEEP_INVENTORY,

        // challenges
        WITHER,
        ENDER_DRAGON,
        FLYONDAMAGE,
        SPEED,
        DIRT,
        TENHEARTS,
        TRAFFICLIGHT,
        ONEBLOCKONEHEART,
        DAMAGEMIRROR,
        FORCEBLOCK,
        BEDROCKWALL,
        THEFLOORISLAVA,
        FORCEMOB,
        FORCE_ITEM,
        FORCE_BIOME,
        FORCE_HEIGHT,
        FORCE_COORDINATES,
        ANVIL_CRUSHER,
        BIOM_TIMER,
        RANDOM_DROPS,
        RANDOM_MOB_SPAWNS,
        RANDOM_CRAFTIG,
        RANDOM_WORLD,
        WORLD_IS_STONE,
        NO_EQUAL_HP,
        ONLY_TWO_MOB_KILLS,
        ITEM_DECAY,
        WATER_MLG,
        RANDOM_MLG,
        ITEM_DROP,
        OTHER_DROP_RATES,
        FIFTY_PERCENT_CHUNK_DESTRUCTION,
        EVERY_X_SECONDS_CHUNK_DESTRUCTION,
        JUMP_AND_RUN,
        WORLD_IS_ONE_BIOM,
        WALK_LIMIT,
        NO_CRAFTING,
        NO_TRADING,
        WORLD_IS_ONE_BLOCK,
        DIET,
        ACHIEVEMENT_CAUSES_DAMAGE,
        ONE_DURABILITY,
        TNT_RUN,
        EQUAL_HEIGHT,
        DAMAGE_CLEARS_INVENTORY,
        SHARE_INVENTORY,
        BLOCKED_SLOTS,
        NO_TOOLS,
        SYNC_PLAYERS,
        EXPLODE_NEAR_ENTITIES,
        BLOCKS_WITH_PLAYER,

        //projects
        ALL_DEATHS,
        ALL_ACHIEVEMENTS,
        ALL_ITEMS,
        RARE_THINGS,
        ALL_MOBS,
    }

    public enum ItemState {
        DISABLED,
        ENABLED
    }
}
