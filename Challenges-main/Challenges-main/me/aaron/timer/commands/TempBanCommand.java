package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Permissions;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TempBanCommand implements CommandExecutor {
    private int bantime = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String reason = null;
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
            if (args.length == 2 || args.length == 3 || args.length == 4) {
                if (args[1].substring(args[1].length() - 1).equalsIgnoreCase("s")) {
                    try {
                        bantime = Integer.parseInt(args[1].substring(0, args[1].length() - 1));
                        Bukkit.broadcastMessage(Main.getPrefix("Ban ", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length >= 3) {
                            reason = args[2];
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");
                    }
                /*} else if (args.length >= 3 && args[2].equalsIgnoreCase("s")) {
                    try {
                        bantime = Integer.parseInt(args[1]);
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 4) {
                            reason = args[3];
                        }
                    } catch (Exception e) {
                        Bukkit.broadcastMessage("ERROR");
                    }*/
                } else if (args[1].substring(args[1].length() - 1).equalsIgnoreCase("h")) {
                    try {
                        bantime = Integer.parseInt(args[1].substring(0, args[1].length() - 1)) * 3600;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 3) {
                            reason = args[2];
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");
                    }
                /*} else if (args.length >= 3 && args[2].equalsIgnoreCase("h")) {
                    try {
                        bantime = Integer.parseInt(args[1]) * 3600;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 4) {
                            reason = args[3];
                        }
                    } catch (Exception e) {
                        Bukkit.broadcastMessage("ERROR");
                    }*/
                } else if (args[1].substring(args[1].length() - 1).equalsIgnoreCase("d")) {
                    try {
                        bantime = Integer.parseInt(args[1].substring(0, args[1].length() - 1)) * 86400;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 3) {
                            reason = args[2];
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");
                    }
                /*} else if (args.length >= 3 && args[2].equalsIgnoreCase("d")) {
                    try {
                        bantime = Integer.parseInt(args[1]) * 86400;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 4) {
                            reason = args[3];
                        }
                    } catch (Exception e) {
                        Bukkit.broadcastMessage("ERROR");
                    }*/
                } else if (args[1].substring(args[1].length() - 1).equalsIgnoreCase("m")) {
                    try {
                        bantime = Integer.parseInt(args[1].substring(0, args[1].length() - 1)) * 2592000;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 3) {
                            reason = args[2];
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");;
                    }
                /*} else if (args.length >= 3 && args[2].equalsIgnoreCase("m")) {
                    try {
                        bantime = Integer.parseInt(args[1]) * 2592000;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 4) {
                            reason = args[3];
                        }
                    } catch (Exception e) {
                        Bukkit.broadcastMessage("ERROR");
                    }*/
                } else if (args[1].substring(args[1].length() - 1).equalsIgnoreCase("y")) {
                    try {
                        bantime = Integer.parseInt(args[1].substring(0, args[1].length() - 1)) * 31104000;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 3) {
                            reason = args[2];
                        }
                    } catch (Exception e) {
                        sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");
                    }
                /*} else if (args.length >= 3 && args[2].equalsIgnoreCase("y")) {
                    try {
                        bantime = Integer.parseInt(args[1]) * 31104000;
                        Bukkit.broadcastMessage(Main.getPrefix("Ban", "§9" + args[0] + " §7Temporary banned for " + Timer.ConvertTimerTime(bantime, "§6") + " §7."));
                        if (args.length == 4) {
                            reason = args[3];
                        }
                    } catch (Exception e) {
                        Bukkit.broadcastMessage("ERROR");
                    }*/
                } else {
                    sender.sendMessage("§6/tempban-Command:\n§9/tempban §5<Playername> <Time §8(§7e.g. 10s, 14d, 6m, 1y§8)§5> <Reason §8(§7Optional§8)");
                }
            }
            if (bantime != 0) {
                try {
                    Player p = Bukkit.getPlayerExact(args[0]);
                    banList.addBan(p.getName(), (reason == null) ? "Banned by Administrator" : reason, Utils.calculateUnban(bantime), sender.getName());
                    if (reason == null) {
                        p.kickPlayer("§cYou are Temporary banned for " + Timer.ConvertTimerTime(bantime, "§f") + " §con this Server!");
                    } else {
                        p.kickPlayer("§cYou are Temporary banned for " + Timer.ConvertTimerTime(bantime, "§f") + " §con this Server!\n\n§7Reason: §f" + reason);
                    }
                } catch (Exception e) {
                    sender.sendMessage(Main.getPrefix("Ban", "The Player §9" + args[0] + " §7can §not found §7on the Server Network."));
                }
            }

        } else {
            sender.sendMessage(Main.getPrefix("Ban", "You have for that §cno Rights§7."));
        }
        return false;
    }
}
