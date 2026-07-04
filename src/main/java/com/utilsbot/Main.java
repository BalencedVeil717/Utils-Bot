package com.utilsbot;

import com.utilsbot.commands.*;
import com.utilsbot.config.Config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Main {
    static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(Config.getToken()).addEventListeners(new PingCommand()).build();

        jda.awaitReady();

        jda.updateCommands()
                .addCommands(Commands.slash("ping", "Replies with pong!"))
                .queue();

        System.out.println("Logged in as : " + jda.getSelfUser().getAsTag());
    }
}

//Hello java!