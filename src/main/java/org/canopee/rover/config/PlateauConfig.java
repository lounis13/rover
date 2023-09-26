package org.canopee.rover.config;

import org.canopee.rover.domain.Command;
import org.canopee.rover.domain.Rover;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum PlateauConfig {


    INSTANCE;

    public static int currentRoverSequence = 0;


    private int width = 5;
    private int height = 5;
    private boolean isInitialized = false;
    private TreeMap<Rover, List<Command>> commandByRovers;

    public static int generateNewId() {
        return currentRoverSequence++;
    }

    synchronized void initialize(int width, int height, TreeMap<Rover, List<Command>> commandByRovers) {
        if (!isInitialized) {
            this.width = width;
            this.height = height;
            isInitialized = true;
            this.commandByRovers = commandByRovers;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Rover, List<Command>> commandByRovers() {
        return new TreeMap<>(Map.copyOf(this.commandByRovers));
    }

    public void printCurrentRoversPosition() {
        this.commandByRovers.keySet().forEach(System.out::println);
    }
}
