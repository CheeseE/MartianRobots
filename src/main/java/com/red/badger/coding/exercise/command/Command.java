package com.red.badger.coding.exercise.command;

import java.util.Arrays;

/**
 * Created by Attila on 21/10/2016.
 */
public enum Command {

    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    private char input;

    Command(char input){
        this.input = input;
    }

    public static Command findByInput(char val) {
        return Arrays.stream(Command.values())
                .filter(e -> e.input == val)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", val)));
    }
}
