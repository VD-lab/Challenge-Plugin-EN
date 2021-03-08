package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.aaron.timer.utils.NewWorld;

public class WorldCommand implements CommandExecutor {
    NewWorld world = new NewWorld();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof  Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("challenges.world")) {
            if (args.length == 2) {
                String name = args[0];
                World.Environment environment = World.Environment.valueOf(args[1]);
                WorldCreator wc = new WorldCreator(name);
                world.nameWorld(name);
                world.setWc(wc, p, environment);
            } else if (args.length == 0) {
                world.getWorld(p);
            }
        } else {
            p.sendMessage(Main.getPrefix("World", "You have for that §cno Rights"));
        }
        return true;
    }
}
