package com.red.badger.coding.exercise;

import com.red.badger.coding.exercise.command.Command;
import com.red.badger.coding.exercise.command.SimpleCommand;
import com.red.badger.coding.exercise.location.Direction;
import com.red.badger.coding.exercise.location.Planet;
import com.red.badger.coding.exercise.location.Position;
import com.red.badger.coding.exercise.robot.Robot;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Attila on 22/10/2016.
 */
public class MartianRobots {

    public static void main(String[] args){
        String result = new MartianRobots().process(args);
        System.out.println(result);
    }

    public String process(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            Planet mars = createPlanet(scanner.nextLine());
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(!line.trim().isEmpty()) {
                    Robot robot = createRobot(line, mars);
                    robot.executeCommands(parseCommands(scanner.nextLine()));
                    builder.append(robot).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file.");
        }
        return builder.toString();
    }

    private Planet createPlanet(String input) {
        String[] coords = input.split(" ");
        if(coords.length != 2) {
            throw new IllegalArgumentException("Wrong number of parameter provided for planet size.");
        }
        return new Planet(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

    private Robot createRobot(String input, Planet planet) {
        String[] parameters = input.split(" ");
        if(parameters.length != 3) {
            throw new IllegalArgumentException("Wrong number of parameter provided for robot.");
        }
        Position startPosition = new Position(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Direction startDirection = Direction.findByInput(parameters[2].charAt(0));
        return new Robot(startPosition, startDirection, planet);
    }

    private List<Command> parseCommands(String input) {
        return input.chars().mapToObj(c -> SimpleCommand.findByInput((char) c)).collect(Collectors.toList());
    }
}
