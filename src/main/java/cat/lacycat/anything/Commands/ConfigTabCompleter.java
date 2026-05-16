package cat.lacycat.anything.Commands;

import cat.lacycat.anything.Managers.FeatureKeys.InfiniDeathKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ConfigTabCompleter implements TabCompleter {
    private static final String[] arg1 = {"reload", InfiniDeathKey.root};
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (args.length == 1) return Arrays.asList(arg1);
        else if (args.length == 2 && args[0].equals(InfiniDeathKey.root)) return Arrays.asList(InfiniDeathKey.infd);
        else {
            return List.of();
        }
    }
}
