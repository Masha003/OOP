package labthree;

import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import labthree.commands.MonitorCommands;
import labthree.handlers.FilesHandler;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("/Users/mashacolta/Desktop/test");

        FilesHandler handler = new FilesHandler(path);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() ->{
            handler.checkChanges();
        }, 0, 5, TimeUnit.SECONDS);

        Thread thread = new Thread(() -> {
            new MonitorCommands(path);
        });
        thread.start();
    }    
}
