package org.canopee.rover.config;

import org.canopee.rover.domain.Command;
import org.canopee.rover.domain.Orientation;
import org.canopee.rover.domain.Position;
import org.canopee.rover.domain.Rover;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class RoverFileParser {
    private final String filePath;

    public RoverFileParser(String filePath) {
        this.filePath = filePath;
    }

    public void init() throws IOException {
        File inputFile = new File(filePath);
        TreeMap<Rover, List<Command>> roverCommands = new TreeMap<>();

        try (var scanner = new Scanner(inputFile)) {

            var width = scanner.nextInt();
            var height = scanner.nextInt();
            scanner.nextLine();

            while (scanner.hasNext()) {
                roverCommands.put(initiateRover(scanner), parseCommands(scanner));
            }

            PlateauConfig.INSTANCE.initialize(width, height, roverCommands);
        }
    }

    private Rover initiateRover(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Orientation orientation = getOrientation(scanner.next());
        scanner.nextLine();

        return new Rover(new Position(x, y), orientation);
    }

    private List<Command> parseCommands(Scanner scanner) {
        String commandsStr = scanner.nextLine();
        List<Command> commands = new ArrayList<>();
        for (var commandChar : commandsStr.toCharArray()) {
            commands.add(Command.valueOf(String.valueOf(commandChar)));
        }
        return commands;
    }

    private Orientation getOrientation(String orientationStr) {
        return Orientation.valueOf(orientationStr);
    }
}

