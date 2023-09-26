package org.canopee.rover.domain;

public enum Orientation {
    N, E, S, W;

    private static final int LEFT_ROTATION = 3;
    private static final int RIGHT_ROTATION = 1;

    public Orientation left() {
        return values()[(this.ordinal() + LEFT_ROTATION) % values().length];
    }

    public Orientation right() {
        return values()[(this.ordinal() + RIGHT_ROTATION) % values().length];
    }
}
