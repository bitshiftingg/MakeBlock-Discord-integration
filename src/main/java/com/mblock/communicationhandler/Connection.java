package com.mblock.communicationhandler;

import purejavacomm.CommPortIdentifier;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TooManyListenersException;

/**
 * The actual serial connection
 */
class Connection implements AutoCloseable {

    private SerialPort serialPort;

    /**
     * Creates the actual connection on the indicated port id and adds the supplied listeners
     *
     * @param portId    The Comm port id on which the robot is connected
     * @param listeners The listeners which handle incoming responses
     * @throws IOException Something went wrong while setting up the connection
     */
    Connection(CommPortIdentifier portId, IncomingMessageListener... listeners) throws IOException {
        try {
            serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
            serialPort.addEventListener(new ConnectionListener(serialPort, listeners));
            serialPort.notifyOnDataAvailable(true);
            serialPort.setSerialPortParams(115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (PortInUseException | IOException | UnsupportedCommOperationException | TooManyListenersException e) {
            throw new IOException("Unable to setup a connection to " + portId.getName(), e);
        }
    }

    /**
     * Write the command to the robot
     *
     * @param command The command to send to the robot
     * @throws IOException Something went wrong while sending the command
     */
    void writeCommand(Command command) throws IOException {
        OutputStream out = serialPort.getOutputStream();
        out.write(command.getCommand());
        out.write(command.getData());
        out.flush();
    }

    /**
     * Close the connection to the robot. Has to be public because of inheritance even though it is not really needed here.
     */
    @Override
    public void close() {
        serialPort.close();
    }
}
