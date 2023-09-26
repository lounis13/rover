package org.canopee.rover;

import java.util.Objects;

public class Rover {
    private static int SEQ = 0;

    public final int id = SEQ++;

    private final int ySize;
    private final int xSize;
    private Position position;
    private Orientation orientation;

    public Orientation getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Rover(Position position, Orientation orientation, int xSize, int ySize) {
        Objects.requireNonNull(position);
        Objects.requireNonNull(orientation);

        this.xSize = xSize;
        this.ySize = ySize;
        this.position = position;
        this.orientation = orientation;

    }

    public void executeCommands(Command command) {
        command.execute(this);
    }

    public void moveForward() {
        var newPosition = switch (orientation) {
            case N -> position.incY();
            case E -> position.incX();
            case S -> position.decY();
            case W -> position.decX();
        };
        if (isValidPosition(newPosition)) position = newPosition;
    }

    public void turnLeft() {
        orientation = orientation.left();
    }

    public void turnRight() {
        orientation = orientation.right();
    }

    boolean isValidPosition(Position pos) {
        return pos.x() <= xSize && pos.y() <= ySize;
    }


    @Override
    public String toString() {
        return "%s %s".formatted(position, orientation);
    }
}
