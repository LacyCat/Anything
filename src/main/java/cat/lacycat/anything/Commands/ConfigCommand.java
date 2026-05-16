package cat.lacycat.anything.Commands;

import cat.lacycat.anything.Managers.ConfigManager;
import cat.lacycat.anything.Managers.FeatureKeys.InfiniDeathKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ConfigCommand implements CommandExecutor {
    private final JavaPlugin p;
    public ConfigCommand(JavaPlugin p) {
        this.p = p;
    }
    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (args.length == 0) return false;
        if (args[0].equalsIgnoreCase("reload")) {
            ConfigManager.reload(p);
            sender.sendMessage("설정이 리로드되었습니다.");
            return true;
        }
        if (args[0].equalsIgnoreCase(InfiniDeathKey.root)) {
            if (args.length < 3) return false;
            if (args[1].equalsIgnoreCase(InfiniDeathKey.canSpectateOthers.replace(InfiniDeathKey.root + ".","")) && args[2] != null) {
                if (args[2].isBlank()) return false;
                p.getConfig().set(InfiniDeathKey.canSpectateOthers,Boolean.parseBoolean(args[2]));
            }
            else if (args[1].equalsIgnoreCase(InfiniDeathKey.enabled.replace(InfiniDeathKey.root + ".", ""))) {
                sender.sendMessage("InfiniDeath 의 Enable 설정을 수정하는 것은 의도치 않은 동작을 유발할 수 있습니다.");
            }
        }
        return true;
    }
}
