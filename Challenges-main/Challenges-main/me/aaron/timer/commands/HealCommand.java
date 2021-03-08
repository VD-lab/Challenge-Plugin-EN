package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;

        if (p.hasPermission("challenges.heal")) {
            if (args.length == 0) {
                p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                p.setFoodLevel(20);
                p.sendMessage("§8[§6Heal§8] §7You are §ahealed");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
                p.sendMessage("§8[§6Heal§8] §7You healed all Player");
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    if (!pl.getName().equals(p.getName())) {
                        pl.sendMessage("§8[§6Heal§8] §7You were from §9" + p.getName() + "§7 healed");
                    }
                    pl.setHealth(pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                    pl.setFoodLevel(20);
                }
            } else {
                p.sendMessage("§6Heal-Command");
                p.sendMessage("§7/heal §9heal you");
                p.sendMessage("§7/heal §6all §9heal all Players");
                p.sendMessage("§2§l------------------------------------------------");
                p.sendMessage(["",{"text":"Heal me","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/heal"},"hoverEvent":{"action":"show_text","contents":["",{"text":"Click me","color":"gold"},{"text":" to "},{"text":"Heal","bold":"true","color":"green"},{"text":"\nyou now!"}]}},{"text":" "},{"text":"||||||||||||||||||||||||||||||||||||||","color":"gold","clickEvent":{"action":"run_command","value":"/tellraw @s \"I am realy no Button\""},"hoverEvent":{"action":"show_text","contents":"I am no Button :("}},{"text":" "},{"text":"Heal all players","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/heal all"},"hoverEvent":{"action":"show_text","contents":["",{"text":"Click me","color":"gold"},{"text":" to "},{"text":"Heal all","bold":"true","color":"green"},{"text":"\nPlayer on this Server"}]}},{"text":" ","bold":true,"color":"green","hoverEvent":{"action":"show_text","contents":["",{"text":"Click me","color":"gold"},{"text":" to "},{"text":"Heal all","bold":"true","color":"green"},{"text":"\nPlayer on this Server"}]}}]);
                p.sendMessage("§2§l------------------------------------------------");
            }
        } else {
            p.sendMessage(Main.getPrefix("Heal", "You have for this Command §cno Rights"));
        }

        return false;
    }
}
