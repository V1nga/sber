package ru.v1nga.todo.commands;

import ru.v1nga.todo.core.command.Command;
import ru.v1nga.todo.core.command.CommandHelp;
import ru.v1nga.todo.core.command.CommandInfo;
import java.util.Map;

@CommandInfo(name = "help", description = "выводит списоĸ доступных ĸоманд с их описанием")
public class HelpCommand implements CommandHelp {

    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Map<String, String> args) {
        System.out.println("Доступные команды:");
        commands
            .forEach((commandName, command) ->
                System.out.printf("\t%s - %s\n", commandName, command.getClass().getAnnotation(CommandInfo.class).description())
            );
    }
}
