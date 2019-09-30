package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.communication.example.RunClient;

/**
 * @author Discord: Adam_#6723
 * Github: https://github.com/adamtrinity 
 * Project: University module 1
 */
public class LocationCommandTest implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Cordinates For Mbot Ranger").setColor(Color.green)
                .addField("52°24'41.9\"N 1°30'41.2\"W", ".");
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
    }
}
