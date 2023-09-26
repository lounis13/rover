package org.canopee.rover.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    private Rover rover;

    @BeforeEach
    public void setup() {
        rover = new Rover(new Position(0, 0), Orientation.N);
    }

    @Test
    public void should_moveNorth_when_orientationIsNorth() {
        rover.executeCommands(Command.M);
        assertEquals(new Position(0, 1), rover.getPosition());
    }

    @Test
    public void should_moveEast_when_orientationIsEast() {
        rover.turnRight(); // Turn to East
        rover.executeCommands(Command.M);
        assertEquals(new Position(1, 0), rover.getPosition());
    }

    @Test
    public void should_turnLeft() {
        rover.executeCommands(Command.L);
        assertEquals(Orientation.W, rover.getOrientation());
    }

    @Test
    public void should_turnRight() {
        rover.executeCommands(Command.R);
        assertEquals(Orientation.E, rover.getOrientation());
    }
}
