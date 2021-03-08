package me.aaron.timer.listeners;

import org.bukkit.advancement.Advancement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AdvancementsListener implements Listener {
    @EventHandler
    public void onAdvancment(PlayerAdvancementDoneEvent e) {
        Advancement advancement = e.getAdvancement();
        String adv = advancement.getKey().getKey();
        /*if (SettingsMode.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
            //if (adv.equals("H"))
            Bukkit.broadcastMessage(adv);
        }*/
    }
}
