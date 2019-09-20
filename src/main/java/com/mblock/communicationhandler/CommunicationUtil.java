package com.mblock.communicationhandler;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import purejavacomm.CommPortIdentifier;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Stream;

/**
 * Various utility methods
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommunicationUtil {

    /**
     * Retreives a stream containing the possible serial ports with a connected robot.
     *
     * @return The stream containing the possible serial ports with a connected robot.
     */
    public static Stream<CommPortIdentifier> getComPorts() {
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        return Collections.list(portList).stream().filter((portId) -> portId.getPortType() == CommPortIdentifier.PORT_SERIAL);
    }

    /**
     * Opens a connection on the indicated comm port id and creates a sender. The supplied listeners are passed to the connection to handle incoming responses from the robot.
     *
     * @param portId The Comm port id on which the robot is connected
     * @param listeners The listeners which handle incoming responses
     * @return The generated sender used to send commands to the robot
     * @throws IOException Something went wrong while setting up the connection
     */
    public static Sender openConnection(CommPortIdentifier portId, IncomingMessageListener... listeners) throws IOException {
        return new Sender(portId, listeners);
    }

}
