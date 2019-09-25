package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.communication.example.RunClient;

public class BackWardsCommand implements MessageCreateListener {

	@Override
	public void onMessageCreate(MessageCreateEvent arg0) {
		//RunClient client = new RunClient();
    	//client.runProgram();
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Backwards movement").setColor(Color.green)
                .addField("The Robot is now activating", "backwards movement"); 
        arg0.getChannel().sendMessage(embedBuilder);
		
	}

}
