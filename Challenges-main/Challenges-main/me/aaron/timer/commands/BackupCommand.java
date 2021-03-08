package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Backup;
import me.aaron.timer.utils.Permissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackupCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.ADMIN)) {
            Backup.backup();
        } else {
            sender.sendMessage(Main.getPrefix("Backup", "You have §cno Rights §7to use this Command"));
        }
        return false;
    }
}
