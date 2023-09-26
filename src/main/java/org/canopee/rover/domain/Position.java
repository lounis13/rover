package org.canopee.rover.domain;

public record Position(int x, int y) {
    public Position {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid coordinates: Coordinates cannot be negative");
        }
    }

    public Position incX() {
        return new Position(x + 1, y);
    }

    public Position incY() {
        return new Position(x, y + 1);
    }

    public Position decX() {
        return new Position(x - 1, y);
    }

    public Position decY() {
        return new Position(x, y - 1);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(x, y);
    }
}
