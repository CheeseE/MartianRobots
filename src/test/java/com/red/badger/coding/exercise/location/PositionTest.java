package com.red.badger.coding.exercise.location;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Attila on 23/10/2016.
 */
public class PositionTest {

    @Test
    public void moveInDirectionEast() throws Exception {
        Position position = new Position(1,1);
        Position result = position.moveInDirection(Direction.EAST);
        assertEquals(2, result.getX());
        assertEquals(1, result.getY());
    }

    @Test
    public void moveInDirectionWest() throws Exception {
        Position position = new Position(1,1);
        Position result = position.moveInDirection(Direction.WEST);
        assertEquals(0, result.getX());
        assertEquals(1, result.getY());
    }

    @Test
    public void moveInDirectionNorth() throws Exception {
        Position position = new Position(1,1);
        Position result = position.moveInDirection(Direction.NORTH);
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
    }

    @Test
    public void moveInDirectionSouth() throws Exception {
        Position position = new Position(1,1);
        Position result = position.moveInDirection(Direction.SOUTH);
        assertEquals(1, result.getX());
        assertEquals(0, result.getY());
    }

}