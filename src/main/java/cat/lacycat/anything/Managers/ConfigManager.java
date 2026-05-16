package cat.lacycat.anything.Managers;

import cat.lacycat.anything.Managers.FeatureKeys.InfiniDeathKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    //Related with InfiniDeath
    private static final boolean[] infd = new boolean[2];

    /**
     * 인자에 따라 InfiniDeath의 설정값을 반환합니다.
     * 0 - Enabled
     * 1 - CanSpectateOthers
     * @param arg 인자
     * @return 설정값
     */
    public static boolean get_infd(short arg) {
        return infd[arg];
    }
    /**
     * 플러그인의 설정을 불러옵니다.
     * @param p 메인 플러그인 인스턴스
     * @return 설정 로드가 정상적으로 되었는지 확인합니다.
     */
    @SuppressWarnings("ReturnValueIgnored")
    public static boolean load(JavaPlugin p) {
        p.saveDefaultConfig();
        return reload(p);
    }

    /**
     * 플러그인의 설정을 다시 불러옵니다
     * @param p 메인 플러그인 인스턴스
     * @return 설정 리로드가 정상적으로 되었는지 확인합니다.
     */
    public static boolean reload(JavaPlugin p) {
        p.reloadConfig();
        FileConfiguration cfg = p.getConfig();
        if (!cfg.contains(InfiniDeathKey.enabled) || !cfg.contains(InfiniDeathKey.canSpectateOthers)) {
            p.getLogger().warning("[!] There is something wrong with config! (InfiniDeath)");
            return false;
        }
        infd[0] = cfg.getBoolean(InfiniDeathKey.enabled);
        infd[1] = cfg.getBoolean(InfiniDeathKey.canSpectateOthers);

        return true;
    }
}
