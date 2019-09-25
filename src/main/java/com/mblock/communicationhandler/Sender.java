package com.mblock.communicationhandler;

import lombok.RequiredArgsConstructor;
import purejavacomm.CommPortIdentifier;

import java.util.concurrent.*;

/**
 * This class should be used together with an {@link java.util.concurrent.ExecutorService} to send {@link Command} to the robot.
 */
public class Sender implements Callable<Boolean> {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future<Boolean> senderFuture;

    private final TransferQueue<Command> commandQueue = new LinkedTransferQueue<>();

    /**
     * The {@link CommPortIdentifier} on which the robot is connected
     */
    private final CommPortIdentifier portId;
    /**
     * The listeners which handle incoming {@link Response}
     */
    private final IncomingMessageListener[] listeners;

    public Sender(CommPortIdentifier portId, IncomingMessageListener[] listeners) {
        this.portId = portId;
        this.listeners = listeners;
    }

    /**
     * Sets up the connection and then waits for a {@link Command} to send.
     * @return always true.
     * @throws Exception some unexpected error occured.
     */
    @Override
    public Boolean call() throws Exception {
        try (Connection connection = new Connection(portId, listeners)) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    connection.writeCommand(commandQueue.take());
                } catch (InterruptedException e) {
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * Adds the {@link Command} to the internal queue for sending. This is done via an internal queue to ensure all {@link Command} get send in the order they are offered.
     * @param command The {@link Command} to send.
     * @return True if the {@link Command} was added to the queue.
     */
    public boolean sendCommand(Command command) {
        try {
            commandQueue.transfer(command);
            System.err.println("executinggss");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Start the sender in its own Thread executor service.
     * This is a convenience method. It should only b used when only one sender is used.
     */
    public void start() {
        senderFuture = executor.submit(this);
    }

    /**
     * Stop the sender and shutdown the executor.
     * This is a convenience method. It should only b used when only one sender is used.
     */
    public void stop() {
        senderFuture.cancel(true);
        executor.shutdown();
    }
    
    public void turnOn() {
    	senderFuture = executor.submit(this);
    	System.err.println("Executing turnOn() Method");
    }
    
    public void flushAllPackets(boolean shutdown) {
    	senderFuture.cancel(true);
    	if(shutdown) {
    		executor.shutdown();
    	}
    	System.err.println("shutting down");
    }
}
