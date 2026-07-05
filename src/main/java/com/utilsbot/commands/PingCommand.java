package com.utilsbot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            long ping = event.getJDA().getGatewayPing();
            event.reply("Ping : " + ping + "ms").queue();
        }
    }
}