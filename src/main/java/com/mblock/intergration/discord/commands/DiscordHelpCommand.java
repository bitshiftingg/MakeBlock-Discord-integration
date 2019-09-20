package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.discord.Discord;

/**
 * @author Discord: Adam_#6723 or Distro#9528
 * Github: https://github.com/adamtrinity 
 * Project: University module 1
 */
public class DiscordHelpCommand implements MessageCreateListener {

    int count = 1;
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Yes").setColor(Color.green)
                .addField("The Robot is connected", "use ::commands to view the full list of commands" );  
        
        EmbedBuilder embedBuilder1 = new EmbedBuilder().
                setTitle("No").setColor(Color.green)
                .addField("The Robot is NOT connected", "Make sure it is connected via Bluetooth or USB Cable or Contact Distro for support"); 
        if(Discord.IS_ACTIVE) {
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
        } else {
        messageCreateEvent.getChannel().sendMessage(embedBuilder1);
        }
    }
}
