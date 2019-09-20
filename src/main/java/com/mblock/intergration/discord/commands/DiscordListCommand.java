package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.discord.DiscordCommands;

/**
 * @author Discord: Adam_#6723 or Distro#9528
 * Github: https://github.com/adamtrinity 
 * Project: University module 1
 */

public class DiscordListCommand implements MessageCreateListener {

    int count = 1;
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Commands").setColor(Color.green);
        DiscordCommands.COMMANDS.forEach((a, b) -> {
            embedBuilder.addField(String.valueOf(count++) + ")", a);
        });
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
    }
}
