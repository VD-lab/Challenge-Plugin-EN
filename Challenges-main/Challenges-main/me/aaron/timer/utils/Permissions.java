package me.aaron.timer.utils;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Permissions {
    public static void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), () -> {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                if (Permissions.getRank(pl) == Rank.OP || Permissions.getRank(pl) == Rank.ADMIN) {
                    if (!pl.isOp()) {
                        Permissions.setRank(pl, Rank.USER);
                    }
                } else {
                    if (pl.isOp()) {
                        Permissions.setRank(pl, Rank.OP);
                    }
                }
            }
        }, 0, 5);
    }

    public static HashMap<Player, Rank>  ranks = new HashMap<>();

    public static void setRank(Player p, Rank rank) {
        ranks.put(p, (rank == null) ? Rank.GUEST : rank);
        Utils.setNewRankPrefix(p, Permissions.getRank(p));
    }

    public static Rank getRank(Player p) {
        return ranks.get(p);
    }

    public static boolean hasPermission(Player p, Rank rank) {
        switch (rank) {
            case ADMIN:
                return getRank(p) == Rank.ADMIN;
            case OP:
                return getRank(p) == Rank.ADMIN || getRank(p) == Rank.OP;
            case USER:
                return getRank(p) == Rank.ADMIN || getRank(p) == Rank.OP || getRank(p) == Rank.USER;
            case GUEST:
                return true;
        }
        return false;
    }



    public static String getPrefix(Rank rank) {
        return rank.prefix;
    }

    public enum Rank {
        GUEST("§8[§7Spec§8] "),
        USER(""),
        OP(""),
        ADMIN("§8[§4Admin§8] ");

        private final String prefix;

        Rank(String prefix) {
            this.prefix = prefix;
        }
    }
}
