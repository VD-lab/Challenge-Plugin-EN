package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }

        Player p = (Player) sender;
        if (p.hasPermission("gm.change")) {

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                    p.setGameMode(GameMode.SURVIVAL);
                }
                if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                    p.setGameMode(GameMode.CREATIVE);
                }
                if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                    p.setGameMode(GameMode.ADVENTURE);
                }
                if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            }
            if (args.length == 2) {
                if (args[1].equalsIgnoreCase("@a")) {
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setGameMode(GameMode.SURVIVAL);
                        }
                    } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setGameMode(GameMode.CREATIVE);
                        }
                    } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setGameMode(GameMode.ADVENTURE);
                        }
                    } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.setGameMode(GameMode.SPECTATOR);
                        }
                    }

                } else {
                    try {
                        Player s = Bukkit.getPlayer(args[1]);
                        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                            s.setGameMode(GameMode.SURVIVAL);
                        } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                            s.setGameMode(GameMode.CREATIVE);
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                            s.setGameMode(GameMode.ADVENTURE);
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                            s.setGameMode(GameMode.SPECTATOR);
                        }
                    } catch (Exception e) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendMessage("§8[§6Gamemode§8] §7The Player §9" + args[0] + " §7 can §cnot found §7on this Server.");
                        }
                    }
                }
            }
        } else {
            p.sendMessage(Main.getPrefix("Gamemode", "For this Command you have §cno Rights"));
        }
        return false;
    }
}