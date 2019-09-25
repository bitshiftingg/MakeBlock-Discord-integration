package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.communication.example.RunClient;
import com.mblock.intergration.discord.Discord;

/**
 * @author Discord: Adam_#6723 or Distro#9528
 * Github: https://github.com/adamtrinity 
 * Project: University module 
 */
public class TurnOffCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {		
		Discord.client.getSender().flushAllPackets(false);
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Shutdown").setColor(Color.green)
                .addField("The robot has now flushed all existing/re-occuring ","packets."); 
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
    }
}
