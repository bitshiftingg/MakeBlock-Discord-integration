package com.mblock.gps.maps;

public class Main {

    public static void main(String[] args) throws Exception {
        SerialGps serialGps = new SerialGps("COM5");

        serialGps.addStateListener(state -> System.out.println(
                state.lat + ", " + state.lon + " (" + (state.hasFix ? "got fix" : "no fix") + ")"
        ));

        serialGps.start();
    }

}
