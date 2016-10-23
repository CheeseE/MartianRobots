package com.red.badger.coding.exercise.location;

/**
 * Created by Attila on 21/10/2016.
 */
public class Position {

    private final int x;
    private final int y;

    public Position (int x, int y){

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position moveInDirection(Direction direction){
        return new Position(x + direction.getDeltaX(), y + direction.getDeltaY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
