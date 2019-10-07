package rainbow;

import java.util.Random;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Quiz extends ListenerAdapter {
	String[] Commands = {
			"We Need to fill this in with the commands.",
			"All of em"
	};

	public void onGuildMessageRecieved(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase(Main.prefix + "Begin")) {
		int rounds = 5;
		int player1 = 0;
		int player2 = 0;
		int player3 = 0;
		int player4 = 0;
		Random rand	= new Random();
		int number = rand.nextInt(Commands.length);
		int numbe2= rand.nextInt(3);
		
		while (rounds != 0) {
			
			String[] ABCD = { Commands[number],Commands[number],Commands[number],Commands[number]
					
			};
			
			String A = ABCD[0];
			String B = ABCD[1];
			String C = ABCD[2];
			String D = ABCD[3];
			String aAnswer = ABCD[numbe2];
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("For Round " + rounds + "Will the robot do A " + A
					+ "B, " + B + "C," + C + "Or D " + D).queue();
			event.getChannel().sendTyping().queue();
			String[] args = event.getMessage().getContentRaw().split("\\s+");
			if (event.getGuild().getRoleById("player1") & args[0].equalsIgnoreCase(aAnswer)) {
				player1 = player1 + 1;
			}
			if (event.getGuild().getRoleById("player2") & args[0].equalsIgnoreCase(aAnswer)) {
				player1 = player2 + 1;
			}
			if (event.getGuild().getRoleById("player3") & args[0].equalsIgnoreCase(aAnswer)) {
				player1 = player3 + 1;
			}
			if (event.getGuild().getRoleById("player4") & args[0].equalsIgnoreCase(aAnswer)) {
				player1 = player4 + 1;
			}
			event.getChannel().sendMessage("The Actual Answer Was " + aAnswer).queue();
			event.getChannel().sendMessage("The Current Scores are: " + Player1 + "For Player One"
					+ Player2 + "For Player Two "+ Player 3 + "For Player Three and" + 
					Player4 + "For player Four").queue();
			rounds = rounds - 1;
		}
		}
	}
}
