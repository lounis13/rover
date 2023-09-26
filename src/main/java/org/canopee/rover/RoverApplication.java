package org.canopee.rover;

import org.canopee.rover.config.RoverFileParser;

import java.io.IOException;

public class RoverApplication {
    public static void main(String[] args) throws IOException {

        var roverConfig = new RoverFileParser(args[0]).parse();
        roverConfig.commandsByRover()
                .forEach(
                        (rover, commands) -> commands.forEach(rover::executeCommands)
                );

        roverConfig.printCurrentRoversPosition();
    }

    private static void validateArgs(String[] args) {
        if (args == null || args.length != 1) {
            System.out.println("Usage: java -jar rover.jar <input-file-path>");
            System.exit(1);
        }
    }
}