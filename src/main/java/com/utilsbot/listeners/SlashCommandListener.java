package com.utilsbot.listeners;

import com.utilsbot.commands.Command;
import com.utilsbot.commands.CommandManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public SlashCommandListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Command command = commandManager.get(event.getName());
        if (command == null) return; // unknown/stale command, ignore safely

        command.execute(event);
    }
}