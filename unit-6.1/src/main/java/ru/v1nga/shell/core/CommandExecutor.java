package ru.v1nga.shell.core;

import ru.v1nga.shell.commands.HelpCommand;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

public class CommandExecutor  {

    private final Map<String, Command> commandsMap = new LinkedHashMap<>();

    public CommandExecutor() {
        try {
            List<Class<?>> classes = Utils.getClassesFromPackage("ru.v1nga.shell.commands")
                .stream()
                .sorted((a, b) -> Boolean.compare(HelpCommand.class.isAssignableFrom(a), HelpCommand.class.isAssignableFrom(b)))
                .collect(Collectors.toList());

            for(Class<?> clazz : classes) {
                if(clazz.isAnnotationPresent(CommandInfo.class)) {
                    String commandName = clazz.getAnnotation(CommandInfo.class).name();
                    Command command;

                    if(CommandHelp.class.isAssignableFrom(clazz)) {
                        command = (Command) clazz.getConstructor(Map.class).newInstance(commandsMap);
                    } else {
                        command = (Command) clazz.getConstructor().newInstance();
                    }

                    commandsMap.put(commandName, command);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void executeCommand(String input) {
        String[] inputSplit = input.split(" ");

        String commandName = inputSplit[0];
        String[] commandArgs = Arrays.copyOfRange(inputSplit, 1, inputSplit.length);

        if(commandsMap.containsKey(commandName)) {
            commandsMap.get(commandName).execute(commandArgs);
        } else {
            System.out.printf("Команда \"%s\" не найдена\n", commandName);
        }
    }
}
