package com.utilsbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class PingCommand implements Command {

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public SlashCommandData getCommandData() {
        return Commands.slash("ping", "Checks the bot's latency.");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Pong! lol").queue();
    }
}