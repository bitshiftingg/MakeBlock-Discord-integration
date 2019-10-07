package rainbow;
import java.util.Random;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commands extends ListenerAdapter {
	private static final boolean True = false;
	public void onGuildMessageRecieved(GuildMessageReceivedEvent event) {
	String[] args = event.getMessage().getContentRaw().split("\\s+");

	if (args[0].equalsIgnoreCase(Main.prefix + "player-Assignment")) {
		event.getChannel().sendTyping().queue();
		event.getChannel().sendMessage("Would you like to engage in a game with the mbot Ranger?").queue();
		if (args[0].equalsIgnoreCase(Main.prefix + "yes")) {
			event.getGuild().addRoleToMember(event.getMember(), ("Player1")).complete();
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Will There be a player2?").queue();
			if (args[0].equalsIgnoreCase(Main.prefix + "yes")) {
				event.getGuild().addRoleToMember(event.getMember(), ("Player2")).complete();
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage("Will There be a player3?").queue();
				if (args[0].equalsIgnoreCase(Main.prefix + "yes")) {
					event.getGuild().addRoleToMember(event.getMember(), ("Player3")).complete();
					event.getChannel().sendTyping().queue();
					event.getChannel().sendMessage("Will There be a player4?").queue();
					if (args[0].equalsIgnoreCase(Main.prefix + "yes")) {
						event.getGuild().addRoleToMember(event.getMember(), ("Player4")).complete();
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage("That is the max amount of players please use the begin command?").queue();
		}

			
			
		}
	}
	}

Random rand	= new Random();
int number = rand.nextInt(Commands.length);
}
