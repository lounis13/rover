package org.canopee.config;

import org.canopee.rover.Command;
import org.canopee.rover.Rover;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public record RoverConfig(int xSize,
                          int ySize,
                          List<Rover> rovers,
                          TreeMap<Rover, List<Command>> commandsByRover) {

    public void printCurrentRoversPosition() {
        commandsByRover.keySet().forEach(System.out::println);
    }
}
