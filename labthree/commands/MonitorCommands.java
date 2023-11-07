package labthree.commands;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

import labthree.handlers.FilesHandler;

public class MonitorCommands {

    public MonitorCommands(Path path) {
        FilesHandler fh = new FilesHandler(path);

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while(true) {
                System.out.println(
                System.lineSeparator() +
                "File manager operations\n" +
                "What do you want to do?\n" +
                "commit\n" +
                "info <filename>\n" +
                "status\n" +
                System.lineSeparator() +
                 "exit\n" + 
                "your input>");

                command = reader.readLine();

                switch(command) {
                    case "commit" -> {
                        fh.commitChanges();
                    }

                    case "status" -> {
                        fh.checkStatus();
                    }

                    case "exit" -> {
                        System.out.println("Quiting the program.\n");
                        System.exit(0);
                    }

                    default -> {
                        if(command.startsWith("info ")) {
                            String parts[] = command.split(" ");
                            if(parts.length == 2) {
                                String fileName = parts[1];
                                fh.printInformation(fileName);
                            } else {
                                System.out.println("Invalid 'info' command. \n");
                            }
                        } else {
                            System.out.println("Invalid command.");
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
