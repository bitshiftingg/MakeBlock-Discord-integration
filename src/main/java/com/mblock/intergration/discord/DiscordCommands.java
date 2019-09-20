package com.mblock.intergration.discord;

import java.util.HashMap;
import java.util.Map;

import org.javacord.api.listener.message.MessageCreateListener;

import com.mblock.intergration.discord.commands.BoogyDanceCommand;
import com.mblock.intergration.discord.commands.DiscordHelpCommand;
import com.mblock.intergration.discord.commands.DiscordListCommand;
import com.mblock.intergration.discord.commands.DiscordOnlineCommand;
import com.mblock.intergration.discord.commands.PlayNoteCommand;
import com.mblock.intergration.discord.commands.RobotMoveForward;

/**
 * @author Discord: Adam_#6723 
 * Github: https://github.com/adamtrinity 
 * R-S: https://www.rune-server.ee/members/bitshifting/
 */

public class DiscordCommands {

    public static Map<String, MessageCreateListener> COMMANDS = new HashMap<>();
    public static Map<String, MessageCreateListener> FINAL_COMMAND = new HashMap<>();

    public static int execute() {
    	
        COMMANDS.putIfAbsent("commands", new DiscordListCommand());
        COMMANDS.putIfAbsent("help", new DiscordHelpCommand());
        COMMANDS.putIfAbsent("move", new RobotMoveForward());
        COMMANDS.putIfAbsent("dance", new BoogyDanceCommand());
        COMMANDS.putIfAbsent("music", new PlayNoteCommand());

        COMMANDS.forEach((com, exe) -> {
            FINAL_COMMAND.putIfAbsent(DiscordConstant.PREFIX + com, exe);
        });

        return FINAL_COMMAND.size();
    }
}
