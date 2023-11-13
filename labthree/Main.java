package labthree;

import java.nio.file.*;

import labthree.commands.MonitorCommands;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("/Users/mashacolta/Desktop/test");

        Thread thread = new Thread(() -> {
            new MonitorCommands(path);
        });
        thread.start();
    }

    // ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
    
}
