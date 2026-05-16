package cat.lacycat.anything.Managers;

import cat.lacycat.anything.Managers.FeatureKeys.InfiniDeathKey;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    //Related with InfiniDeath
    public static boolean infd_enabled = true;
    public static boolean infd_canSpectateOthers = false;


    /**
     * 플러그인의 설정을 불러옵니다.
     * @param p - 메인 플러그인 인스턴스
     * @return - 설정 로드가 정상적으로 되었는지 확인합니다.
     */
    public static boolean load(JavaPlugin p) {
        p.saveDefaultConfig();
        p.reloadConfig();
        FileConfiguration cfg = p.getConfig();
        if (!cfg.contains(InfiniDeathKey.enabled) || !cfg.contains(InfiniDeathKey.canSpectateOthers)) {
            p.getLogger().warning("[!] There is something wrong with config! (InfiniDeath)");
            return false;
        }
        infd_enabled = cfg.getBoolean(InfiniDeathKey.enabled);
        infd_canSpectateOthers = cfg.getBoolean(InfiniDeathKey.canSpectateOthers);

        return true;
    }

    /**
     * 플러그인의 설정을 다시 불러옵니다
     * @param p - 메인 플러그인 인스턴스
     * @return - 설정 리로드가 정상적으로 되었는지 확인합니다.
     */
    public static boolean reload(JavaPlugin p) {
        p.reloadConfig();
        FileConfiguration cfg = p.getConfig();
        if (!cfg.contains(InfiniDeathKey.enabled) || !cfg.contains(InfiniDeathKey.canSpectateOthers)) {
            p.getLogger().warning("[!] There is something wrong with config! (InfiniDeath)");
            return false;
        }
        infd_enabled = cfg.getBoolean(InfiniDeathKey.enabled);
        infd_canSpectateOthers = cfg.getBoolean(InfiniDeathKey.canSpectateOthers);

        return true;
    }
}
