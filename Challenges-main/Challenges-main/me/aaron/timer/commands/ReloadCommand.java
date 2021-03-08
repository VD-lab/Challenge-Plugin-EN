package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Config;
import me.aaron.timer.utils.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("challenges.reload")) {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.sendMessage("§e§l[Reload] §r§eIt can now lag one Second.");
            }
            Config.saveConfig();
            Bukkit.getServer().reload();
        } else {
            sender.sendMessage(Main.getPrefix("Reload", "You have for that §cno rights"));
        }
        return false;
    }
}
