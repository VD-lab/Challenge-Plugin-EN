package me.aaron.timer.listeners;

import me.aaron.timer.utils.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class BucketListener implements Listener {
    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent e){
        Player p = e.getPlayer();

        if (Permissions.getRank(p) == Permissions.Rank.GUEST) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent e) {
        Player p = e.getPlayer();

        if (Permissions.getRank(p) == Permissions.Rank.GUEST) {
            e.setCancelled(true);
        }
    }
}
