package me.aaron.timer.commands;

import me.aaron.timer.Main;
import me.aaron.timer.projects.AllMobs;
import me.aaron.timer.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import static me.aaron.timer.projects.AllMobs.isFound;

public class MobsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS) == SettingsItems.ItemState.ENABLED) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cNo Command");
                    return false;
                }
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.openInventory(Moboverview());
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("remove")) {
                        try {
                            AllMobs.mobnames.remove(args[1].toUpperCase());
                            AllMobs.entities.remove(EntityType.valueOf(args[1].toUpperCase()));
                            sender.sendMessage(Main.getPrefix("Skip Mob", "The Mob §9" + args[1] + " §7is now removed."));
                        } catch (Exception e) {
                            sender.sendMessage(Main.getPrefix("Skip Mob", "§9/mobs remove <§oMob-ID§7>"));
                        }
                    }
                } else {
                    sender.sendMessage(Main.getPrefix("Skip Mob", "§9/mobs remove <§oMob-ID§7>"));
                }
            } else {
                sender.sendMessage(Main.getPrefix("All Mobs", "You can only use this Command, when the Project §9All Mobs §7aktive is."));
            }
        return false;
    }

    public static Inventory Moboverview() {
        Inventory inv = Bukkit.createInventory(null, 54, "Moboverview §7» §8Seite 1");
        Utils.fillWithGlass(inv);
        inv.setItem(0, isFound(EntityType.SKELETON_HORSE));
        inv.setItem(1, isFound(EntityType.SLIME));
        inv.setItem(2, isFound(EntityType.CREEPER));
        inv.setItem(3, isFound(EntityType.SKELETON));
        inv.setItem(4, isFound(EntityType.SPIDER));
        inv.setItem(5, isFound(EntityType.CAVE_SPIDER));
        inv.setItem(6, isFound(EntityType.ZOMBIE));
        inv.setItem(7, isFound(EntityType.GHAST));
        inv.setItem(8, isFound(EntityType.ZOMBIFIED_PIGLIN));
        inv.setItem(9, isFound(EntityType.ENDERMAN));
        inv.setItem(10, isFound(EntityType.SILVERFISH));
        inv.setItem(11, isFound(EntityType.BLAZE));
        inv.setItem(12, isFound(EntityType.MAGMA_CUBE));
        inv.setItem(13, isFound(EntityType.WITHER));
        inv.setItem(14, isFound(EntityType.BAT));
        inv.setItem(15, isFound(EntityType.WITCH));
        inv.setItem(16, isFound(EntityType.ENDERMITE));
        inv.setItem(17, isFound(EntityType.GUARDIAN));
        inv.setItem(18, isFound(EntityType.SHULKER));
        inv.setItem(19, isFound(EntityType.PIG));
        inv.setItem(20, isFound(EntityType.SHEEP));
        inv.setItem(21, isFound(EntityType.COW));
        inv.setItem(22, isFound(EntityType.CHICKEN));
        inv.setItem(23, isFound(EntityType.SQUID));
        inv.setItem(24, isFound(EntityType.WOLF));
        inv.setItem(25, isFound(EntityType.MUSHROOM_COW));
        inv.setItem(26, isFound(EntityType.SNOWMAN));
        inv.setItem(27, isFound(EntityType.OCELOT));
        inv.setItem(28, isFound(EntityType.IRON_GOLEM));
        inv.setItem(29, isFound(EntityType.HORSE));
        inv.setItem(30, isFound(EntityType.RABBIT));
        inv.setItem(31, isFound(EntityType.POLAR_BEAR));
        inv.setItem(32, isFound(EntityType.LLAMA));
        inv.setItem(33, isFound(EntityType.PARROT));
        inv.setItem(34, isFound(EntityType.VILLAGER));
        inv.setItem(35, isFound(EntityType.TURTLE));
        inv.setItem(36, isFound(EntityType.PHANTOM));
        inv.setItem(37, isFound(EntityType.COD));
        inv.setItem(38, isFound(EntityType.SALMON));
        inv.setItem(39, isFound(EntityType.PUFFERFISH));
        inv.setItem(40, isFound(EntityType.TROPICAL_FISH));
        inv.setItem(41, isFound(EntityType.DROWNED));
        inv.setItem(42, isFound(EntityType.DOLPHIN));
        inv.setItem(43, isFound(EntityType.CAT));
        inv.setItem(44, isFound(EntityType.PANDA));

        inv.setItem(45, Settings.Exit());
        inv.setItem(53, Settings.Next());

        return inv;
    }

    public static Inventory Moboverview2() {
        Inventory inv = Bukkit.createInventory(null, 54, "Moboverview §7» §8Seite 2");
        Utils.fillWithGlass(inv);
        inv.setItem(0, isFound(EntityType.PILLAGER));
        inv.setItem(1, isFound(EntityType.RAVAGER));
        inv.setItem(2, isFound(EntityType.TRADER_LLAMA));
        inv.setItem(3, isFound(EntityType.WANDERING_TRADER));
        inv.setItem(4, isFound(EntityType.FOX));
        inv.setItem(5, isFound(EntityType.BEE));
        inv.setItem(6, isFound(EntityType.HOGLIN));
        inv.setItem(7, isFound(EntityType.PIGLIN));
        inv.setItem(8, isFound(EntityType.STRIDER));
        inv.setItem(9, isFound(EntityType.ZOGLIN));
        inv.setItem(10, isFound(EntityType.PIGLIN_BRUTE));
        inv.setItem(11, isFound(EntityType.DONKEY));
        inv.setItem(12, isFound(EntityType.MULE));
        inv.setItem(13, isFound(EntityType.EVOKER));
        inv.setItem(14, isFound(EntityType.VINDICATOR));
        inv.setItem(15, isFound(EntityType.ELDER_GUARDIAN));
        inv.setItem(16, isFound(EntityType.WITHER_SKELETON));
        inv.setItem(17, isFound(EntityType.STRAY));
        inv.setItem(18, isFound(EntityType.HUSK));
        inv.setItem(19, isFound(EntityType.ZOMBIE_VILLAGER));

        inv.setItem(45, Settings.Back());

        return inv;
    }
}
