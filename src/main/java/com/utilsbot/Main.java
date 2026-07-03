package com.utilsbot;

import com.utilsbot.commands.CommandManager;
import com.utilsbot.config.Config;
import com.utilsbot.listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class Main {

    static void main(String[] args) throws InterruptedException {

        CommandManager commandManager = new CommandManager();

        JDA jda = JDABuilder.createLight(Config.getBotToken(), EnumSet.noneOf(GatewayIntent.class))
                .addEventListeners(new SlashCommandListener(commandManager))
                .build();

        jda.awaitReady();

        System.out.println("Bot is online as " + jda.getSelfUser().getAsTag());

        String guildId = Config.getGuildId();
        if (guildId != null && !guildId.isBlank()) {
            Guild guild = jda.getGuildById(guildId);
            guild
                    .updateCommands()
                    .addCommands(commandManager.getAllCommandData())
                    .queue();
            System.out.println("Registered guild commands for guild : " + guild.getName());
        } else {
            jda.updateCommands()
                    .addCommands(commandManager.getAllCommandData())
                    .queue();
            System.out.println("Registered global commands.");
        }
    }
}