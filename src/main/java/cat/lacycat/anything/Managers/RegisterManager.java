package cat.lacycat.anything.Managers;

import cat.lacycat.anything.EventHandlers.OnPlayerTeleport;
import org.bukkit.plugin.java.JavaPlugin;

public class RegisterManager {
    public static void registerListeners(JavaPlugin p) {
        p.getServer().getPluginManager().registerEvents(new OnPlayerTeleport(p),p);
        p.getServer().getPluginManager().registerEvents(new OnPlayerTeleport(p),p);
    }
}
