package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("challenges.fly")) {
            p.setAllowFlight(!p.getAllowFlight());
            if (p.getAllowFlight()) {
                p.sendMessage("§8[§6Fly§8]§a Active");
            } else {
                p.sendMessage("§8[§6Fly§8]§c not Active");
            }
        } else {
            p.sendMessage(Main.getPrefix("Fly", "For this Command you have §cno Rights"));
        }

        return false;
    }
}
