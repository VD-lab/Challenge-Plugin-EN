package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Permissions;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
            if (args.length >= 1) {
                try {
                    Player p = Bukkit.getPlayerExact(args[0]);
                    BanList banList = Bukkit.getBanList(BanList.Type.NAME);
                    StringBuilder msg = new StringBuilder();
                    for (int i = 1; i < args.length; i++) {
                        msg.append(args[i] + " ");
                    }
                    String reason = msg.toString();
                    banList.addBan(p.getName(), (args.length == 1) ? "Banned by Administrator" : reason, null, null);
                    if (args.length == 1) {
                        p.kickPlayer("§cYou was banned for all the time!");
                    } else {
                        p.kickPlayer("§cYou was banned from this Server!\n\n§7Reason: §f" + reason);
                    }
                    Bukkit.broadcastMessage(Main.getPrefix("Ban", "The Player §9" + p.getName() + "§7 was hit §cfrom Bananvil §7because!" + reason));
                } catch (Exception e) {
                    sender.sendMessage(Main.getPrefix("Ban", "The Player §9" + args[0] + "§7 can §cnot found §7on this Server."));
                }
            }
        } else {
            sender.sendMessage(Main.getPrefix("Ban", "You have §cno Rights §7to use this Command."));
        }
        return false;
    }
}
