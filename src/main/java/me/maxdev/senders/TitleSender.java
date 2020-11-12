package me.maxdev.senders;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TitleSender {

    public static void sendTitleWithReplace(Player player, String title, String subtitle, int fadeIn
    , int stay, int fadeOut, int seconds){

        player.sendTitle(ChatColor.translateAlternateColorCodes('&', title.replace("%secs%", seconds + "")),
                ChatColor.translateAlternateColorCodes('&', subtitle.replace("%secs%", seconds + "")), fadeIn, stay, fadeOut);
    }

}
