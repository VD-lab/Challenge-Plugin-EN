package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import static java.lang.Math.round;


public class DamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (SettingsModes.settings.get(SettingsItems.ItemType.GEITEILTEHERZEN) == SettingsItems.ItemState.ENABLED) {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    pl.setHealth(p.getHealth());
                }
            }
            if (Timer.state == Timer.TimerState.PAUSED && SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                e.setCancelled(true);
            }
            String DamageCause;
            double Damage = e.getDamage();

            if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                DamageCause = "Explosion";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
                DamageCause = "Contact";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.CRAMMING) {
                DamageCause = "Cramming";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.DRAGON_BREATH) {
                DamageCause = "Dragonbreath";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                DamageCause = "Drowning";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                DamageCause = "Explosion";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.FALL || e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                DamageCause = "Fall Damage";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                DamageCause = "Fire";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {
                DamageCause = "Hot Floor";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                DamageCause = "Lava";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
                DamageCause = "Lightning";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.MAGIC) {
                DamageCause = "Magic";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.MELTING) {
                DamageCause = "Melting";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.POISON) {
                DamageCause = "Poison";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                DamageCause = "Projectile";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.STARVATION) {
                DamageCause = "Starvation";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
                DamageCause = "Suffocation";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.THORNS) {
                DamageCause = "Thorns";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                DamageCause = "Void";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.WITHER) {
                DamageCause = "Wither";
            } else if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                DamageCause = "Attack";
            } else {
                DamageCause = "Unknow";
            }
            if (Timer.state != Timer.TimerState.PAUSED && SettingsModes.settings.get(SettingsItems.ItemType.DMGALERT) == SettingsItems.ItemState.ENABLED && e.getFinalDamage() != 0 && DamageCause != "Unbekannt") {
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    pl.sendMessage("§8[§6Damage§8] §3§l" + p.getName() + "§7 have became from §3§l" + DamageCause + " §6" + Damage / 2 + " Heath§7 Damage.");
                }
            }

            if (SettingsModes.challenge.get(SettingsItems.ItemType.FLYONDAMAGE) == SettingsItems.ItemState.ENABLED) {
                if (Timer.state == Timer.TimerState.RUNNING || SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.DISABLED) {
                    if (!(DamageCause.equals("Unbekannt"))) {
                        e.setCancelled(true);
                        p.setVelocity(new Vector(0, 3, 0));
                        p.damage(e.getDamage());
                    }
                }
            }
        }
    }
}
