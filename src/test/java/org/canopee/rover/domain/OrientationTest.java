package org.canopee.rover.domain;

import org.junit.jupiter.api.Test;

import static org.canopee.rover.domain.Orientation.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrientationTest {

    @Test
    void should_return_W_when_turnLeft_from_N() {
        assertEquals(W, N.left());
    }

    @Test
    void should_return_E_when_turnRight_from_N() {
        assertEquals(E, N.right());
    }

    @Test
    void should_return_N_when_turnLeft_from_E() {
        assertEquals(N, E.left());
    }

    @Test
    void should_return_S_when_turnRight_from_E() {
        assertEquals(S, E.right());
    }

    @Test
    void should_return_E_when_turnLeft_from_S() {
        assertEquals(E, S.left());
    }

    @Test
    void should_return_W_when_turnRight_from_S() {
        assertEquals(W, S.right());
    }

    @Test
    void should_return_S_when_turnLeft_from_W() {
        assertEquals(S, W.left());
    }

    @Test
    void should_return_N_when_turnRight_from_W() {
        assertEquals(N, W.right());
    }
}
