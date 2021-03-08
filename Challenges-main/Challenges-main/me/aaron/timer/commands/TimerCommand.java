package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cNo Command");
            return false;
        }
        Player p = (Player) sender;
        if (args.length >= 1) {
            if (p.hasPermission("challenges.timer")) {
                if (args[0].equalsIgnoreCase("pause")) {
                    if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                        if (Timer.state == Timer.TimerState.RUNNING) {
                            Timer.pause(true);
                        } else if (Timer.state == Timer.TimerState.PAUSED) {
                            p.sendMessage("§8[§6Timer§8] §7The Timer is §cpaused.");
                        }
                    } else {
                        p.sendMessage(Main.getPrefix("Timer", "The Timer is not active, you can go to §9/settings §7 to activate the Timer."));
                    }
                } else if (args[0].equalsIgnoreCase("resume")) {
                    if (SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS) == SettingsItems.ItemState.ENABLED) {
                        p.setHealth(1);
                        p.setFoodLevel(18);
                    }
                    if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                        if (Timer.state == Timer.TimerState.PAUSED) {
                            Timer.resume(true);
                        } else if (Timer.state == Timer.TimerState.RUNNING) {
                            p.sendMessage("§8[§6Timer§8] §7The Timer §c running.");
                        }
                    } else {
                        p.sendMessage(Main.getPrefix("Timer", "The Timer is not active, you can go to §9/settings §7to active the Timer."));
                    }
                } else if (args[0].equalsIgnoreCase("reset")) {
                    if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                        Timer.reset();
                        p.sendMessage("§8[§6Timer§8] §7The Timer §creset");
                    } else {
                        p.sendMessage(Main.getPrefix("Timer", "The Timer is not active, you can go to §9/settings §7to active the Timer."));
                    }
                } else if (args[0].equalsIgnoreCase("reverse")) {
                    if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                        if (args.length == 1) {
                            if (SettingsModes.timer.get(SettingsItems.ItemType.REVERSE) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.timer.put(SettingsItems.ItemType.REVERSE, SettingsItems.ItemState.ENABLED);
                                p.sendMessage("§8[§6Timer§8] §7The Timer running now §6reverse.");
                            } else {
                                SettingsModes.timer.put(SettingsItems.ItemType.REVERSE, SettingsItems.ItemState.DISABLED);
                                p.sendMessage("§8[§6Timer§8] §7The Timer run now §6normal.");
                            }
                        }
                    } else {
                        p.sendMessage(Main.getPrefix("Timer", "The Timer is not active, you can go to §9/settings §7to active the Timer."));
                    }
                } else if (args.length == 3) {
                    if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                        try {
                            int hours = Integer.parseInt(args[0]);
                            int minutes = Integer.parseInt(args[1]);
                            int seconds = Integer.parseInt(args[2]);

                            int time = (seconds + (minutes * 60) + (hours * 3600));

                            if (!(hours < 0 && minutes < 0 && seconds < 0)) {
                                Timer.firststart = false;
                                Timer.setCurrentTime(time);
                                Timer.setStartTime(time);
                            } else {
                                p.sendMessage(Main.getPrefix("Timer", "The Timer can only run with Numbers >0!"));
                            }

                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendMessage("§8[§6Timer§8] §7The Timer set from Player §9§l" + p.getName() + "§7 to " + Timer.ConvertTimerTime(time, "§6§l"));
                            }
                        } catch (Exception e) {
                            p.sendMessage(Main.getPrefix("Timer", "Use §9/timer §8<§7Hours§8> <§7Minutes§8> <§7Seconds§8>"));
                        }
                    } else {
                        p.sendMessage(Main.getPrefix("Timer", "The Timer is not active, you can go to §9/settings §7to active the Timer."));
                    }
                 } else {
            p.sendMessage(Main.getPrefix("Timer-Command", "Help:"));
            p.sendMessage("§9/timer §8<§7resume§8>§7: Resume the Timer.");
            p.sendMessage("§9/timer §8<§7pause§8>§7: Pause the Timer.");
            p.sendMessage("§9/timer §8<§7reverse§8>§7: Let the Timer run normal or reverse laufen.");
            p.sendMessage("§9/timer §8<§7reset§8>§7: Reset the Timer.");
            p.sendMessage("§9/timer §8<§7Hours§8> <§7Minutes§8> <§7Seconds§8>§7: Put the Timer on the Time.");
        }
            } else {
                p.sendMessage(Main.getPrefix("Timer", "You have for Timer §cno Rights"));
            }
        } else {
            p.sendMessage(Main.getPrefix("Timer-Command", "Help:"));
            p.sendMessage("§9/timer §8<§7resume§8>§7: Resume the Timer.");
            p.sendMessage("§9/timer §8<§7pause§8>§7: Pause the Timer.");
            p.sendMessage("§9/timer §8<§7reverse§8>§7: Let the Timer run normal or reverse.");
            p.sendMessage("§9/timer §8<§7reset§8>§7: Reset the Timer.");
            p.sendMessage("§9/timer §8<§7Hours§8> <§7Minutes§8> <§7Seconds§8>§7: Put the Timer on the Time.");
        }

        return false;
    }
}
