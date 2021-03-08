package me.aaron.timer.tabCompletes;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class WorldTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            List<String> allWorlds = new ArrayList<>();
            World[] worlds = new World[Bukkit.getServer().getWorlds().size()];
            Bukkit.getServer().getWorlds().toArray(worlds);
            for (World world : worlds) {
                allWorlds.add(world.getName());
            }
            return allWorlds;
        }
        return null;
    }
}
