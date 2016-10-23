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

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void moveForeward() {
        Position newPosition = new Position(position.getX() + direction.getDeltaX(), position.getY() + direction.getDeltaY());
        if(planet.isWithinBorder(newPosition)) {
            position = newPosition;
        } else if(!planet.isScented(position)){
            planet.addScent(position);
            lost = true;
        }
    }

    public void executeCommand(Command command){
        if(!lost) {
            switch (command) {
                case LEFT: turnLeft(); break;
                case RIGHT: turnRight(); break;
                case FORWARD: moveForeward();break;
            }
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
