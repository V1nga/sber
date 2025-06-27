package ru.v1nga.shell;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            CommandExecutor commandExecutor = new CommandExecutor();

            System.out.print("> ");
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine().toLowerCase();
                commandExecutor.executeCommand(command);
                System.out.println();
                System.out.print("> ");
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
