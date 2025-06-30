package ru.v1nga.shell;

import ru.v1nga.shell.commands.*;

import java.util.*;

public class CommandExecutor  {

    private final Map<String, Command> commandsMap = new LinkedHashMap<>();

    public CommandExecutor() {
        DateCommand dateCommand = new DateCommand();
        TimeCommand timeCommand = new TimeCommand();
        PwdCommand pwdCommand = new PwdCommand();
        ExitCommand exitCommand = new ExitCommand();

        commandsMap.put(dateCommand.getName(), dateCommand);
        commandsMap.put(timeCommand.getName(), timeCommand);
        commandsMap.put(pwdCommand.getName(), pwdCommand);
        commandsMap.put(exitCommand.getName(), exitCommand);

        HelpCommand helpCommand = new HelpCommand(new ArrayList<>(commandsMap.values()));
        commandsMap.put(helpCommand.getName(), helpCommand);
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
