package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player s = (Player) sender;
        if (s.hasPermission("challenges.invsee")) {
            if (args.length == 1) {
                try {
                    Player p = Bukkit.getPlayerExact(args[0]);
                    Inventory raw = Bukkit.createInventory(null, 54, "InvSee: §c§l" + p.getName());
                    for (int i = 0; i < p.getInventory().getSize(); i ++) {
                        raw.setItem(i, p.getInventory().getItem(i ));
                    }
                    Inventory inv = Bukkit.createInventory(null, 54, "InvSee: §c§l" + p.getName());
                    s.openInventory(inv);
                } catch (Exception e) {
                    s.sendMessage(Main.getPrefix("InvSee", "The Player can §9" + args[0] + " §7not found §7on the Server."));
                }
            } else {
                s.sendMessage(Main.getPrefix("InvSee", "/invsee §9<Player Name>"));
            }
        } else {
            s.sendMessage(Main.getPrefix("InvSee", "You have for that §cno Rights."));
        }


        return false;
    }
}
