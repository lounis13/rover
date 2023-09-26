package org.canopee.rover.config;

import org.canopee.rover.domain.Command;
import org.canopee.rover.domain.Rover;

import java.util.List;
import java.util.TreeMap;

public record RoverConfig(int xSize,
                          int ySize,
                          List<Rover> rovers,
                          TreeMap<Rover, List<Command>> commandsByRover) {

    public void printCurrentRoversPosition() {
        commandsByRover.keySet().forEach(System.out::println);
    }
}
