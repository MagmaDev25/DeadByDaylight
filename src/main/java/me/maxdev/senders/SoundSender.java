package me.maxdev.senders;


import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundSender {

    public static void sendSound(Player player, String sound, Location location, float volume, float pitch){
        player.playSound(location, Sound.valueOf(sound), volume, pitch);
    }
}
