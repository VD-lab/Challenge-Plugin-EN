package me.aaron.timer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;

        Inventory inv = Bukkit.createInventory(null, 54, "Trash");
        p.openInventory(inv);

        return false;
    }
}
