package com.mblock.gps.maps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;

import net.sf.marineapi.nmea.io.SentenceReader;
import net.sf.marineapi.provider.PositionProvider;
import net.sf.marineapi.provider.event.PositionEvent;
import net.sf.marineapi.provider.event.ProviderListener;
import purejavacomm.CommPortIdentifier;
import purejavacomm.SerialPort;

public class BluetoothMapService {
	
	private static String cordinates;
	
	public static String getCords() {
		return cordinates;
	}

    public static InputStream openPort() {
        @SuppressWarnings("unchecked")
        Enumeration<CommPortIdentifier> portIdentifiers = CommPortIdentifier.getPortIdentifiers();
        
        try {
            for (CommPortIdentifier identifier: Collections.<CommPortIdentifier>list(portIdentifiers)) {
                if (identifier.getPortType() == CommPortIdentifier.PORT_SERIAL
                        && identifier.getName().equals("COM5")) {
                	System.err.println("Is this being accessed??");
                    SerialPort port = (SerialPort) identifier.open("SimpleReadApp", 2000);
                    port.setSerialPortParams(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    
                    return port.getInputStream();
                }
            }
            throw new IllegalStateException("Serial port for GPS was not found");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    
    public static void test(PositionEvent evt) {
        System.err.println("TPV: " + evt.toString());
    }
    
    public static void main(String[] args) throws IOException {
        InputStream serialPort = openPort();
        SentenceReader nmeaReader = new SentenceReader(serialPort);
        PositionProvider positionProvider = new PositionProvider(nmeaReader);
        
        positionProvider.addListener(new ProviderListener<PositionEvent>() {
            @Override
            public void providerUpdate(PositionEvent evt) {
                // to format latitude and longitude, see implementation of evt.getPosition().toString()
                System.out.println("TPV: " + evt.toString());
                for(int i = 0; i < 100; i++) {
                    System.err.println("TPV: " + evt.toString());
                }
                test(evt);
            }
        });
        
        nmeaReader.start();
    }
    
}