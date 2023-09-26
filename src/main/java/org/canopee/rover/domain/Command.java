package org.canopee.rover;

import java.util.function.Consumer;

public enum Command {
    L(Rover::turnLeft),
    R(Rover::turnRight),
    M(Rover::moveForward);

    private final Consumer<Rover> action;

    Command(Consumer<Rover> action) {
        this.action = action;
    }

    public void execute(Rover rover) {
        action.accept(rover);
    }
}
