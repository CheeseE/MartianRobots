package com.red.badger.coding.exercise.robot;

import com.red.badger.coding.exercise.location.Direction;
import com.red.badger.coding.exercise.location.Planet;
import com.red.badger.coding.exercise.location.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Attila on 23/10/2016.
 */
public class RobotTest {

    Planet planet = new Planet(2,2);

    @Test
    public void testMoveForward(){
        Robot robot = new Robot(new Position(0,0), Direction.EAST, planet);
        robot.moveForeward();
        assertEquals("1 0 E", robot.toString());
        robot.moveForeward();
        assertEquals("2 0 E", robot.toString());
        robot.moveForeward();
        assertEquals("2 0 E LOST", robot.toString());
        assertTrue(planet.isScented(new Position(2,0)));
    }

    @Test
    public void testTrunLeft(){
        Robot robot = new Robot(new Position(0,0), Direction.EAST, planet);
        robot.turnLeft();
        assertEquals("0 0 N", robot.toString());

    }

    @Test
    public void testTrunRight(){
        Robot robot = new Robot(new Position(0,0), Direction.EAST, planet);
        robot.turnRight();
        assertEquals("0 0 S", robot.toString());

    }
}