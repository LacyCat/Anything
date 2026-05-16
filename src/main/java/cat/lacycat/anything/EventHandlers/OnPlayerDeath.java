package cat.lacycat.anything.EventHandlers;

import cat.lacycat.anything.Managers.ConfigManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnPlayerDeath implements Listener {
    @EventHandler
    public void OnPlayerDeathEvent(PlayerDeathEvent ev) {
        if (ConfigManager.infd_enabled) {
            Player p = ev.getPlayer();
            p.setGameMode(GameMode.SPECTATOR);
        }
    }
}
