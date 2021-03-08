package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SettingsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;

        if (p.hasPermission("challenges.settings")) {
            Settings.openInv(p);
        } else {
            p.sendMessage(Main.getPrefix("Heal", "You have for that §cno Rights"));
        }

        return false;
    }
}
