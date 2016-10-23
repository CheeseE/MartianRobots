package com.red.badger.coding.exercise.command;

import com.red.badger.coding.exercise.robot.Robot;

import java.util.Arrays;

/**
 * Created by Attila on 21/10/2016.
 */
public enum SimpleCommand implements Command{

    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    private char input;

    SimpleCommand(char input){
        this.input = input;
    }

    @Override
    public void execute(Robot robot) {
        switch (this) {
            case LEFT:
                robot.turnLeft();
                break;
            case RIGHT:
                robot.turnRight();
                break;
            case FORWARD:
                robot.moveForeward();
                break;
        }
    }

    public static SimpleCommand findByInput(char val) {
        return Arrays.stream(SimpleCommand.values())
                .filter(e -> e.input == val)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", val)));
    }
}
