package me.aaron.timer.tabCompletes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TimerTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String arg, String[] args) {
        if(args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("pause");
            arguments.add("resume");
            arguments.add("reset");
            arguments.add("reverse");
            return arguments;
        }



        return null;
    }
}
