package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class TriggerListener implements Listener {
    @EventHandler
    public void onTrigger(EntityTargetEvent e) {
        if (Timer.state == Timer.TimerState.PAUSED) {
            e.setCancelled(true);
        }
    }
}
