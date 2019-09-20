package com.mblock.communicationhandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class Response {
    /**
     * The command this response is related to
     */
    private final String command;
    /**
     * The payload of the incoming response.
     */
    private final String[] data;
}
