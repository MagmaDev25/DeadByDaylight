package me.maxdev.checker;

import me.maxdev.managers.FileManager;
import me.maxdev.senders.SoundSender;
import me.maxdev.senders.TitleSender;
import org.bukkit.entity.Player;

public class Checker {
    private FileManager lang;

    public Checker(FileManager lang){
        this.lang = lang;
    }

    public void checkSeconds(int seconds, Player player){
        if(seconds <= 20 && seconds >= 0 && seconds%5 == 0){
            TitleSender.sendTitleWithReplace(player, lang.getString("titles.titlesOnSeconds.onSeconds.title"), lang.getString("titles.titlesOnSeconds.onSeconds.subtitle")
            ,lang.getInt("titles.fadeIn"), lang.getInt("titles.fadeIn"), lang.getInt("titles.fadeIn"), seconds);
            SoundSender.sendSound(player, lang.getString("titles.soundWhenTitle"), player.getLocation(), 2.0f, 1.0f);
        }else if(seconds <= 4){
            TitleSender.sendTitleWithReplace(player, lang.getString("titles.titlesOnSeconds.countdownUnderFive.title"), lang.getString("titles.titlesOnSeconds.countdownUnderFive.subtitle")
                    ,lang.getInt("titles.fadeIn"), lang.getInt("titles.fadeIn"), lang.getInt("titles.fadeIn"), seconds);
            SoundSender.sendSound(player, lang.getString("titles.soundWhenTitle"), player.getLocation(), 2.0f, 1.0f);
        }
    }

}
