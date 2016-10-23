package com.red.badger.coding.exercise.location;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Attila on 23/10/2016.
 */
public class PlanetTest {

    @Test
    public void isWithinBorder() throws Exception {
        Planet planet = new Planet(2,2);
        assertTrue(planet.isWithinBorder(new Position(0,0)));
    }

    @Test
    public void isNotWithinBorder() throws Exception {
        Planet planet = new Planet(2,2);
        assertFalse(planet.isWithinBorder(new Position(3,-1)));
    }

    @Test
    public void isScented() throws Exception {
        Planet planet = new Planet(2,2);
        Position scent = new Position(1, 1);
        planet.addScent(scent);
        assertTrue(planet.isScented(scent));
        assertFalse(planet.isScented(new Position(0,0)));

    }

}