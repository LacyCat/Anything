package cat.lacycat.anything.Managers;

import cat.lacycat.anything.Commands.ConfigCommand;
import cat.lacycat.anything.Commands.ConfigTabCompleter;
import cat.lacycat.anything.EventHandlers.OnPlayerDeath;
import cat.lacycat.anything.EventHandlers.OnPlayerTeleport;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class RegisterManager {
    @SuppressWarnings("unused")
    public static void initmanually(JavaPlugin p) {
        boolean b = ConfigManager.load(p);
        registerCommands(p);
        registerListeners(p);
    }
    public static void registerListeners(JavaPlugin p) {
        p.getServer().getPluginManager().registerEvents(new OnPlayerDeath(),p);
        p.getServer().getPluginManager().registerEvents(new OnPlayerTeleport(p),p);
    }
    public static void registerCommands(JavaPlugin p) {
        Objects.requireNonNull(p.getCommand("anyconfig")).setExecutor(new ConfigCommand(p));
        Objects.requireNonNull(p.getCommand("anyconfig")).setTabCompleter(new ConfigTabCompleter());
    }
}
