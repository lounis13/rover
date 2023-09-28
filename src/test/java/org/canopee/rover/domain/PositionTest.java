package org.canopee.rover.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void should_throwIllegalArgumentException_when_negativeXCoordinateIsGiven() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
    }

    @Test
    void should_throwIllegalArgumentException_when_negativeYCoordinateIsGiven() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0, -1));
    }

    @Test
    void should_returnNewPositionWithIncrementedX_when_incXIsCalled() {
        Position initialPosition = new Position(1, 1);
        Position incrementedPosition = initialPosition.moveRight();

        assertEquals(new Position(2, 1), incrementedPosition);
    }

    @Test
    void should_returnNewPositionWithIncrementedY_when_incYIsCalled() {
        Position initialPosition = new Position(1, 1);
        Position incrementedPosition = initialPosition.moveUp();

        assertEquals(new Position(1, 2), incrementedPosition);
    }

    @Test
    void should_returnNewPositionWithDecrementedX_when_decXIsCalled() {
        Position initialPosition = new Position(1, 1);
        Position decrementedPosition = initialPosition.moveLeft();

        assertEquals(new Position(0, 1), decrementedPosition);
    }

    @Test
    void should_returnNewPositionWithDecrementedY_when_decYIsCalled() {
        Position initialPosition = new Position(1, 1);
        Position decrementedPosition = initialPosition.moveDown();

        assertEquals(new Position(1, 0), decrementedPosition);
    }
}
