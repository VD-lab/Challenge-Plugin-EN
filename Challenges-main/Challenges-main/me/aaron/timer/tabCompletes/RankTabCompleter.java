package me.aaron.timer.tabCompletes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class RankTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 2) {
            List<String> arguments = new ArrayList<>();
            arguments.add("admin");
            arguments.add("op");
            arguments.add("user");
            arguments.add("guest");

            return arguments;
        }

        return null;
    }
}
