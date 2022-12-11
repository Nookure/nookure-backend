package es.angelillo15.nookure.backend.config;

import es.angelillo15.configmanager.ConfigManager;
import es.angelillo15.nookure.backend.Main;
import lombok.Getter;
import ru.vyarus.yaml.updater.YamlUpdater;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.security.CodeSource;
import java.util.Objects;

public class ConfigLoader {
    @Getter
    private static String path;
    @Getter
    private static ConfigManager config;

    public ConfigLoader() {
        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        path = jarFile.getParentFile().getPath() + File.separator + "/config/";
    }

    public void updateConfig() {
        YamlUpdater.create(
                new File(path + "config.yml"),
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("config.yml"))
        ).update();
    }

    public void loadConfig() {
        config = new ConfigManager(Path.of(path), "config.yml", "config.yml");
        config.registerConfig();
    }

}
