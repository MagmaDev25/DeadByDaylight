package me.maxdev.managers;

import org.bukkit.entity.Player;

public class TranslatorManager {

    public void translate(String textToTranslate, Player player){
        textToTranslate = textToTranslate.replace("%player%", player.getName());
    }
    public void translate(String textToTranslate, Player player, int secs){
        textToTranslate = textToTranslate.replace("%player%", player.getName()).replace("%secs%", secs + "");
    }
    public void translate(String textToTranslate, Player player, String secs){
        textToTranslate = textToTranslate.replace("%player%", player.getName()).replace("%secs%", secs );
    }
    public void translate(String textToTranslate, Player player, int secs, String role) {
        textToTranslate = textToTranslate.replace("%player%", player.getName()).replace("%secs%", secs + "")
        .replace("%role%", role);
    }

}
