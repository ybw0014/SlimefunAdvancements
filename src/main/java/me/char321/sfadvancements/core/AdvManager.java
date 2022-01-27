package me.char321.sfadvancements.core;

import me.char321.sfadvancements.api.Advancement;
import me.char321.sfadvancements.core.criteria.progress.PlayerProgress;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdvManager {
    private final Map<UUID, PlayerProgress> playerMap = new HashMap<>();

    public boolean isCompleted(Player player, Advancement advancement) {
        return isCompleted(player.getUniqueId(), advancement);
    }

    public boolean isCompleted(UUID player, Advancement advancement) {
        PlayerProgress progress = getProgress(player);
        return progress.isCompleted(advancement.getKey());
    }

    public PlayerProgress getProgress(Player player) {
        return getProgress(player.getUniqueId());
    }

    public PlayerProgress getProgress(UUID player) {
        playerMap.computeIfAbsent(player, PlayerProgress::get);
        return playerMap.get(player);
    }

    public void save() throws IOException {
        for (Map.Entry<UUID, PlayerProgress> entry : playerMap.entrySet()) {
            entry.getValue().save();
        }
    }
}
