package me.aaron.timer.listeners;

import me.aaron.timer.utils.SettingsItems;
import me.aaron.timer.utils.SettingsModes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageRemover implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            if (SettingsModes.other.get(SettingsItems.ItemType.CANCELLDAMAGE) == SettingsItems.ItemState.ENABLED) {
                e.setCancelled(true);
            }
        }
    }
}
