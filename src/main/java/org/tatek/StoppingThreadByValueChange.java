package org.tatek;

import java.util.Scanner;

/**
 * @author tatek on 8/17/2023
 */
public class StoppingThreadByValueChange {
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        app.shutDown();
    }
}

class App extends Thread {

    //Volatile key word makes the variable visibility for any thread.
    // The value will be reflected as soon as get changed.
    //This key word help to implements in caching service.
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println(" Press enter to stop the program");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        System.out.println("System shutting down ...");
        running = false;
    }
}
