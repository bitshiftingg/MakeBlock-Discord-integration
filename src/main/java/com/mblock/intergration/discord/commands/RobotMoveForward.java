package com.mblock.intergration.discord.commands;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
public class RobotMoveForward implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
    	try {
    		Discord.client.getSender().sendCommand(Discord.client.moveForward((byte) 3));
            EmbedBuilder embedBuilder = new EmbedBuilder().
                    setTitle("Robot Forward Movement").setColor(Color.green)
                    .addField("The Robot is now moving", "forward."); 
            messageCreateEvent.getChannel().sendMessage(embedBuilder);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
