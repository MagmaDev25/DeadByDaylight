package me.maxdev.listeners;

import me.maxdev.DeadByDaylight;
import me.maxdev.managers.FileManager;
import me.maxdev.managers.GameManager;
import me.maxdev.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private DeadByDaylight plugin;
    private FileManager lang;
    private FileManager scoreboard;
    private ScoreboardManager scoreboardManager;
    private FileManager config;
    private GameManager gameManager;

    public PlayerJoinListener(DeadByDaylight plugin, FileManager lang, FileManager scoreboard, ScoreboardManager scoreboardManager, FileManager config
                                ,GameManager gameManager){
        this.plugin = plugin;
        this.lang = lang;
        this.scoreboard = scoreboard;
        this.scoreboardManager = scoreboardManager;
        this.config = config;
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        scoreboardManager.setPlayerBoard(player.getUniqueId(), "start");
        if (Bukkit.getOnlinePlayers().size() == config.getInt("playersToStart")) {
            gameManager.setStarted(true);
            gameManager.setSeconds(config.getInt("timeToStart"));
        }
    }
}
