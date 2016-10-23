package com.red.badger.coding.exercise;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Attila on 23/10/2016.
 */
public class MartialRobotsIT {

    URL fileName = getClass().getClassLoader().getResource("input.txt");

    @Test
    public void testForInput(){
        String result = new MartianRobots().process(new String[]{fileName.getFile()});
        assertEquals("1 1 E" + System.lineSeparator()
                + "3 3 N LOST" + System.lineSeparator()
                + "2 3 S" + System.lineSeparator() , result);
    }
}
