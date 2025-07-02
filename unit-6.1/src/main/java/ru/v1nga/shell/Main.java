package ru.v1nga.shell;

import ru.v1nga.shell.core.CommandExecutor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();

        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().toLowerCase();
            commandExecutor.executeCommand(command);
            System.out.println();
            System.out.print("> ");
        }
    }
}
