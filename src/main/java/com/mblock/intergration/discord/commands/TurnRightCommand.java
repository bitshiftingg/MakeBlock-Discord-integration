package com.mblock.intergration.discord.commands;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class TurnRightCommand implements MessageCreateListener {

	@Override
	public void onMessageCreate(MessageCreateEvent arg0) {
		//RunClient client = new RunClient();
    	//client.runProgram();
        EmbedBuilder embedBuilder = new EmbedBuilder().
                setTitle("Left Turn").setColor(Color.green)
                .addField("The Robot is now activating", "Left Turn"); 
        arg0.getChannel().sendMessage(embedBuilder);
		
	}

}
