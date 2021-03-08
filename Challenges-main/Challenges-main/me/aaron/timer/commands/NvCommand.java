package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NvCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("challenges.nv")) {
            p.addPotionEffect((new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255)));
        } else {
            p.sendMessage(Main.getPrefix("Night-Vision", "For that you have §cno the Rights"));
        }
        return false;
    }
}
