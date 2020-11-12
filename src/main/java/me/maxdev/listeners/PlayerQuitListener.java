package me.maxdev.listeners;

import me.maxdev.managers.FileManager;
import me.maxdev.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private FileManager config;
    private GameManager gameManager;

    public PlayerQuitListener(FileManager config, GameManager gameManager){
        this.config = config;
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        if(Bukkit.getOnlinePlayers().size() < config.getInt("playersToStart")){
            gameManager.setStarted(false);
        }
    }

}
