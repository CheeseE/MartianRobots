package com.red.badger.coding.exercise.robot;

import com.red.badger.coding.exercise.command.Command;
import com.red.badger.coding.exercise.location.Direction;
import com.red.badger.coding.exercise.location.Planet;
import com.red.badger.coding.exercise.location.Position;

import java.util.List;

/**
 * Created by Attila on 21/10/2016.
 */
public class Robot {

    private Position position;
    private Direction direction;
    private Planet planet;
    private boolean lost = false;

    public Robot(Position position, Direction direction, Planet grid) {

        this.position = position;
        this.direction = direction;
        this.planet = grid;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void moveForeward() {
        Position newPosition = position.moveInDirection(direction);
        if (planet.isWithinBorder(newPosition)) {
            position = newPosition;
        } else if (!planet.isScented(position)) {
            planet.addScent(position);
            lost = true;
        }
    }

    public void executeCommand(Command command) {
        if (!lost) {
            command.execute(this);
        }
    }

    public void executeCommands(List<Command> commands) {
        commands.forEach(c -> executeCommand(c));
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction.getInput() + (lost ? " LOST" : "");
    }
}
