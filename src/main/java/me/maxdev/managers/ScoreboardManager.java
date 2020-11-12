package me.maxdev.managers;

import me.maxdev.DeadByDaylight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardManager {
    private DeadByDaylight plugin;
    private FileManager scoreboard;
    private Map<UUID, String> boards;

   public ScoreboardManager(DeadByDaylight plugin, FileManager scoreboard){
       this.plugin = plugin;
       this.scoreboard = scoreboard;
       this.boards = new HashMap<>();
   }

    /*
    @return   START if game isnt started GAME if game already started
     */
    public String getStringBoard(UUID playerUuid){
       return boards.get(playerUuid);
    }
    public void setPlayerBoard(UUID playerUuid, String board){
       boards.put(playerUuid, board);
    }


}
