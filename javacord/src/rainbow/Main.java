package rainbow;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Main {
	public static JDA jda;
	public static String prefix = "!";
	public static void main(String[] args) throws LoginException{
		jda = new JDABuilder(AccountType.BOT).setToken("NjMwNDQ4NDQxMDEyNjUwMDE4.XZpV1g.V0DpNH6p6_QMWTl4OEM5dj1iceo").build();
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.addEventListener(new commands());
		
	}
}
