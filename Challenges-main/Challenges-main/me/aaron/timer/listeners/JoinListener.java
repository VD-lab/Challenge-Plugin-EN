package me.aaron.timer.listeners;

import me.aaron.timer.Main;
import me.aaron.timer.projects.AllDeathMessages;
import me.aaron.timer.utils.ScoreboardManager;
import me.aaron.timer.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String rankString = Config.getString("permissions." + p.getUniqueId());
        Permissions.Rank rank = (rankString == null) ? Permissions.Rank.GUEST : Permissions.Rank.valueOf(rankString);
        Utils.setNewRankPrefix(p, rank);
        Permissions.ranks.put(p, rank);
        MoveListener.lastMovement.put(p, System.currentTimeMillis() * 1000);

        e.setJoinMessage("§a» §f" + Permissions.getPrefix(Permissions.getRank(p)) + "§f" + p.getName());
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(SettingsModes.maxHP);
        p.setHealthScale(SettingsModes.maxHP);

        if (SettingsModes.timer.get(SettingsItems.ItemType.AUTOSTART) == SettingsItems.ItemState.ENABLED) {
            if (Bukkit.getOnlinePlayers().size() == 1) {
                Timer.resume(false);
            }
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.SPEED) == SettingsItems.ItemState.ENABLED) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 30));
        }

        if (SettingsModes.challenge.get(SettingsItems.ItemType.TRAFFICLIGHT) == SettingsItems.ItemState.ENABLED) {
            //trafficlight.addPlayer(p);
        }

        ScoreboardManager.createScoreboard(p);

        if (SettingsModes.challenge.get(SettingsItems.ItemType.FORCEBLOCK) == SettingsItems.ItemState.ENABLED) {
            /*ForceBlock forceBlock = new ForceBlock(Main.getInstance());
            forceBlock.addPlayer(p);*/
        }

        if (Timer.state == Timer.TimerState.PAUSED && SettingsModes.settings.get(SettingsItems.ItemType.TIMER) == SettingsItems.ItemState.ENABLED) {
            p.sendMessage(Main.getPrefix("Timer", "§9INFORMATION: §7The Timer not running.\nUse §9/timer resume"));
        }

        if (SettingsModes.projects.get(SettingsItems.ItemType.ALL_DEATHS) == SettingsItems.ItemState.ENABLED) {
            AllDeathMessages.addPlayer(p);
        }

    }
}
