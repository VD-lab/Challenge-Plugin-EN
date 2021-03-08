package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.aaron.timer.utils.Config;

import java.io.IOException;

public class SeedCommand implements CommandExecutor {
    private String name;
    private long seed;
    Config config = new Config();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("challenges.seed")) {

            seed = Bukkit.getWorld("world").getSeed();

            if (args.length == 0) {
                sender.sendMessage("§8[§6Seed§8] §a" + seed);
            } else if (args.length == 1) {
                name = args[0];
                try {
                    config.set("seeds." + name, seed);
                    sender.sendMessage("§8[§6Seed§8] §7The Seed §a" + seed + " §7is now with the Name: §9" + name + " §7saved.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            sender.sendMessage(Main.getPrefix("Seed", "You have for that §cno Rights"));
        }



        return false;
    }
}
