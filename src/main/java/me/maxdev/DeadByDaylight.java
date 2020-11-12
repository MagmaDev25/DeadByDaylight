package me.maxdev;

import me.maxdev.checker.Checker;
import me.maxdev.listeners.PlayerJoinListener;
import me.maxdev.listeners.PlayerQuitListener;
import me.maxdev.loader.SetBoardTaskLoader;
import me.maxdev.managers.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DeadByDaylight extends JavaPlugin {
    private FileManager config;
    private FileManager lang;
    private FileManager scoreboard;
    private PluginManager pluginManager;

    private ScoreboardManager scoreboardManager;
    private UserManager userManager;
    private GameManager gameManager;
    private Checker checker;

    @Override
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[DeadByDaylight]&2 Activated"));
        pluginManager = Bukkit.getPluginManager();
        createFiles();
        registerManagers();
        registerEvents();
        SetBoardTaskLoader taskLoader = new SetBoardTaskLoader(this, scoreboardManager,scoreboard, gameManager,lang, checker);
        taskLoader.setScoreboardTask();
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[DeadByDaylight]&2 Desactivated"));
    }



    public void createFiles(){
        lang = new FileManager(this, "lang");
        config = new FileManager(this, "config");
        lang.create();
        config.create();
        scoreboard = new FileManager(this, "scoreboard");
        scoreboard.create();
    }
    public void registerEvents(){
        pluginManager.registerEvents(new PlayerJoinListener(this, lang, scoreboard, scoreboardManager, config, gameManager), this);
        pluginManager.registerEvents(new PlayerQuitListener(config, gameManager), this);
    }
    public void registerManagers(){
        gameManager = new GameManager(this, config);
        scoreboardManager = new ScoreboardManager(this, scoreboard);
        userManager = new UserManager(this);
        checker = new Checker(lang);
    }
}
