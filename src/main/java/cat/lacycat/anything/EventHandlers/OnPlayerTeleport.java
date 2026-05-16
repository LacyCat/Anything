package cat.lacycat.anything.EventHandlers;

import cat.lacycat.anything.Managers.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class OnPlayerTeleport implements Listener {
    private final JavaPlugin p;
    public OnPlayerTeleport(JavaPlugin p) {
        this.p = p;
    }
    @EventHandler
    public void OnPlayerTeleportEvent(PlayerTeleportEvent ev) {
        if (ConfigManager.get_infd((short) 0)){
            if (!ConfigManager.get_infd((short) 1)) {
                if (ev.getCause() == PlayerTeleportEvent.TeleportCause.SPECTATE) {
                    ev.setCancelled(true);
                    ev.getPlayer().sendActionBar(Component.text("다른 플레이어를 관전하는 것은 금지되어있습니다!"));
                }
            }
            else {
                Bukkit.getScheduler().runTaskLater(p, () -> {
                    Entity ent = ev.getPlayer().getSpectatorTarget();
                    if (ent instanceof Player p) {
                        p.sendActionBar(Component.text("공기가 서늘해집니다...").color(TextColor.color(0x0E0F37)));
                    }
                },10L);
            }
        }
    }
}
