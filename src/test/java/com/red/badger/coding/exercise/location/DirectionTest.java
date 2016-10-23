package com.red.badger.coding.exercise.location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Attila on 21/10/2016.
 */
public class DirectionTest {

    @Test
    public void testTurnRightFromEast() throws Exception {
        Direction east = Direction.EAST;
        assertEquals(Direction.SOUTH, east.turnRight());
    }

    @Test
    public void testTurnRightFromWest() throws Exception {
        Direction east = Direction.WEST;
        assertEquals(Direction.NORTH, east.turnRight());
    }

    @Test
    public void testTurnLeftFromNorth() throws Exception {
        Direction east = Direction.NORTH;
        assertEquals(Direction.WEST, east.turnLeft());
    }

    @Test
    public void testTurnLeftFromEast() throws Exception {
        Direction east = Direction.EAST;
        assertEquals(Direction.NORTH, east.turnLeft());
    }

    @Test(expected = IllegalStateException.class)
    public void testFindByInputThrowsException() throws Exception {
        Direction.findByInput('X');
    }

    @Test
    public void testFindByInput() throws Exception {
        assertEquals(Direction.EAST, Direction.findByInput('E'));
    }
}