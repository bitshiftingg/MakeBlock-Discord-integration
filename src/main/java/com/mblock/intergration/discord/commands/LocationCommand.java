package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.gps.maps.BluetoothMapService;
import com.mblock.intergration.communication.example.RunClient;

/**
 * @author Discord: Adam_#6723
 * Github: https://github.com/adamtrinity 
 * Project: University module 1
 */
public class LocationCommand implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
    	RunClient client = new RunClient();
    	client.playNotes();
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Cordinates For Mbot Ranger").setColor(Color.green)
                .addField("" + BluetoothMapService.getCords(), ""); 
        messageCreateEvent.getChannel().sendMessage(embedBuilder);
    }
}
