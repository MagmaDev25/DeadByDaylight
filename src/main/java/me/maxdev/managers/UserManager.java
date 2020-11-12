package me.maxdev.managers;

import me.maxdev.DeadByDaylight;

import java.util.Map;
import java.util.UUID;

public class UserManager {
    private DeadByDaylight plugin;
    private Map<UUID, String> role;
    private Map<UUID, String> power;

    public UserManager(DeadByDaylight plugin){
        this.plugin=plugin;
    }
    public void addRole(UUID playerUuid, String playerRole){
        role.put(playerUuid, playerRole);
    }
    public String getRole(UUID playerUuid){
        return role.get(playerUuid);
    }

    public void addPower(UUID playerUuid, String playerPower){
        role.put(playerUuid, playerPower);
    }
    public String getPower(UUID playerUuid){
        return role.get(playerUuid);
    }

}
