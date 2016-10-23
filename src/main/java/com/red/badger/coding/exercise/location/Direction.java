package com.red.badger.coding.exercise.location;

import java.util.Arrays;

/**
 * Created by Attila on 21/10/2016.
 */
public enum Direction {

    NORTH('N', 0, 1),
    EAST('E', 1, 0),
    SOUTH('S', 0, -1),
    WEST('W', -1, 0);

    private char input;
    private int deltaX;
    private int deltaY;

    Direction(char input, int deltaX, int deltaY) {

        this.input = input;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public Direction turnRight() {
        return values()[(ordinal() + 1) % 4];
    }

    public Direction turnLeft() {
        return values()[(ordinal() + 3) % 4];
    }

    public static Direction findByInput(char val) {
        return Arrays.stream(Direction.values())
                .filter(e -> e.input == val)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", val)));
    }

    public char getInput() {
        return input;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
