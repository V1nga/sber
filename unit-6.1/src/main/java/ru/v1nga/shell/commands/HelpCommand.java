package ru.v1nga.shell.commands;

import ru.v1nga.shell.core.Command;
import ru.v1nga.shell.core.CommandInfo;
import ru.v1nga.shell.core.CommandHelp;

import java.util.*;

@CommandInfo(name = "help", description = "выводит списоĸ доступных ĸоманд с их описанием")
public class HelpCommand implements CommandHelp {

    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args)  {
        System.out.println("Принятые аргументы команды: " + Arrays.asList(args));
        System.out.println("Доступные команды:");
        commands
            .forEach((commandName, command) ->
                System.out.printf("\t%s - %s\n", commandName, command.getClass().getAnnotation(CommandInfo.class).description())
            );
    }
}
