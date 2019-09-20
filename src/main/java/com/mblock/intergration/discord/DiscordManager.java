package com.mblock.intergration.discord;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;


/**
 * User: Adam_#6723 Date: 24-02-2019 Project: Brutal-OS
 */

public class DiscordManager {

	protected String title, message, channel;
	
	public DiscordManager(String channel, String title, String message) {
		this.channel = channel;
		this.title = title;
		this.message = message;
	}

	public void log() {
		EmbedBuilder embedBuilder = new EmbedBuilder().setTitle(title).setColor(Color.green)
				.addField("", message, true);
		Discord.api.getChannelById(channel).get().asTextChannel().get().sendMessage(embedBuilder);
	}
	
	public void log1() {
		EmbedBuilder embedBuilder = new EmbedBuilder().setTitle(title).setColor(Color.green)
				.addField(title, message, true);
		Discord.api.getChannelById(channel).get().asTextChannel().get().sendMessage(embedBuilder);
	}
}
