package com.utilsbot.commands;

import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandManager {

    private final Map<String, Command> commands = new LinkedHashMap<>();

    public CommandManager() {
        register(new PingCommand());
    }

    private void register(Command command) {
        commands.put(command.getName(), command);
    }

    public Command get(String name) {
        return commands.get(name);
    }

    public List<SlashCommandData> getAllCommandData() {
        return commands.values().stream()
                .map(Command::getCommandData)
                .collect(Collectors.toList());
    }
}