package es.angelillo15.nookure.backend;

import es.angelillo15.nookure.backend.config.ConfigLoader;
import io.javalin.Javalin;
import lombok.Getter;

public class Main {
    @Getter
    private static ConfigLoader configLoader = new ConfigLoader();
    public static void main(String[] args) {
        configLoader.updateConfig();
        configLoader.loadConfig();

        Javalin app = Javalin.create()
                .start(ConfigLoader.getConfig().getConfig().getInt("Config.port"));
        app.get("/", ctx -> ctx.json("{\"Status\": \"online!\"}"));

    }
}