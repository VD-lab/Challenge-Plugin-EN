package me.aaron.timer.commands;

import me.aaron.timer.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DorfCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        World w = p.getWorld();

        if (p.hasPermission("timer.dorfspawn")) {
            if (w.getEnvironment().equals(World.Environment.NORMAL)) {
                Location vil = w.locateNearestStructure(p.getLocation(), StructureType.VILLAGE, 1000, false);
                if (vil != null) {
                    for (int i = w.getSeaLevel(); i < 255; i++) {
                        vil.setY(i);
                        if (vil.getBlock().getType() == Material.AIR) {
                            w.loadChunk(vil.getBlockX(), vil.getBlockZ());
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.teleport(vil);
                            }
                            if (args.length == 1) {
                                if (args[0].equalsIgnoreCase("spawn")) {
                                    w.setSpawnLocation(vil);
                                }
                            }
                            break;
                        }
                    }
                } else {
                    p.sendMessage("§8§6Dorf§8] §7It is §cno Village §7in the near.");
                }
            } else {
                p.sendMessage("§8[§6Dorf§8] §7You must be in the §6Overworld §7Demension.");
            }
        } else {
            p.sendMessage(Main.getPrefix("Dorf", "You have for this Command §cno rights!"));
        }

        return false;
    }
}
