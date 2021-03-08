package me.aaron.timer.projects;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Heads;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AllMobs {
    public static ArrayList<String> mobnames = new ArrayList<>();
    public static ArrayList<EntityType> entities = new ArrayList<>();

    public static void start() {
        if (entities.size() == 0) {
            for (EntityType entityType : EntityType.values()) {
                if (entityType.isAlive() && entityType != EntityType.ARMOR_STAND && entityType != EntityType.PLAYER && entityType != EntityType.GIANT) {
                    entities.add(entityType);
                    mobnames.add(entityType.name());
                }
            }
        } else {
            for (String mobs : mobnames) {
                entities.add(EntityType.valueOf(mobs));
            }
        }
    }

    public static void killed(EntityType entityType) {
        if (entities.contains(entityType)) {
            entities.remove(entityType);
            mobnames.clear();
            for (EntityType entityType2 : entities) {
                mobnames.add(entityType2.name());
            }
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.sendTitle("§6" + Utils.firstLatterCapitalized(entityType.getKey().getKey().replace("_", " ")) + "§7 killed!", "", 5, 30, 5);
            }
        }
        if (entities.size() == 0) {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.sendTitle("§aAll Mobs §7killed", "", 10, 60, 10);
                if (Bukkit.getOnlinePlayers().size() < 1) {
                    pl.sendMessage(Main.getPrefix("Alle Mobs", "You killed §6all Mobs §7!"));
                } else {
                    pl.sendMessage(Main.getPrefix("Alle Mobs", "You killed §6all Mobs §7!"));
                }
                pl.playSound(pl.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 30, 1);
            }
            for (EntityType entType : EntityType.values()) {
                if (entType.isAlive() && entType != EntityType.ARMOR_STAND && entType != EntityType.PLAYER && entType != EntityType.GIANT && entType != EntityType.ZOMBIE_HORSE && entType != EntityType.ILLUSIONER) {
                    entities.add(entType);
                    mobnames.add(entType.name());
                }
            }
        }
    }

    public static ItemStack isFound(EntityType entityType) {
        if (entities.contains(entityType)) {
            ItemStack itemStack = Utils.getHead(Heads.getValue(Heads.Head.valueOf(entityType.name())));
            ItemMeta itemMeta = itemStack.getItemMeta();
            ArrayList<String> itemLore = new ArrayList<>();
            itemMeta.setDisplayName("§6" + Utils.firstLatterCapitalized(entityType.name().replace("_", " ")));
            itemLore.add(" ");
            itemLore.add("§7These Mob is not killed.");
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
        } else {
            ItemStack itemStack = new ItemStack(Material.LIME_STAINED_GLASS);
            ItemMeta itemMeta = itemStack.getItemMeta();
            ArrayList<String> itemLore = new ArrayList<>();
            itemMeta.setDisplayName("§a" + Utils.firstLatterCapitalized(entityType.name().replace("_", " ")));
            itemLore.add(" ");
            itemLore.add("§7This Mob was killed.");
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
    }

}
