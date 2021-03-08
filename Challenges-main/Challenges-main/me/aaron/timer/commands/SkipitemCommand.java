package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.projects.AllItems;
import me.aaron.timer.utils.Permissions;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import me.aaron.timer.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkipitemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player) || Permissions.hasPermission((Player) sender, Permissions.Rank.OP)) {
            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS) == SettingsItems.ItemState.ENABLED) {
                AllItems.next();
            } else {
                sender.sendMessage(Main.getPrefix("Skip-Item", "This Command can only use, when the Project §3Collect all Items §7aktive is."));
            }
        } else {
             sender.sendMessage(Main.getPrefix("Skip-Item", "You have §cno Rights §7to use this Command."));
        }
        return false;
    }
}
