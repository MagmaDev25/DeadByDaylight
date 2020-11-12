package me.maxdev.managers;

import me.maxdev.DeadByDaylight;

import java.text.SimpleDateFormat;

public class GameManager{
    private DeadByDaylight plugin;
    private FileManager config;

    private int seconds;
    private String secondsFormatted;
    private boolean started;


    public GameManager(DeadByDaylight plugin, FileManager config){
        this.plugin = plugin;
        this.config = config;
        this.seconds = config.getInt("timeToStart");
        this.started = false;
    }

    public void setStarted(boolean state){
        started = state;
    }
    public void setSeconds(int secs){
        this.seconds = secs;
    }

    public void secondDown(){
        seconds--;
    }
    public int getSeconds(){
        return seconds;
    }
    public String getSecondsFormatted(){
        String simpleFormat;
        if(!(seconds <= -1)) {
            simpleFormat = new SimpleDateFormat("mm:ss").format(seconds * 1000);
        }else{
            simpleFormat = config.getString("stateOfSeconds");
        }
        return simpleFormat;
    }

}
