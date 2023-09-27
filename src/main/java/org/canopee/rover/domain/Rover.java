package org.canopee.rover.domain;

import org.canopee.rover.config.PlateauConfig;

import java.util.Objects;

public class Rover implements Comparable<Rover> {


    public final int id = PlateauConfig.generateNewId();

    private Position position;
    private Orientation orientation;

    public Rover(Position position, Orientation orientation) {
        Objects.requireNonNull(position);
        Objects.requireNonNull(orientation);
        this.position = position;
        this.orientation = orientation;

    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void executeCommands(Command command) {
        command.execute(this);
    }

    public void moveForward() {
        position = switch (orientation) {
            case N -> position.incY();
            case E -> position.incX();
            case S -> position.decY();
            case W -> position.decX();
        };
    }

    public void turnLeft() {
        orientation = orientation.left();
    }

    public void turnRight() {
        orientation = orientation.right();
    }

    @Override
    public int compareTo(Rover rover) {
        return Integer.compare(id, rover.id);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Rover rover) && id == rover.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(position, orientation);
    }
}
