package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Permissions;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("admin")) {
                if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
                    try {
                        Bukkit.getPlayerExact(args[0]).setOp(true);
                        Permissions.ranks.put(Bukkit.getPlayerExact(args[0]), Permissions.Rank.ADMIN);
                        sender.sendMessage(Main.getPrefix("Rank", "The Player §9" + Bukkit.getPlayerExact(args[0]).getName() + " §7have now the Rights of an §4Admin§7."));
                        Bukkit.getPlayerExact(args[0]).sendMessage(Main.getPrefix("Rang", "You are now Rank §4Admin§7."));
                        Utils.setNewRankPrefix(Bukkit.getPlayerExact(args[0]), Permissions.Rank.ADMIN);
                    } catch (Exception e) {
                        sender.sendMessage(Main.getPrefix("Rank", "The Player can §cnot found §7on this Server."));
                    }
                } else {
                    sender.sendMessage(Main.getPrefix("Rang", "You have §cno rights §7to do that."));
                }
            } else if (args[1].equalsIgnoreCase("op")) {
                if (!(sender instanceof  Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
                    try {
                        Bukkit.getPlayerExact(args[0]).setOp(true);
                        Permissions.ranks.put(Bukkit.getPlayerExact(args[0]), Permissions.Rank.OP);
                        sender.sendMessage(Main.getPrefix("Rank", "The Player §9" + Bukkit.getPlayerExact(args[0]).getName() + " §7have now Rank §2OP§7."));
                        Bukkit.getPlayerExact(args[0]).sendMessage(Main.getPrefix("Rang", "You have now the Rank §2OP§7."));
                        Utils.setNewRankPrefix(Bukkit.getPlayerExact(args[0]), Permissions.Rank.OP);
                    } catch (Exception e) {
                        sender.sendMessage(Main.getPrefix("Rank", "This Player can §cnot found §7on the Server."));
                    }
                } else {
                    sender.sendMessage(Main.getPrefix("Rang", "For that, you have §cno Rights."));
                }
            } else if (args[1].equalsIgnoreCase("user")) {
                if (!(sender instanceof  Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
                    try {
                        Bukkit.getPlayerExact(args[0]).setOp(false);
                        Permissions.ranks.put(Bukkit.getPlayerExact(args[0]), Permissions.Rank.USER);
                        sender.sendMessage(Main.getPrefix("Rank", "The Palyer §9" + Bukkit.getPlayerExact(args[0]).getName() + " §7have now Rank §9User§7."));
                        Bukkit.getPlayerExact(args[0]).sendMessage(Main.getPrefix("Rang", "You have now Rank §9User§7."));
                        Utils.setNewRankPrefix(Bukkit.getPlayerExact(args[0]), Permissions.Rank.USER);
                    } catch (Exception e) {
                        sender.sendMessage(Main.getPrefix("Rank", "This Player can §cnot found §7on the Server."));
                    }
                } else {
                    sender.sendMessage(Main.getPrefix("Rang", "You have for that §cno Rights."));
                }
            } else if (args[1].equalsIgnoreCase("guest")) {
                if (!(sender instanceof  Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
                    try {
                        Player p = Bukkit.getPlayerExact(args[0]);
                        p.setOp(false);
                        Permissions.ranks.put(Bukkit.getPlayerExact(args[0]), Permissions.Rank.GUEST);
                        sender.sendMessage(Main.getPrefix("Rank", "The Player §9" + Bukkit.getPlayerExact(args[0]).getName() + " §7have now Rank §9Guest§7."));
                        p.sendMessage(Main.getPrefix("Rang", "You have now the Rank §9Guest§7."));
                        Utils.setNewRankPrefix(p, Permissions.Rank.GUEST);
                    } catch (Exception e) {
                        sender.sendMessage(Main.getPrefix("Rank", "The Player can §cnot found §7on the Server."));
                    }
                } else {
                    sender.sendMessage(Main.getPrefix("Rang", "You have for that §cno rights."));
                }
            }
        }
        return false;
    }
}
