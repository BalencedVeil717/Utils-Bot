package com.utilsbot.commands;

import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.separator.Separator;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            long ping = event.getJDA().getGatewayPing();
            String label =
                ping <= 50 ? "Excellent" :
                ping <= 100 ? "Great" :
                ping <= 150 ? "Good" :
                ping <= 250 ? "Fair" :
                ping <= 400 ? "Poor" :
                ping <= 500 ? "Bad" : "Terrible";

            String time = DateTimeFormatter.ofPattern("dd MMM, HH:mm").withZone(ZoneId.of("Asia/Kolkata")).format(Instant.now());


            event
                    .reply("")
                    .useComponentsV2()
                    .addComponents(
                            Container.of(
                                    TextDisplay.of("## Ping : " + ping + " ms"),
                                    Separator.createDivider(Separator.Spacing.SMALL),
                                    TextDisplay.of("-# " + label + " | " + time + " IST")

                            )
                    )
                    .queue();
        }
    }
}