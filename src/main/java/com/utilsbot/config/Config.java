package com.utilsbot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IllegalStateException(
                        "application.properties not found on classpath. " +
                                "Copy application.properties.example to application.properties and fill in your values."
                );
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load application.properties", e);
        }
    }

    private Config() {}

    public static String getBotToken() {
        return require("bot.token");
    }

    public static String getGuildId() {
        return properties.getProperty("guild.id"); // nullable, that's fine
    }

    private static String require(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required config value: " + key);
        }
        return value;
    }
}