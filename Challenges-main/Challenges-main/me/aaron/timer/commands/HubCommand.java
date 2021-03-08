package me.aaron.timer.commands;

import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            Utils.SendToServer(p, "hub");
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("all")) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    Utils.SendToServer(pl, "hub");
                }
            }
        }
        return true;
    }
}
