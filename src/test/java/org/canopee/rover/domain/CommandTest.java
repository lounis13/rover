package org.canopee.rover.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    private Rover rover;

    @BeforeEach
    public void setup() {
        // Setting up a default position and orientation for the rover for each test
        rover = new Rover(new Position(0, 0), Orientation.N);
    }

    @Test
    public void should_turnLeft_when_LCommandIsExecuted() {
        Command.L.execute(rover);
        assertEquals(Orientation.W, rover.getOrientation());
    }

    @Test
    public void should_turnRight_when_RCommandIsExecuted() {
        Command.R.execute(rover);
        assertEquals(Orientation.E, rover.getOrientation());
    }

    @Test
    public void should_moveForward_when_MCommandIsExecuted_and_facingNorth() {
        Command.M.execute(rover);
        assertEquals(new Position(0, 1), rover.getPosition());
    }

}
