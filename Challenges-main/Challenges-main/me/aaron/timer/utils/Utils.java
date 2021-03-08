package me.aaron.timer.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.aaron.timer.Main;
import net.dv8tion.jda.api.JDA;
import net.minecraft.server.v1_16_R3.Enchantment;
import net.minecraft.server.v1_16_R3.MinecraftServer;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Utils {
    public static Inventory fillWithGlass(Inventory inv) {
        ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, itemStack);
        }
        return inv;
    }

    public static void sendChange(String Title, String Subtitle) {
        if (SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE) == SettingsItems.ItemState.ENABLED) {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.sendTitle(Title, Subtitle, 5, 40, 5);
            }
        }
    }

    public static void sendTitle(String title, String subtitle) {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendTitle(title, subtitle, 5, 40, 5);
        }
    }

    public static void SendToServer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void sendWrongArgs(Player p) {
        p.sendMessage("§8[§cError§8] §cFrom you typed Arguments are wrong.");
    }

    public static double getBossBarProgress(int max, int current, boolean reverse) {
        int left = max - current;
        double bossbarfactor = 1.0 / max;
        if (reverse) {
            return left * bossbarfactor;
        } else {
            return current * bossbarfactor;
        }
    }

    public static ItemStack getHead(String textureURL) {
        ItemStack skullItem = new ItemStack(Material.PLAYER_HEAD);

        if (textureURL.isEmpty()) {
            return skullItem;
        }

        SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", textureURL));
        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        skullItem.setItemMeta(skullMeta);
        return skullItem;
    }

    public static String firstLatterCapitalized(String string) {
        StringBuilder msg = new StringBuilder();
        boolean nextUpperCase = true;
        for (int i = 0; i < string.length(); i ++) {
            String current = string.substring(i, i + 1);
            if (nextUpperCase) {
                msg.append(current.toUpperCase());
                nextUpperCase = false;
            } else {
                msg.append(current.toLowerCase());
            }
            if (current.equals(" ")) {
                nextUpperCase = true;
            }
        }
        return msg.toString();
    }

    public static int TimeToTicks(int hours, int minutes, int seconds) {
        int time = hours * 3600;
        time += minutes * 60;
        time += seconds;

        return time * 20;
    }

    public static Date convertLocalDateToDate(LocalDateTime date) {
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date calculateUnban(long timeInSeconds) {
        LocalDateTime dateTime = LocalDateTime.now().plusSeconds(timeInSeconds);
        return convertLocalDateToDate(dateTime);
    }

    public static void setNewRankPrefix(Player p, Permissions.Rank rank) {
        p.setDisplayName(Permissions.getPrefix(rank) + "§f" + p.getName());
        p.setCustomName(Permissions.getPrefix(rank) + "§f" + p.getName());
        p.setCustomNameVisible(true);
        p.setPlayerListName(Permissions.getPrefix(rank) + "§f" + p.getName());
    }

    public static Material randomItem() {
        Material item = null;
        Random random = new Random();
        while (item == null) {
            item = Material.values()[random.nextInt(Material.values().length)];
            if (item == Material.STRUCTURE_BLOCK || item == Material.BARRIER || item == Material.COMMAND_BLOCK_MINECART || item == Material.CHAIN_COMMAND_BLOCK || item == Material.REPEATING_COMMAND_BLOCK || item == Material.END_GATEWAY || item == Material.BEDROCK || item == Material.MOVING_PISTON || item == Material.KELP_PLANT || item == Material.AIR || item.getKey().getKey().contains("spawn") || item.getKey().getKey().contains("potted") || item.getKey().getKey().contains("wall")) {
                item = null;
            }
        }
        return item;
    }

    public static long getPercent(double max, double current) {
        double multiplier = 100 / max;
        return Math.round(current * multiplier);
    }

    public static int getTPS() {
        return MinecraftServer.TPS;
    }
}
