package cat.lacycat.anything;

import cat.lacycat.anything.Managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Anything extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager.load(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
