package cat.lacycat.anything;

import cat.lacycat.anything.Managers.RegisterManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Anything extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        RegisterManager.initmanually(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
