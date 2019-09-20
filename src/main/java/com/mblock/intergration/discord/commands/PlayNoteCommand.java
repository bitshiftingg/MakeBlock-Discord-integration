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
 * Project: University module 1
 */
public class PlayNoteCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
    	RunClient client = new RunClient();
    	client.playNotes();
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Play Notes").setColor(Color.green)
                .addField("Playing a singular notes", "."); 
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
    }
}
