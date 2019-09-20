package com.mblock.intergration.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;


/**
 * 
 * @author Discord: Adam_#6723 
 * Github: https://github.com/adamtrinity 
 * R-S: https://www.rune-server.ee/members/bitshifting/
 */

public class DiscordMassMessage {

	public static DiscordApi api;

	public static long id = 560289328807280640L;

	public static long Adam = 400026363924316160L;

	public static void start() {
		api = new DiscordApiBuilder().setToken(DiscordConstant.BOT_KEY).login().join();
		EmbedBuilder embed = new EmbedBuilder().setTitle("Artex RSPS Has Launched a new Update!!!!");
				embed.addField("New Content such as Boss Event & Rewards List & Golden Scratch Cards",
						"!!");
		api.getServerById(id).get().getMembers().forEach(user -> {
			if(user == null || user != null && user.getId() != 95929949982068736L) {
				user.getMentionTag();
				//user.sendMessage(embed);
				user.sendMessage("hop online now!! There is currently a 25% Sale of all purchases and brand new updates have been published!! So much new features its unreal!");
				user.sendMessage("http://artex-rsps.com/resources/Artex-Launcher.jar");
				System.err.println("Sent To: " + user.getName());
			}
		});
		api.addMessageCreateListener(event -> {
			DiscordCommands.FINAL_COMMAND.forEach((command, execution) -> {
				if (command.equalsIgnoreCase(event.getMessage().getContent())) {
					execution.onMessageCreate(event);
				}
			});
		});
	}

	public static boolean DISCORD_MASS_MESSAGE = true;
	
	public static void main(String[] args) {
		if (DISCORD_MASS_MESSAGE == false) {
			return;
		}
		start();
	}
}