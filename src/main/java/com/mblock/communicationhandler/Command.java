package com.mblock.communicationhandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Contains the command to send to the robot. The content should comply with the logic in the MakeBlock script.
 */
@Getter
@RequiredArgsConstructor
public final class Command {
    /**
     * The byte indicating the command to be executed
     */
    private final byte command;
    /**
     * The payload of the command. This content of the payload depends on the command being executed
     */
    private final byte[] data;
}
