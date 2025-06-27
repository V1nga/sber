package ru.v1nga.shell;

import ru.v1nga.shell.commands.*;

import java.util.*;

public class CommandExecutor  {

    private final Map<String, Command> commandsMap = new LinkedHashMap<>();

    public CommandExecutor() throws InstantiationException, IllegalAccessException {
        List<Command> commands = new ArrayList<Command>(){{
            add(new DateCommand());
            add(new TimeCommand());
            add(new PwdCommand());
            add(new ExitCommand());
        }};
        commands.add(new HelpCommand(commands));
        commands.forEach(command -> commandsMap.put(command.getName(), command));
    }

    public void executeCommand(String commandName) {
        if(commandsMap.containsKey(commandName)) {
            commandsMap.get(commandName).execute();
        } else {
            System.out.printf("Команда \"%s\" не найдена\n", commandName);
        }
    }
}
