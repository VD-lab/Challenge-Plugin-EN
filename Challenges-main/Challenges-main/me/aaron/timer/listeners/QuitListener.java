package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import me.aaron.timer.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

import static me.aaron.timer.utils.Permissions.ranks;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§c« §f" + Permissions.getPrefix(Permissions.getRank(p)) + "§f" + p.getName());
        MoveListener.lastMovement.remove(p);
        if (Bukkit.getOnlinePlayers().size() == 1) {
            if (Timer.state == Timer.TimerState.RUNNING && SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
                Timer.pause(false);
                Bukkit.getLogger().info("§cThe Timer is Stopped, because nobody was on the Server.");
            }
        }
        try {
            Config.set("permissions." + p.getUniqueId(), ranks.get(p).name());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ranks.remove(p);
    }
}
