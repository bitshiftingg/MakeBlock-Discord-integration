package com.mblock.intergration.discord;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.mblock.intergration.communication.example.RunClient;

/**
 * @author Discord: Adam_#6723 or Distro#9528
 * Github: https://github.com/adamtrinity 
 */

public class Discord {

	public static RunClient client;
    public static DiscordApi api;
    
    public static boolean IS_ACTIVE = false;
    
    public final long id = 623600300644630538l;
    
    public void start() {
        api = new DiscordApiBuilder().setToken(DiscordConstant.BOT_KEY).login().join();
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("MakeBlock Discord Integration for mBot Ranger developed by https://github.com/adamtrinity")
                .addField("Client Id", String.valueOf(api.getClientId()), true)
                .addField("Channels", String.valueOf(api.getChannels().size()), true)
                .addField("Status", String.valueOf(api.getStatus()), true)
                .addField("Commands Loaded", String.valueOf(new DiscordCommands().execute()), true)
                .addField("Total Server Member Count: ", String.valueOf(api.getServerById(id).get().getMemberCount()), true)
                .addField("Prefix", " !COMMAND", true);
        api.getChannelById("623600300644630541").get().asTextChannel().get().sendMessage(embed);
        api.addMessageCreateListener(event -> {
            DiscordCommands.FINAL_COMMAND.forEach((command, execution) -> {
                if(command.equalsIgnoreCase(event.getMessage().getContent())) {
                    execution.onMessageCreate(event);
                }
            });
        });
    }
    
    public static void main(String args[]) {
        client = new RunClient();
        client.go();
    	new Discord().start();
    	IS_ACTIVE = true;
    }
}
