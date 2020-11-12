package me.maxdev.loader;

import me.maxdev.DeadByDaylight;
import me.maxdev.checker.Checker;
import me.maxdev.managers.FileManager;
import me.maxdev.managers.GameManager;
import me.maxdev.managers.ScoreboardManager;
import me.maxdev.netherboard.BPlayerBoard;
import me.maxdev.netherboard.Netherboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class SetBoardTaskLoader {

    private DeadByDaylight plugin;
    private ScoreboardManager scoreboardManager;
    private FileManager scoreboard;
    private GameManager gameManager;
    private FileManager lang;
    private Checker checker;

    public BPlayerBoard board;

    public SetBoardTaskLoader(DeadByDaylight plugin, ScoreboardManager scoreboardManager, FileManager scoreboard, GameManager gameManager, FileManager lang,
                              Checker checker){
        this.plugin = plugin;
        this.scoreboardManager = scoreboardManager;
        this.scoreboard = scoreboard;
        this.gameManager = gameManager;
        this.lang = lang;
        this.checker = checker;
    }


    public void setScoreboardTask(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for(Player player: Bukkit.getOnlinePlayers()) {
                   setBoard(player);
                }
            }
        }, 0L, 20L);
    }

    public void setBoard(Player player){
        board = Netherboard.instance().getBoard(player);
        if(board == null) {
            board = Netherboard.instance().createBoard(player, "Scoreboard");
        }
        String s = scoreboardManager.getStringBoard(player.getUniqueId());
        if(s == null || s.isEmpty()) {
            return;
        }
        if(s.equalsIgnoreCase("start")){
            List<String> list = scoreboard.getStringList("scoreboardBeforeGame");
            for (int i = 0; i<scoreboard.getStringList("scoreboardBeforeGame").size(); i++) {
                String line = scoreboard.getStringList("scoreboardBeforeGame").get(i);

                board.set(ChatColor.translateAlternateColorCodes('&', line
                        .replace("%player%", player.getName())
                        .replace("%secs%", gameManager.getSecondsFormatted() )), list.size() - (i));
            }
            checker.checkSeconds(gameManager.getSeconds(), player);

            board.setName(ChatColor.translateAlternateColorCodes('&', scoreboard.getString("scoreboardTitle")));
        }else if(scoreboardManager.getStringBoard(player.getUniqueId()).equalsIgnoreCase("game")){
            //Cuando es la scoreboard en el juego!
            for (int i = 0; i<scoreboard.getStringList("scoreboardInGame").size(); i++) {

            }
            board.setName(ChatColor.translateAlternateColorCodes('&', scoreboard.getString("scoreboardTitle")));
        }else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "NO HAY SCOREBOARD ESPECIFICADA. CONTACTARSE CON DEVELOPER. DEADBYDAYLIGHT");
        }
        gameManager.secondDown();
    }

}
