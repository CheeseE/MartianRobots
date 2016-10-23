package com.red.badger.coding.exercise.location;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Attila on 21/10/2016.
 */
public class Planet {

    private final int sizeX;
    private final int sizeY;
    private Set<Position> scent;

    public Planet(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.scent = new HashSet<Position>();
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public boolean isWithinBorder(Position position) {
        return (position.getX() >= 0 && position.getX() <= sizeX && position.getY() >= 0 && position.getY() <= sizeY);
    }

    public boolean isScented(Position position) {
        return scent.contains(position);
    }

    public void addScent(Position position) {
        scent.add(position);
    }
}
