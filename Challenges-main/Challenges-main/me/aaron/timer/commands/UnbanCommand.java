package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Permissions;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnbanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
            if (args.length == 1) {
                BanList banList = Bukkit.getBanList(BanList.Type.NAME);
                OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
                try {
                    if (p.isBanned()) {
                        banList.pardon(args[0]);
                        sender.sendMessage(Main.getPrefix("Unban", "The Player §9" + p.getName() + " §7is now unban."));
                    } else {
                        sender.sendMessage(Main.getPrefix("Unban", "The Player §9" + p.getName() + " §7is not banned."));
                    }
                } catch (Exception e) {
                    sender.sendMessage(Main.getPrefix("Unban", "The Player §9" + args[0] + " §7can not found."));
                }
            }
        } else {
            sender.sendMessage(Main.getPrefix("Ban", "You have §cno Rights §7to use this Command."));
        }
        return false;
    }
}
