package com.mblock.communicationhandler;

import purejavacomm.SerialPort;
import purejavacomm.SerialPortEvent;
import purejavacomm.SerialPortEventListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ConnectionListener implements SerialPortEventListener {

    private final IncomingMessageListener[] listeners;
    private final InputStream inputStream;

    /**
     * Creates a {@link SerialPortEventListener} to listen to incoming responses. These are then forwarded to the connected array of {@link IncomingMessageListener}
     * @param serialPort The {@link SerialPort} to listen to for responses.
     * @param listeners The array of {@link IncomingMessageListener} to forward the response to.
     * @throws IOException Unable to get an {@link InputStream} on the {@link SerialPort}
     */
    public ConnectionListener(SerialPort serialPort, IncomingMessageListener... listeners) throws IOException {
        inputStream = serialPort.getInputStream();
        this.listeners = listeners;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                readIncomingData();
                break;
        }
    }

    private void readIncomingData() {
        byte[] readBuffer = new byte[20];
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            while (inputStream.available() > 0) {
                inputStream.read(readBuffer);
                baos.write(readBuffer);
            }
            processResponse(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processResponse(String responseString) {
        if (responseString.contains("|")) {
            System.out.println("response: " + responseString);
            String[] content = responseString.trim().split("\\|");
            String command = content[0];
            // skip the first entry in the content array since this is the command. Everything else is the payload
            Response response = new Response(command, Arrays.stream(content).skip(1).toArray(String[]::new));
            for (IncomingMessageListener listener : listeners) {
                listener.responseReceived(response);
            }
        }
    }
}
