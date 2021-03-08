package me.aaron.timer.listeners;

import me.aaron.timer.Main;
import me.aaron.timer.challenges.ForceBiome;
import me.aaron.timer.challenges.Trafficlight;
import me.aaron.timer.utils.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class MoveListener implements Listener {
    public static HashMap<Player, Long> lastMovement = new HashMap<>();
    private static HashMap<Player, Location> position = new HashMap<>();
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (SettingsModes.challenge.get(SettingsItems.ItemType.DIRT) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.DIRT && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != (Material.AIR) && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.GRASS) {
                    p.setHealth(0);
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage(" ");
                        pl.sendMessage("§8[§6Dirt§8] §6§l" + p.getName() + " §7stand on §6" + p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
                        pl.sendMessage(" ");
                    }
                }
            }
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT) == SettingsItems.ItemState.ENABLED) {
            if (e.getFrom().getBlock().getLocation() != e.getTo().getBlock().getLocation()) {
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (Trafficlight.currentstate == Trafficlight.TrafficLightState.RED || Trafficlight.currentstate == Trafficlight.TrafficLightState.YELLOW_RED) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendMessage(Main.getPrefix("Traffic Light", "The Player §6§l" + p.getName() + " §7has tried to move when the Traffic Light was §cRed§7."));
                        }
                        p.setHealth(0);
                    }
                }
            }
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.ONEBLOCKONEHEART) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
                    if (position.get(p) == null) {
                        position.put(p, p.getLocation());
                    }
                    if (position.get(p).distance(p.getLocation()) >= SettingsModes.distanceToGetDamaged) {
                        position.put(p, p.getLocation());
                        p.damage(0.001);
                        //p.setHealth(p.getHealth() - new Location(p.getWorld(), e.getFrom().getBlockX(), 0, e.getFrom().getBlockZ()).distance(new Location(p.getWorld(), e.getTo().getBlockX(), 0, e.getTo().getBlockZ())) * 2);
                        p.setHealth(p.getHealth() - 2);
                    }
                }
            }
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                if (e.getFrom().getBlock() != e.getTo().getBlock()) {
                    final Player bp = e.getPlayer();
                    final Block bb = e.getTo().getBlock();
                    if (bp.getGameMode() != GameMode.SPECTATOR && bp.getGameMode() != GameMode.CREATIVE) {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), () -> {
                            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                                if (SettingsModes.challenge.get(SettingsItems.ItemType.BEDROCKWALL)  == SettingsItems.ItemState.ENABLED) {
                                    for (int i = 0; i < 256; i++) {
                                        Location loc = new Location(bp.getWorld(), bb.getLocation().getBlockX(), i, bb.getLocation().getBlockZ());
                                        loc.getBlock().setType(Material.BEDROCK);
                                    }
                                }
                            }
                        }, SettingsModes.BedrockDelay * 20L);
                    }
                }
            }
        }
        if (SettingsModes.challenge.get(SettingsItems.ItemType.THEFLOORISLAVA) == SettingsItems.ItemState.ENABLED) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                if (e.getFrom().getBlock() != e.getTo().getBlock()) {
                    final Player bp = e.getPlayer();
                    final Block bb = bp.getLocation().getBlock().getRelative(BlockFace.DOWN);
                    final Material bt = bb.getType();
                    if (bp.getGameMode() != GameMode.SPECTATOR && bp.getGameMode() != GameMode.CREATIVE) {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), () -> {
                            if (bb.getType() != Material.MAGMA_BLOCK && bb.getType() != Material.LAVA && bb.getType() != Material.AIR && bb.getType() != Material.WATER && bb.getType() != Material.GRASS) {
                                bb.setType(Material.MAGMA_BLOCK);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), () -> {
                                    bb.setType(Material.LAVA);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(Main.class), () -> {
                                        bb.setType(bt);
                                    }, SettingsModes.ResetTime * 20L);
                                }, SettingsModes.LavaTime * 20L);
                            }
                        }, SettingsModes.MagmaTime * 20L);
                    }
                }
            }
        }
        if (SettingsModes.settings.get(SettingsItems.ItemType.AFK) == SettingsItems.ItemState.ENABLED) {
            if (!AFK.afk.contains(p)) {
                AFK.newMovement(p, lastMovement.get(p));
            }
            lastMovement.put(p, System.currentTimeMillis() / 1000);
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_HEIGHT) == SettingsItems.ItemState.ENABLED) {
            Timer.sendTimer(Timer.getCurrentTime());
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCE_BIOME) == SettingsItems.ItemState.ENABLED) {
            Timer.sendTimer(Timer.getCurrentTime());
            for (Player pl : Bukkit.getOnlinePlayers()) {
                if (pl.getLocation().getBlock().getBiome() == ForceBiome.forcedbiome) {
                    ForceBiome forceBiome = new ForceBiome();
                    forceBiome.neededtime = Utils.getRandomInt(ForceBiome.FreeTimeMin, ForceBiome.FreeTimeMax);
                    forceBiome.currenttime = 0;
                    for (Player pl2 : Bukkit.getOnlinePlayers()) {
                        pl2.sendMessage(Main.getPrefix("Force Biome", "§aFinish! §7The Biom §9" + Utils.firstLatterCapitalized(ForceBiome.forcedbiome.toString().replace("_", " ")) + " §7was found by §6" + p.getName() + " §7."));
                    }
                    ForceBiome.forcedbiome = null;
                    break;
                }
            }
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.BLOCKS_WITH_PLAYER) == SettingsItems.ItemState.ENABLED && Permissions.hasPermission(p, Permissions.Rank.USER) && p.getGameMode() == GameMode.SURVIVAL) {
            if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                Chunk chunk = p.getLocation().getChunk();
                Material blockType = p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
                int X = chunk.getX() * 16;
                int Z = chunk.getZ() * 16;

                if (e.getFrom() != e.getTo() && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.BEDROCK) {
                    for (int x = 0; x < 16; x++) {
                        for (int z = 0; z < 16; z++) {
                            for (int y = 0; y < 255; y++) {
                                if (chunk.getWorld().getBlockAt(X + x, y, Z + z).getType() == blockType) {
                                    chunk.getWorld().getBlockAt(X + x, y, Z + z).setType(Material.AIR);
                                }
                            }
                        }
                    }
                    p.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.GLASS);
                }
            }
        }
    }
}
