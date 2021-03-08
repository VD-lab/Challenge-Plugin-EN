package me.aaron.timer.tabCompletes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MobsTabCompleter implements TabCompleter {
    List<String> mobsTabCompletes = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            mobsTabCompletes.add("remove");

            return mobsTabCompletes;
        }

        return null;
    }
}
