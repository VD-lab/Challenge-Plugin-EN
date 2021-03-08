package me.aaron.timer.listeners;

import me.aaron.timer.Main;
import me.aaron.timer.challenges.*;
import me.aaron.timer.commands.MobsCommand;
import me.aaron.timer.projects.AllDeathMessages;
import me.aaron.timer.projects.AllItems;
import me.aaron.timer.projects.AllMobs;
import me.aaron.timer.utils.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        int slot = e.getRawSlot();

        boolean isLeftClick = e.getClick() == ClickType.LEFT;
        boolean isRightClick = e.getClick() == ClickType.RIGHT;
        boolean isShiftLeftClick = e.getClick() == ClickType.SHIFT_LEFT;
        boolean isShiftRightClick = e.getClick() == ClickType.SHIFT_RIGHT;

        Player p = (Player) e.getWhoClicked();

        if (!e.getWhoClicked().getType().equals(EntityType.PLAYER)) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getCurrentItem() == null) {
            return;
        }

        if (e.getView().getTitle().contains("Settings") || e.getView().getTitle().equalsIgnoreCase("Livesettings") || e.getView().getTitle().equalsIgnoreCase("Challenges §7» §8Page 1") || e.getView().getTitle().equalsIgnoreCase("Challenges §7» §8Page 2") || e.getView().getTitle().equalsIgnoreCase(Settings.getOtherMenuName()) || e.getView().getTitle().equalsIgnoreCase("Timer Settings") || e.getView().getTitle().equalsIgnoreCase("Other Settings §7» §8Page 2") || e.getView().getTitle().equalsIgnoreCase("Other Settings §7» §8Page 3") || e.getView().getTitle().equalsIgnoreCase("Project") || e.getView().getTitle().contains("InvSee:") || e.getView().getTitle().contains("reset?") || e.getView().getTitle().contains("Moboverview")) {
            e.setCancelled(true);
            String title = e.getView().getTitle();
            if(e.getCurrentItem().isSimilar(Settings.Health())) { p.openInventory(Settings.getHealthMenu()); }

            else if (e.getCurrentItem().isSimilar(Settings.ChallengesSettings())) { p.openInventory(Settings.getChallengesMenu()); }

            else if (e.getCurrentItem().isSimilar(Settings.Projects())) { p.openInventory(Settings.ProjectMenu()); }

            else if (e.getCurrentItem().isSimilar(Settings.Other())) { p.openInventory(Settings.getOtherMenu()); }

            //Lebenseinstellungen Menu
            if (e.getView().getTitle().equalsIgnoreCase("Livesettings")) {
                switch (slot) {
                    case 10:
                        if (e.getCurrentItem().getType() == Material.LIME_DYE) {
                            SettingsModes.settings.put(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsItems.ItemState.DISABLED));
                            Utils.sendChange("§6Shared Hearths", "§7is §cdisabeled");
                            break;
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.GEITEILTEHERZEN, SettingsItems.ItemState.ENABLED));
                            Utils.sendChange("§6Shared Hearths", "§7is §adisabeled");
                            break;
                        }
                    case 11:
                        if (e.getCurrentItem().getType() == Material.LIME_DYE) {
                            SettingsModes.settings.put(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.DISABLED));
                            Utils.sendChange("§6Respawn", "§7is §cdisabeled");
                            break;
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.ENABLED));
                            Utils.sendChange("§6Respawn", "§7is §aenabled");
                            if (SettingsModes.settings.get(SettingsItems.ItemType.ONELIFE) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.settings.put(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.DISABLED));
                            }
                            break;
                        }
                    case 12:
                        if (e.getCurrentItem().getType() == Material.LIME_DYE) {
                            SettingsModes.settings.put(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.DISABLED));
                            Utils.sendChange("§6One Live for all", "§7is §cdisabled");
                            break;
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(e.getSlot(), SettingsItems.getMenuItem(SettingsItems.ItemType.ONELIFE, SettingsItems.ItemState.ENABLED));
                            Utils.sendChange("§6One Live for all", "§7is §aenabled");
                            if (SettingsModes.settings.get(SettingsItems.ItemType.RESPAWN) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.settings.put(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.RESPAWN, SettingsItems.ItemState.DISABLED));
                            }
                            break;
                        }
                    case 14:
                        if (e.getClick().equals(ClickType.RIGHT)) {
                            if (SettingsModes.maxHP > 1) {
                                SettingsModes.maxHP -= 1;
                            }
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(SettingsModes.maxHP);
                                pl.setHealth(pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                                pl.setHealthScale(pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                            }
                        } else {
                            SettingsModes.maxHP += 1;
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(SettingsModes.maxHP);
                                pl.setHealth(pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                                pl.setHealthScale(pl.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                            }
                        }
                        e.getClickedInventory().setItem(slot, Settings.MaxHealthButton());
                        break;
                    case 15:
                        if (e.getCurrentItem().getType() == Material.LIME_DYE) {
                            SettingsModes.settings.put(SettingsItems.ItemType.NATURALREGENERATION, SettingsItems.ItemState.DISABLED);
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setGameRule(GameRule.NATURAL_REGENERATION, false);
                            }
                            Utils.sendChange("§6Naturally Regeneration", "§7is §cdisabled");
                            e.getClickedInventory().setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.NATURALREGENERATION, SettingsItems.ItemState.DISABLED));
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.NATURALREGENERATION, SettingsItems.ItemState.ENABLED);
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setGameRule(GameRule.NATURAL_REGENERATION, true);
                            }
                            Utils.sendChange("§6Naturally Regeneration", "§7is §aenabled");
                            e.getClickedInventory().setItem(15, SettingsItems.getMenuItem(SettingsItems.ItemType.NATURALREGENERATION, SettingsItems.ItemState.ENABLED));
                        }
                        break;
                    case 16:
                        if (e.getCurrentItem().getType() == Material.LIME_DYE) {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.OTHERREGENERATION, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.OTHERREGENERATION, SettingsModes.gamerule.get(SettingsItems.ItemType.OTHERREGENERATION)));
                            Utils.sendChange("§6Unnatural Regeneration", "§7is §cdisabled");
                        } else {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.OTHERREGENERATION, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(16, SettingsItems.getMenuItem(SettingsItems.ItemType.OTHERREGENERATION, SettingsModes.gamerule.get(SettingsItems.ItemType.OTHERREGENERATION)));
                            Utils.sendChange("§6Unnatural Regeneration", "§7is §aenabled");
                        }
                        break;
                    case 18:
                        p.openInventory(Settings.getMenu());
                        break;
                }
                //Challenge Menu
            } else if (e.getView().getTitle().equalsIgnoreCase("Challenges §7» §8Page 1")) {
                switch (slot) {
                    case 10:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.FLYONDAMAGE, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.FLYONDAMAGE, SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE)));
                            Utils.sendChange("§6By Hits fly", "§cis disabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.FLYONDAMAGE, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.FLYONDAMAGE, SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE)));
                            Utils.sendChange("§6By Hits fly", "§is enabled");
                        }
                        break;
                    case 11:
                        if (e.getClick().isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.SPEED) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.SPEED, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SPEED, SettingsModes.challenge.get(SettingsItems.ItemType.SPEED)));
                                Utils.sendChange("§6Speed", "§7is §cdisabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.SPEED, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SPEED, SettingsModes.challenge.get(SettingsItems.ItemType.SPEED)));
                                Utils.sendChange("§6Speed", "§7is §aenabled");
                            }
                        } else if (e.getClick().isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.SPEED));
                        }
                        break;
                    case 12:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.DIRT) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.DIRT, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.DIRT, SettingsModes.challenge.get(SettingsItems.ItemType.DIRT)));
                            Utils.sendChange("§6Only on Dirt", "§7is §cdisabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.DIRT, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.DIRT, SettingsModes.challenge.get(SettingsItems.ItemType.DIRT)));
                            Utils.sendChange("§6Only on Dirt", "§7is §aenabled");
                        }
                        break;
                    case 13:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.TENHEARTS, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TENHEARTS, SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS)));
                            Utils.sendChange("§6Never full Hearths", "§7is §aenabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.TENHEARTS, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TENHEARTS, SettingsModes.challenge.get(SettingsItems.ItemType.TENHEARTS)));
                            Utils.sendChange("§6Never full Hearths", "§7is §cdisabled");
                        }
                        break;
                    case 14:
                        if (e.isLeftClick()) {
                            Trafficlight trafficlight = new Trafficlight(Main.getInstance());
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.TRAFFICLIGHT, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TRAFFICLIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT)));
                                Utils.sendChange("§6Trafficlight-Challenge", "§7is §aenabled");
                                trafficlight.start();
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.TRAFFICLIGHT, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TRAFFICLIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT)));
                                Utils.sendChange("§6Trafficlight-Challenge", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.TRAFFICLIGHT));
                        }
                        break;
                    case 15:
                        if (e.isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART)));
                                Utils.sendChange("§61 Block = 1 Hearth Damage", "§7is §aenabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ONEBLOCKONEHEART, SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART)));
                                Utils.sendChange("§61 Block = 1 Hearth Damage", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.ONEBLOCKONEHEART));
                        }
                        break;
                    case 16:
                        if (e.isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.DAMAGEMIRROR) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.DAMAGEMIRROR, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.DAMAGEMIRROR, SettingsModes.challenge.get(SettingsItems.ItemType.DAMAGEMIRROR)));
                                Utils.sendChange("§6Mirror Damage", "§7is §aenabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.DAMAGEMIRROR, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.DAMAGEMIRROR, SettingsModes.challenge.get(SettingsItems.ItemType.DAMAGEMIRROR)));
                                Utils.sendChange("§6Mirror Damage", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.DAMAGEMIRROR));
                        }
                        break;
                    case 19:
                        if (e.isLeftClick()) {
                            ForceBlock forceBlock = new ForceBlock(Main.getInstance());
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEBLOCK, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEBLOCK, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK)));
                                Utils.sendChange("§6Force-Block", "§7is §aenabled");
                                forceBlock.start();
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEBLOCK, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEBLOCK, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK)));
                                Utils.sendChange("§6Force-Block", "§7is §cdisabeled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.FORCEBLOCK));
                        }
                        break;
                    case 20:
                        if (e.isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.BEDROCKWALL, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BEDROCKWALL, SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL)));
                                Utils.sendChange("§6Bedrock-Wall", "§7is §aenabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.BEDROCKWALL, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BEDROCKWALL, SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL)));
                                Utils.sendChange("§6Bedrock-Wall", "§7wurde §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.BEDROCKWALL));
                        }
                        break;
                    case 21:
                        if (e.isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.THEFLOORISLAVA, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.THEFLOORISLAVA, SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA)));
                                Utils.sendChange("§6The Floor is Lava", "§7is §aenabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.THEFLOORISLAVA, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.THEFLOORISLAVA, SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA)));
                                Utils.sendChange("§6The Floor is Lava", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.THEFLOORISLAVA));
                        }
                        break;
                    case 22:
                        if (e.isLeftClick()) {
                            ForceMob forceMob = new ForceMob(Main.getInstance());
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEMOB, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEMOB, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB)));
                                Utils.sendChange("§6Force Mob", "§7is §aenabled");
                                forceMob.start();
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCEMOB, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCEMOB, SettingsModes.challenge.get(SettingsItems.ItemType.FORCEMOB)));
                                Utils.sendChange("§6Force Mob", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.FORCEMOB));
                        }
                        break;
                    case 23:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.NO_CRAFTING) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.NO_CRAFTING, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_CRAFTING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_CRAFTING)));
                            Utils.sendChange("§6No Crafts", "§7is §aenabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.NO_CRAFTING, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_CRAFTING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_CRAFTING)));
                            Utils.sendChange("§6No Crafts", "§7is §cdisabled");
                        }
                        break;
                    case 24:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.NO_TRADING, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_TRADING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING)));
                            Utils.sendChange("§6No Trades", "§7is §aenabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.NO_TRADING, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.NO_TRADING, SettingsModes.challenge.get(SettingsItems.ItemType.NO_TRADING)));
                            Utils.sendChange("§6No Trades", "§7is §cdisabled");
                        }
                        break;
                    case 25:
                        if (e.isLeftClick()) {
                            ForceHeight forceHeight = new ForceHeight();
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT) == SettingsItems.ItemState.DISABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_HEIGHT, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_HEIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT)));
                                forceHeight.start();
                                Utils.sendChange("§6Force Height", "§7is §aenabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_HEIGHT, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_HEIGHT, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT)));
                                Utils.sendChange("§6Force Height", "§7is §cdisabled");
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.FORCE_HEIGHT));
                        }
                        break;

                    //zurück
                    case 27:
                        p.openInventory(Settings.getMenu());
                        break;
                    case 35:
                        p.openInventory(Settings.getChallengesMenu2());
                        break;
                }
            }
            //Challenges Seite 2
            else if (e.getView().getTitle().equalsIgnoreCase("Challenges §7» §8Page 2")) {
                switch (slot) {
                    case 10:
                        if (e.isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_BIOME, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_BIOME, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME)));
                                Utils.sendChange("§6Force Biome", "§7is §cdisabled");
                            } else {
                                ForceBiome forceBiome = new ForceBiome();
                                SettingsModes.challenge.put(SettingsItems.ItemType.FORCE_BIOME, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.FORCE_BIOME, SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME)));
                                Utils.sendChange("§6Force Biome", "§7is §aenabled");
                                forceBiome.start();
                            }
                        } else if (e.isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.FORCE_BIOME));
                        }
                        break;
                    case 11:
                        if (e.getClick().isLeftClick()) {
                            if (SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.challenge.put(SettingsItems.ItemType.RANDOM_DROPS, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.RANDOM_DROPS, SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS)));
                                Utils.sendChange("§6Random Drops", "§7is §cdisabled");
                            } else {
                                SettingsModes.challenge.put(SettingsItems.ItemType.RANDOM_DROPS, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.RANDOM_DROPS, SettingsModes.challenge.get(SettingsItems.ItemType.RANDOM_DROPS)));
                                Utils.sendChange("§6Random Drops", "§7is §aenabled");
                                RandomDrops.start();
                            }
                        } else if (e.getClick().isRightClick()) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.RANDOM_DROPS));
                        }
                        break;
                    case 12:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER)));
                            Utils.sendTitle("§6Vanish Blocks", "§7is §cdisabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BLOCKS_WITH_PLAYER, SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER)));
                            Utils.sendTitle("§6Vanish Blocks", "§7is §aenabled");
                        }
                        break;
                    case 27:
                        p.openInventory(Settings.getChallengesMenu());
                        break;
                }
            }
            //OtherMenu
            else if (e.getView().getTitle().equalsIgnoreCase(Settings.getOtherMenuName())) {
                switch (slot) {
                    case 1:
                        p.openInventory(Settings.TimerMenu());
                        break;
                    case 10:
                        if (e.getClick().isRightClick()) {
                            p.openInventory(Settings.TimerMenu());
                            break;
                        } else if (e.getClick().isLeftClick()) {
                            if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.settings.put(SettingsItems.ItemType.TIMER, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
                                Utils.sendChange("§6The Timer", "§cis disabled");
                                Timer.pause(false);
                                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(" "));
                            } else {
                                SettingsModes.settings.put(SettingsItems.ItemType.TIMER, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(10, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
                                Utils.sendChange("§6The Timer", "§ais enabled");
                            }
                        }
                        break;
                    case 11:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.SENDTITLE, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SENDTITLE, SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE)));
                            Utils.sendChange("§6Titel by Changes", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.SENDTITLE, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(11, SettingsItems.getMenuItem(SettingsItems.ItemType.SENDTITLE, SettingsModes.settings.get(SettingsItems.ItemType.SENDTITLE)));
                        }
                        break;
                    case 12:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.DMGALERT, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.DMGALERT, SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT)));
                            Utils.sendChange("§6Damage in the Chat", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.DMGALERT, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(12, SettingsItems.getMenuItem(SettingsItems.ItemType.DMGALERT, SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT)));
                            Utils.sendChange("§6Damage in the Chat", "§7is §cdisabled");
                        }
                        break;
                    case 13:
                        if (SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.KEEP_INVENTORY, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(13, SettingsItems.getMenuItem(SettingsItems.ItemType.KEEP_INVENTORY, SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY)));
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setGameRule(GameRule.KEEP_INVENTORY, true);
                            }
                            Utils.sendChange("§6Keep Inventory", "§7is §aenabled");
                        } else {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.KEEP_INVENTORY, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(13, SettingsItems.getMenuItem(SettingsItems.ItemType.KEEP_INVENTORY, SettingsModes.gamerule.get(SettingsItems.ItemType.KEEP_INVENTORY)));
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setGameRule(GameRule.KEEP_INVENTORY, false);
                            }
                            Utils.sendChange("§6Keep Inventory", "§7is §cdisabled");
                        }
                        break;
                    case 14:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.SHOWCOORDSONDEAETH) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsModes.settings.get(SettingsItems.ItemType.SHOWCOORDSONDEAETH)));
                            Utils.sendChange("§6Deathposition in the Chat", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.SHOWCOORDSONDEAETH, SettingsModes.settings.get(SettingsItems.ItemType.SHOWCOORDSONDEAETH)));
                            Utils.sendChange("§6Deathposition in the Chat", "§7is §cdisabled");
                        }
                        break;
                    case 15:
                        if (SettingsModes.gamerule.get(SettingsItems.ItemType.PVP) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.PVP, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.PVP, SettingsModes.gamerule.get(SettingsItems.ItemType.PVP)));
                            Utils.sendChange("§6PVP", "§7is §aenabled");
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setPVP(true);
                            }
                        } else {
                            SettingsModes.gamerule.put(SettingsItems.ItemType.PVP, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.PVP, SettingsModes.gamerule.get(SettingsItems.ItemType.PVP)));
                            Utils.sendChange("§6PVP", "§7is §cdisabled");
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setPVP(false);
                            }
                        }
                        break;
                    case 16:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.RESETCONFIRM) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.RESETCONFIRM, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.RESETCONFIRM, SettingsModes.settings.get(SettingsItems.ItemType.RESETCONFIRM)));
                            Utils.sendChange("§6/reset confirm", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.RESETCONFIRM, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.RESETCONFIRM, SettingsModes.settings.get(SettingsItems.ItemType.RESETCONFIRM)));
                            Utils.sendChange("§6/reset confirm", "§7is §cdisabled");
                        }
                        break;
                    //zurück, weiter
                    case 18:
                        p.openInventory(Settings.getMenu());
                        break;
                    case 26:
                        p.openInventory(Settings.getOtherMenu2());
                        break;
                }
            }
            //Seite 2
            else if (e.getView().getTitle().equalsIgnoreCase("Other Settings §7» §8Page 2")) {
                switch (slot) {
                    case 10:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.ENDER_DRAGON, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ENDER_DRAGON, SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON)));
                            Utils.sendChange("§dEnderdragon", "§7is §aenabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.ENDER_DRAGON, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ENDER_DRAGON, SettingsModes.challenge.get(SettingsItems.ItemType.ENDER_DRAGON)));
                            Utils.sendChange("§dEnderdragon", "§7is §cdisabled");
                        }
                        break;
                    case 11:
                        if (SettingsModes.challenge.get(SettingsItems.ItemType.WITHER) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.challenge.put(SettingsItems.ItemType.WITHER, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.WITHER, SettingsModes.challenge.get(SettingsItems.ItemType.WITHER)));
                            Utils.sendChange("§0Wither", "§7is §aenabled");
                        } else {
                            SettingsModes.challenge.put(SettingsItems.ItemType.WITHER, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.WITHER, SettingsModes.challenge.get(SettingsItems.ItemType.WITHER)));
                            Utils.sendChange("§0Wither", "§7is §cdisabled");
                        }
                        break;
                    case 12:
                        if (SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.scoreboard.put(SettingsItems.ItemType.TABHP, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TABHP, SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP)));
                            Utils.sendChange("§6TABHP", "§7is §adisabled");
                        } else {
                            SettingsModes.scoreboard.put(SettingsItems.ItemType.TABHP, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TABHP, SettingsModes.scoreboard.get(SettingsItems.ItemType.TABHP)));
                            Utils.sendChange("§6TABHP", "§7is §cenabled");
                        }
                        break;
                    case 13:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.HARDCORE, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.HARDCORE, SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE)));
                            Utils.sendChange("§4Hardcore", "§7is §aenabled");
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setHardcore(true);
                            }
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.HARDCORE, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.HARDCORE, SettingsModes.settings.get(SettingsItems.ItemType.HARDCORE)));
                            Utils.sendChange("§4Hardcore", "§7is §cdisabled");
                            for (World wl : Bukkit.getWorlds()) {
                                wl.setHardcore(false);
                            }
                        }
                        break;
                    case 14:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.BUNGEECORD, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BUNGEECORD, SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD)));
                            Utils.sendChange("§6BungeeCord", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.BUNGEECORD, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BUNGEECORD, SettingsModes.settings.get(SettingsItems.ItemType.BUNGEECORD)));
                            Utils.sendChange("§6BungeeCord", "§7is §cdisabled");
                        }
                        break;
                    case 15:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.BACKUP) == SettingsItems.ItemState.DISABLED) {
                            if (e.getClick().equals(ClickType.LEFT)) {
                                SettingsModes.settings.put(SettingsItems.ItemType.BACKUP, SettingsItems.ItemState.ENABLED);
                                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, 1);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
                                Utils.sendChange("§6Backup", "§6every Hour");
                            } else {
                                return;
                            }
                        } else if (SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) == 1) {
                            if (e.getClick().equals(ClickType.LEFT)) {
                                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, 2);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
                                Utils.sendChange("§6Backup", "§7all §6" + SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) + " Hours");
                            } else if (e.getClick().equals(ClickType.RIGHT)) {
                                SettingsModes.settings.put(SettingsItems.ItemType.BACKUP, SettingsItems.ItemState.DISABLED);
                                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, 0);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
                                Utils.sendChange("§6Backup", "§7is §cdisabled");
                            }
                        } else {
                            if (e.getClick().equals(ClickType.LEFT)) {
                                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) + 1);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
                                if (SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) == 1) {
                                    Utils.sendChange("§6Backup", "§6every Hour");
                                } else {
                                    Utils.sendChange("§6Backup", "§7all §6" + SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) + " Hours");
                                }
                            } else if (e.getClick().equals(ClickType.RIGHT)) {
                                SettingsModes.ints.put(SettingsItems.ItemType.BACKUP, SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) - 1);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKUP, SettingsModes.settings.get(SettingsItems.ItemType.BACKUP)));
                                if (SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) == 1) {
                                    Utils.sendChange("§6Backup", "§6every Hour");
                                } else {
                                    Utils.sendChange("§6Backup", "§7all §6" + SettingsModes.ints.get(SettingsItems.ItemType.BACKUP) + " Hours");
                                }
                            }
                        }
                        break;
                    case 16:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.AFK) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.AFK, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.AFK, SettingsModes.settings.get(SettingsItems.ItemType.AFK)));
                            Utils.sendChange("§6AFK-Trigger", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.AFK, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.AFK, SettingsModes.settings.get(SettingsItems.ItemType.AFK)));
                            Utils.sendChange("§6AFK-Trigger", "§7is §cdisabled");
                        }
                        break;
                    //zurück
                    case 18:
                        p.openInventory(Settings.getOtherMenu());
                        break;
                    case 26:
                        p.openInventory(Settings.getOtherMenu3());
                        break;
                }
            } else if (e.getView().getTitle().equalsIgnoreCase("Other Settings §7» §8Page 3")) {
                switch (slot) {
                    case 10:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.BACKPACK) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.BACKPACK, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKPACK, SettingsModes.settings.get(SettingsItems.ItemType.BACKPACK)));
                            Utils.sendChange("§6Backpack", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.BACKPACK, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.BACKPACK, SettingsModes.settings.get(SettingsItems.ItemType.BACKPACK)));
                            Utils.sendChange("§6Backpack", "§7is §cdisabled");
                        }
                        break;
                    case 11:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.STATS) == SettingsItems.ItemState.DISABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.STATS, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.STATS, SettingsModes.settings.get(SettingsItems.ItemType.STATS)));
                            Utils.sendChange("§6Stats", "§7is §aenabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.STATS, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.STATS, SettingsModes.settings.get(SettingsItems.ItemType.STATS)));
                            Utils.sendChange("§6Stats", "§7is §cdisabled");
                        }
                        break;
                    case 12:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.UPDATE_CHECKER, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.UPDATE_CHECKER, SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER)));
                            Utils.sendChange("§6Update Checker", "§7is §cdisabled");
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.UPDATE_CHECKER, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.UPDATE_CHECKER, SettingsModes.settings.get(SettingsItems.ItemType.UPDATE_CHECKER)));
                            Utils.sendChange("§6Update Checker", "§7is §aenabled");
                        }
                        break;
                    case 18:
                        p.openInventory(Settings.getOtherMenu2());
                        break;
                }
            }
            //Timer Menu
            else if (e.getView().getTitle().equalsIgnoreCase("Timer Settings")) {
                switch (slot) {
                    case 11:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() + 3600 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 3600);
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() + 3600 * 10 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 3600 * 10);
                        }
                        Utils.sendChange("§6The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 13:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() + 60 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 60);
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() + 60 * 10 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 60 * 10);
                        }
                        Utils.sendChange("§6The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 15:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() + 1 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 1);
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() + 10 < 0)) {
                            Timer.setCurrentTime(Timer.getCurrentTime() + 10);
                        }
                        Utils.sendChange("§6The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 29:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() - 3600 < 0)) {
                            if (Timer.getCurrentTime() - 3600 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 3600);
                            }
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() - 3600 * 10 < 0)) {
                            if (Timer.getCurrentTime() - 3600 * 10 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 3600 * 10);
                            }
                        }
                        Utils.sendChange("§6The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 31:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() - 60 < 0)) {
                            if (Timer.getCurrentTime() - 60 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 60);
                            }
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() - 60 * 10 < 0)) {
                            if (Timer.getCurrentTime() - 60 * 10 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 60 * 10);
                            }
                        }
                        Utils.sendChange("§The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 33:
                        if (e.getClick() == ClickType.LEFT && !(Timer.getCurrentTime() - 1 < 0)) {
                            if (Timer.getCurrentTime() - 1 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 1);
                            }
                        } else if (e.getClick() == ClickType.SHIFT_LEFT && !(Timer.getCurrentTime() - 10 < 0)) {
                            if (Timer.getCurrentTime() - 10 >= 0) {
                                Timer.setCurrentTime(Timer.getCurrentTime() - 10);
                            }
                        }
                        Utils.sendChange("§6The Timer", "§7set to " + Timer.ConvertTimerTime(Timer.getCurrentTime(), "§6") + "§7");
                        Timer.firststart = false;
                        e.getClickedInventory().setItem(11, Settings.ButtonPlus("hours"));
                        e.getClickedInventory().setItem(13, Settings.ButtonPlus("min"));
                        e.getClickedInventory().setItem(15, Settings.ButtonPlus("sec"));
                        e.getClickedInventory().setItem(20, Settings.Clock("hours"));
                        e.getClickedInventory().setItem(22, Settings.Clock("min"));
                        e.getClickedInventory().setItem(24, Settings.Clock("sec"));
                        e.getClickedInventory().setItem(29, Settings.ButtonMinus("hours"));
                        e.getClickedInventory().setItem(31, Settings.ButtonMinus("min"));
                        e.getClickedInventory().setItem(33, Settings.ButtonMinus("sec"));
                        break;
                    case 47:
                        if (SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.settings.put(SettingsItems.ItemType.TIMER, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
                            Utils.sendChange("§6The Timer", "§cis disabled");
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("hi"));
                            }
                        } else {
                            SettingsModes.settings.put(SettingsItems.ItemType.TIMER, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.TIMER, SettingsModes.settings.get(SettingsItems.ItemType.TIMER)));
                            Utils.sendChange("§6The Timer", "§ais enabled");
                        }
                        break;
                    case 49:
                        if (SettingsModes.timer.get(SettingsItems.ItemType.REVERSE) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.timer.put(SettingsItems.ItemType.REVERSE, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.REVERSE, SettingsModes.timer.get(SettingsItems.ItemType.REVERSE)));
                            Utils.sendChange("§6The Timer", "§7lrun now §normal");
                        } else {
                            SettingsModes.timer.put(SettingsItems.ItemType.REVERSE, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.REVERSE, SettingsModes.timer.get(SettingsItems.ItemType.REVERSE)));
                            Utils.sendChange("§6The Timer", "§7run now §cbackwards");
                        }
                        break;
                    case 51:
                        if (SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART) == SettingsItems.ItemState.ENABLED) {
                            SettingsModes.timer.put(SettingsItems.ItemType.AUTOSTART, SettingsItems.ItemState.DISABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.AUTOSTART, SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART)));
                            Utils.sendChange("§6Automatic Timer", "§7is §cdisabled");
                        } else {
                            SettingsModes.timer.put(SettingsItems.ItemType.AUTOSTART, SettingsItems.ItemState.ENABLED);
                            e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.AUTOSTART, SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART)));
                            Utils.sendChange("§6Automatic Timer", "§7is §aenabled");
                        }
                        break;
                    case 45:
                        p.openInventory(Settings.getOtherMenu());
                        break;
                }
            } else if (e.getView().getTitle().equalsIgnoreCase("Projects")) {
                switch (slot) {
                    case 10:
                        if (e.getClick() == ClickType.LEFT) {
                            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_ITEMS, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_ITEMS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS)));
                                Utils.sendChange("§6All Items", "§7is §cdisabled");
                            } else {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_ITEMS, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_ITEMS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_ITEMS)));
                                Utils.sendChange("§6All Items", "§7is §aenabled");
                                AllItems.start();
                            }
                        } else if (e.getClick() == ClickType.RIGHT) {
                            p.openInventory(Settings.resetPrompt("All Items"));
                        }
                        break;
                    case 11:
                        if (e.getClick() == ClickType.LEFT) {
                            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_MOBS, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_MOBS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS)));
                                Utils.sendChange("§6All Mobs", "§7is §cdisabled");
                            } else {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_MOBS, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_MOBS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_MOBS)));
                                Utils.sendChange("§6All Mobs", "§7is §aenabled");
                                AllMobs.start();
                            }
                        } else if (e.getClick() == ClickType.RIGHT) {
                            p.openInventory(Settings.resetPrompt("All Mobs"));
                            //Änderung mit Alle Mobs zu All Mobs geg. können Fehler auftreten
                        }
                        break;
                    case 12:
                        if (e.getClick().isLeftClick()) {
                            if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS) == SettingsItems.ItemState.ENABLED) {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_DEATHS, SettingsItems.ItemState.DISABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_DEATHS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS)));
                                Utils.sendChange("§6All Deathmessages", "§7is §cdisabled");
                            } else {
                                SettingsModes.projects.put(SettingsItems.ItemType.ALL_DEATHS, SettingsItems.ItemState.ENABLED);
                                e.getClickedInventory().setItem(slot, SettingsItems.getMenuItem(SettingsItems.ItemType.ALL_DEATHS, SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS)));
                                Utils.sendChange("§6All Deathmessages", "§7is §aenabled");
                                AllDeathMessages.start();
                            }
                        } else if (e.getClick().isRightClick()) {
                            p.openInventory(Settings.resetPrompt("All Deaths"));
                        }
                        break;
                    case 27:
                        p.openInventory(Settings.getMenu());
                        break;
                }
                //ResetPrompt
            } else if (e.getView().getTitle().contains("reset?")) {
                switch (slot) {
                    case 11:
                        if (title.contains("All Items")) {
                            Config.resetProject(SettingsItems.ItemType.ALL_ITEMS);
                            Utils.sendChange("§6Colect all Items", "§7is §creset");
                        } else if (title.contains("All Mobs")) {
                            Config.resetProject(SettingsItems.ItemType.ALL_MOBS);
                            Utils.sendChange("§6Kill all Mobs ", "§7is §creset");
                        } else if (title.contains("Random Drops")) {
                            Config.setToNull("random_drops.drops");
                            RandomDrops.drops.clear();
                            RandomDrops.start();
                            Utils.sendChange("§6Random Drops", "§7is §creset");
                        } else if (title.contains("All Deaths")) {
                            Config.setToNull("alldeaths.messages");
                            Config.setToNull("alldeaths.current");
                            Config.resetProject(SettingsItems.ItemType.ALL_DEATHS);
                            Utils.sendTitle("§6All Deathmessages", "§7is §creset");
                        }
                        p.closeInventory();
                        break;
                    case 15:
                        if (title.contains("All Items") || title.contains("All Mobs") || title.contains("All Deaths")) {
                            p.openInventory(Settings.ProjectMenu());
                        } else if (title.contains("Random Drops")) {
                            p.openInventory(SettingsItems.getMenuInv(SettingsItems.ItemType.RANDOM_DROPS));
                        }
                        break;
                }
            }
            //Moboverview
            else if (e.getView().getTitle().equalsIgnoreCase("Moboverview §7» §8Page 1")) {
                switch (slot) {
                    case 45:
                        p.closeInventory();
                        break;
                    case 53:
                        p.openInventory(MobsCommand.Moboverview2());
                }
            } else if (e.getView().getTitle().equalsIgnoreCase("Moboverview §7» §8Page 2")) {
                if (slot == 45) {
                    p.openInventory(MobsCommand.Moboverview());
                }
            }

            //Challenge Settings
            else if (e.getView().getTitle().contains("Settings: §c")) {
                String type = e.getView().getTitle().replace("§8Settings: §c", "");
                switch (slot) {
                    case 11:
                        if (type.equalsIgnoreCase("Trafficlight-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.min_green += 60;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.min_green > 60) {
                                    Trafficlight.min_green -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimum Greentime", "\n§9Description:\nThe minimum Time, that the Trafficlight is green.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-CLick§8] §7- 1 Minute\n \nAt the Moment: §6" + Trafficlight.min_green / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Random Drops")) {
                            RandomDrops.allRandom = !RandomDrops.allRandom;
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6All Drops Random", "\n§9Description:\nEvery Block have a random Drop.\n\n§8[§9Click§8] §7On / Off\n\nAt the Moment: §6" + (!RandomDrops.allRandom ? "§8[§4Disabled§8]" : "§8[§2Enabeled§8]")));
                        } else if (type.equalsIgnoreCase("Force Block")) {
                            if (e.isLeftClick()) {
                                ForceBlock.FreeTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceBlock.FreeTimeMin > 60) {
                                    ForceBlock.FreeTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimum Statementinterval", "\n§9Description:\nThe minimum Time, in there the Players become no Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBlock.FreeTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("The Floor is Lava")) {
                            if (e.isLeftClick()) {
                                SettingsModes.MagmaTime ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.MagmaTime > 0) {
                                    SettingsModes.MagmaTime --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.MAGMA_BLOCK, "§6Magma", "\n§9Description:\nThe time before the Floor \nreplace with Magma.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + SettingsModes.MagmaTime + " Seconds"));
                        } else if (type.equalsIgnoreCase("Force Mob")) {
                            if (e.isLeftClick()) {
                                ForceMob.FreeTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceMob.FreeTimeMin > 60) {
                                    ForceMob.FreeTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimum Statementinterval", "\n§9Description:\nThe minimum Time, in there the Players become no Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceMob.FreeTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Height")) {
                            if (e.isLeftClick()) {
                                ForceHeight.FreeTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceHeight.FreeTimeMin > 60) {
                                    ForceHeight.FreeTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimum Statementinterval", "\n§9Description:\nThe minimum Time, in there the Players become no Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceHeight.FreeTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Biome")) {
                            if (isLeftClick) {
                                ForceBiome.FreeTimeMin += 60;
                            } else if (isRightClick) {
                                if (ForceBiome.FreeTimeMin > 60) {
                                    ForceBiome.FreeTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Minimum Statementinterval", "\n§9Description:\nThe minimum Time, in there the Players become no Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBiome.FreeTimeMin / 60 + " Minutes"));
                        }
                        break;
                    case 13:
                        if (type.equalsIgnoreCase("Speed")) {
                            if (e.isLeftClick()) {
                                SettingsModes.speed ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.speed > 1) {
                                    SettingsModes.speed --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Speed", "\n§9Description:\nThe Speed, that will have all Mobs and Players.\n \n§8[§9Left-Click§8] §7 + 1\n§8[§9Right-Click§8] §7 - 1\n \n§7At the Moment: §6" + SettingsModes.speed));
                        } else if (type.equalsIgnoreCase("Trafficlight-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.min_yellow ++;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.min_yellow > 1) {
                                    Trafficlight.min_yellow --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.YELLOW_CONCRETE, "§6Minimum Yellowtime", "\n§9Description:\nThe minimum Time, that the Trafficlight is §eYellow.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + Trafficlight.min_yellow + " Seconds"));
                        } else if (type.equalsIgnoreCase("Walk = Damage")) {
                            if (e.isLeftClick()) {
                                SettingsModes.distanceToGetDamaged ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.distanceToGetDamaged > 1) {
                                    SettingsModes.distanceToGetDamaged --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Blocks", "\n§9Description:\nThe Number of Blocks, that a Player must walk to become damage.\n\n§8[§9Left-Click§8] §7+ 1 Block\n§8[§9Right-Click§8] §7- 1 Block\n\nAt the Moment: §6" + SettingsModes.distanceToGetDamaged + " §7Blocks"));
                        } else if (type.equalsIgnoreCase("Mirror Damage")) {
                            if (e.isLeftClick()) {
                                if (SettingsModes.probabilityToMirrorDamage < 100) {
                                    SettingsModes.probabilityToMirrorDamage += 10;
                                }
                            } else if (e.isRightClick()) {
                                if (SettingsModes.probabilityToMirrorDamage > 10) {
                                    SettingsModes.probabilityToMirrorDamage -= 10;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Probability", "\n§9Discription:\nThe Probability, that the Damage are Mirrored.\n\n§8[§9Left-Click§8] §7+ 10%\n§8[§9Right-Click§8] §7- 10%\n\nAt the Moment: §6" + SettingsModes.probabilityToMirrorDamage + "%"));
                        } else if (type.equalsIgnoreCase("Bedrock-Wall")) {
                            if (e.isLeftClick()) {
                                SettingsModes.BedrockDelay ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.BedrockDelay > 1) {
                                     SettingsModes.BedrockDelay --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BEDROCK, "§6Delays", "\n§9Discription:\nThe Delay, that the Bedrock to the Players have.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + SettingsModes.BedrockDelay + " Seconds"));
                        } else if (type.equalsIgnoreCase("The Floor is Lava")) {
                            if (e.isLeftClick()) {
                                SettingsModes.LavaTime ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.LavaTime > 0) {
                                    SettingsModes.LavaTime --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.LAVA_BUCKET, "§6Lava", "\n§9Description:\nThe Time before the Floor go to Lava.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + SettingsModes.LavaTime + " Seconds"));
                        }
                        break;
                    case 15:
                        if (type.equalsIgnoreCase("Ampel-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.min_red ++;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.min_red > 1) {
                                    Trafficlight.min_red --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.RED_CONCRETE, "§6Minimale Rotzeit", "\n§9Description:\nThe minimum Time the Trafficlight is §cRed.\n\n§8[§9Left-Click§8] §7 + 1 Second\n§8[§9Right-Click§8] §7- 1 Seconds\n\nAt the Moment: §6" + Trafficlight.min_red + " Seconds"));
                        } else if (type.equalsIgnoreCase("Random Drops")) {
                            p.openInventory(Settings.resetPrompt("Random Drops"));
                        } else if (type.equalsIgnoreCase("Force Block")) {
                            if (e.isLeftClick()) {
                                ForceBlock.SearchTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceBlock.SearchTimeMin > 60) {
                                    ForceBlock.SearchTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimum Searchtime", "\n§9Description:\nThe Minimum Time that the Player have to finish the Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBlock.SearchTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("The Floor is Lava")) {
                            if (e.isLeftClick()) {
                                SettingsModes.ResetTime ++;
                            } else if (e.isRightClick()) {
                                if (SettingsModes.ResetTime > 0) {
                                    SettingsModes.ResetTime --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GRASS_BLOCK, "§6Reset", "\n§9Description:\nThe Time, that the Lava return to the normal Block.\n§8[§9Left-Click§8] §7+ 1 Second\n§8[Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + SettingsModes.ResetTime + " Seconds"));
                        } else if (type.equalsIgnoreCase("Force Mob")) {
                            if (e.isLeftClick()) {
                                ForceMob.SearchTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceMob.SearchTimeMin > 60) {
                                    ForceMob.SearchTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimum Searchtime", "\n§9Description:\nThe minimum Time, where the player finish the Statment.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceMob.SearchTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Height")) {
                            if (e.isLeftClick()) {
                                ForceHeight.SearchTimeMin += 60;
                            } else if (e.isRightClick()) {
                                if (ForceHeight.SearchTimeMin > 60) {
                                    ForceHeight.SearchTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimum Searchtime", "\n§9Description:\nThe minimum Time, where the player finish the Statment.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceHeight.SearchTimeMin / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Biome")) {
                            if (isLeftClick) {
                                ForceBiome.SearchTimeMin += 60;
                            } else if (isRightClick) {
                                if (ForceBiome.SearchTimeMin > 60) {
                                    ForceBiome.SearchTimeMin -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Minimum Searchtime", "\n§9Description:\nThe minimum Time, where the player finish the Statment.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBiome.SearchTimeMin / 60 + " Minutes"));
                        }
                        break;
                    case 18:
                        if (type.equalsIgnoreCase("Speed") || type.equalsIgnoreCase("Walk = Damage") || type.equalsIgnoreCase("Mirror Damage") || type.equalsIgnoreCase("Bedrock-Wall") || type.equalsIgnoreCase("The Floor is Lava")) {
                            p.openInventory(Settings.getChallengesMenu());
                        } else if (type.equalsIgnoreCase("Random Drops")) {
                            p.openInventory(Settings.getChallengesMenu2());
                        }
                        break;
                    case 20:
                        if (type.equalsIgnoreCase("Trafficlight-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.max_green += 60;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.max_green > 60) {
                                    Trafficlight.max_green -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximum Greentime", "\n§9Description:\nThe maximum Time, the Trafficlight can be §aGreen.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n \nAt the Moment: §6" + Trafficlight.max_green / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Block")) {
                            if (e.isLeftClick()) {
                                ForceBlock.FreeTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceBlock.FreeTimeMax > 60) {
                                    ForceBlock.FreeTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximum Statementinterval", "\n§9Description:\nThe Maximum Time where Players didn't get an Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBlock.FreeTimeMax / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Mob")) {
                            if (e.isLeftClick()) {
                                ForceMob.FreeTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceMob.FreeTimeMax > 60) {
                                    ForceMob.FreeTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximum Statementinterval", "\n§9Description:\nThe Maximum Time where Players didn't get an Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceMob.FreeTimeMax / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Height")) {
                            if (e.isLeftClick()) {
                                ForceHeight.FreeTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceHeight.FreeTimeMax > 60) {
                                    ForceHeight.FreeTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximum Statementinterval", "\n§9Description:\nThe Maximum Time where Players didn't get an Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceHeight.FreeTimeMax / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Biome")) {
                            if (isLeftClick) {
                                ForceBiome.FreeTimeMax += 60;
                            } else if (isRightClick) {
                                if (ForceBiome.FreeTimeMax > 60) {
                                    ForceBiome.FreeTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.BLUE_CONCRETE, "§6Maximum Statementinterval", "\n§9Description:\nThe Maximum Time where Players didn't get an Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBiome.FreeTimeMax / 60 + " Minutes"));
                        }
                        break;
                    case 22:
                        if (type.equalsIgnoreCase("Ampel-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.max_yellow ++;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.max_yellow > 1) {
                                    Trafficlight.max_yellow --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.YELLOW_CONCRETE, "§6Maximum Yellowtime", "\n§9Description:\nThe maximum Time, the Trafficlight is §eYellow.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + Trafficlight.max_yellow + " Seconds"));
                        }
                        break;
                    case 24:
                        if (type.equalsIgnoreCase("Ampel-Challenge")) {
                            if (e.isLeftClick()) {
                                Trafficlight.max_red ++;
                            } else if (e.isRightClick()) {
                                if (Trafficlight.max_red > 1) {
                                    Trafficlight.max_red --;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.RED_CONCRETE, "§6Maximum Redtime", "\n§9Description:\nThe maximum Time, the Trafficlight is §cRed.\n\n§8[§9Left-Click§8] §7+ 1 Second\n§8[§9Right-Click§8] §7- 1 Second\n\nAt the Moment: §6" + Trafficlight.max_red + " Seconds"));
                        } else if (type.equalsIgnoreCase("Force Block")) {
                            if (e.isLeftClick()) {
                                ForceBlock.SearchTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceBlock.SearchTimeMax > 60) {
                                    ForceBlock.SearchTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximum Searchtime", "\n§9Description:\nThe Maximum Time a Player have to finish the Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBlock.SearchTimeMax / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Mob")) {
                            if (e.isLeftClick()) {
                                ForceMob.SearchTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceMob.SearchTimeMax > 60) {
                                    ForceMob.SearchTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximum Searchtime", "\n§9Description:\nThe Maximum Time a Player have to finish the Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceMob.SearchTimeMax / 60 + " Minuten"));
                        } else if (type.equalsIgnoreCase("Force Height")) {
                            if (e.isLeftClick()) {
                                ForceHeight.SearchTimeMax += 60;
                            } else if (e.isRightClick()) {
                                if (ForceHeight.SearchTimeMax > 60) {
                                    ForceHeight.SearchTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximum Searchtime", "\n§9Description:\nThe Maximum Time a Player have to finish the Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceHeight.SearchTimeMax / 60 + " Minutes"));
                        } else if (type.equalsIgnoreCase("Force Biome")) {
                            if (isLeftClick) {
                                ForceBiome.SearchTimeMax += 60;
                            } else if (isRightClick) {
                                if (ForceBiome.SearchTimeMax > 60) {
                                    ForceBiome.SearchTimeMax -= 60;
                                }
                            }
                            e.getClickedInventory().setItem(slot, Settings.createItemStack(Material.GREEN_CONCRETE, "§6Maximum Searchtime", "\n§9Description:\nThe Maximum Time a Player have to finish the Statement.\n\n§8[§9Left-Click§8] §7+ 1 Minute\n§8[§9Right-Click§8] §7- 1 Minute\n\nAt the Moment: §6" + ForceBiome.SearchTimeMax / 60 + " Minutes"));
                        }
                        break;
                    case 27:
                        if (type.equalsIgnoreCase("Trafficlight-Challenge") || type.equalsIgnoreCase("Force Block") || type.equalsIgnoreCase("Force Mob") || type.equalsIgnoreCase("Force Height")) {
                            p.openInventory(Settings.getChallengesMenu());
                            break;
                        } else if (type.equalsIgnoreCase("Force Biome")) {
                            p.openInventory(Settings.getChallengesMenu2());
                            break;
                        }
                }
            }
        }

    }
}
