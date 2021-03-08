package me.aaron.timer.listeners;

import me.aaron.timer.utils.Timer;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PreLoginListener implements Listener {
    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent e) {
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        String name = e.getName();
        banList.getBanEntry(name);
        if (banList.isBanned(name)) {
            String reason = banList.getBanEntry(name).getReason();
            Date unban = banList.getBanEntry(name).getExpiration();
            if (unban != null) {
                Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
                long bantime = TimeUnit.SECONDS.convert(Math.abs(now.getTime() - unban.getTime()), TimeUnit.MILLISECONDS);
                int intbantime = Integer.parseInt(bantime + "");
                e.setKickMessage("§cYou are Temporary " + Timer.ConvertTimerTime(intbantime, "§f") + " §con this Server banned!\n\n§7Reason: §f" + reason);
            } else {
                e.setKickMessage("§cYou banned for lifetime on this Server!\n\n§7Reason: §f" + reason);
            }
            e.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
        }

    }
}
