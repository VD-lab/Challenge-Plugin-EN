package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Config;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class SaveCommand implements CommandExecutor {
    Config config = new Config();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("challenges.saveconfig")) {
            Config.saveConfig();
            sender.sendMessage(Main.getPrefix("Config", "The Config is saved."));
        } else {
            sender.sendMessage(Main.getPrefix("Save Config", "You have for that §cno Rights"));
        }
        return false;
    }
}
