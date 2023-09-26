package org.canopee.rover.config;

import org.canopee.rover.domain.Command;
import org.canopee.rover.domain.Orientation;
import org.canopee.rover.domain.Position;
import org.canopee.rover.domain.Rover;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RoverFileParser {


    private final String filePath;

    public RoverFileParser(String filePath) {
        this.filePath = filePath;
    }

    public RoverConfig parse() throws IOException {
        File inputFile = new File(filePath);
        List<Rover> rovers = new ArrayList<>();
        TreeMap<Rover, List<Command>> roverCommands = new TreeMap<>(Comparator.comparingInt(o -> o.id));

        try (var scanner = new Scanner(inputFile)) {

            var xSize = scanner.nextInt();
            var ySize = scanner.nextInt();
            scanner.nextLine();

            while (scanner.hasNext()) {
                roverCommands.put(initiateRover(scanner, xSize, ySize), parseCommands(scanner));
            }

            return new RoverConfig(xSize, ySize, rovers, roverCommands);
        }
    }

    private Rover initiateRover(Scanner scanner, int xSize, int ySize) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Orientation orientation = getOrientation(scanner.next());
        scanner.nextLine();

        return new Rover(new Position(x, y), orientation, xSize, ySize);
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
        try {
            return Orientation.valueOf(orientationStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid orientation: " + orientationStr);
        }
    }
}

