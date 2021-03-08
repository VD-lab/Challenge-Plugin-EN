package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.aaron.timer.utils.Position;

public class PositionCommand implements CommandExecutor {
    Position pos = new Position();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("share")) {
                pos.share(p);
            } else {
                pos.pos(args[0], p);
            }
        } else if (args.length == 0) {
            pos.list(p);
            return false;
        } else if (args.length == 2 && args[0].equalsIgnoreCase("remove")) {
            pos.remove(args[1], p);
        } else {
            p.sendMessage(Main.getPrefix("Position", "Your Name §ccan't have 'Space' Characters §7 in the Name."));
        }

        return false;
    }
}
