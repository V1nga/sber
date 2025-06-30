package ru.v1nga.shell.commands;

import ru.v1nga.shell.Command;

import java.util.Arrays;
import java.util.List;

public class HelpCommand implements Command {

    private final List<Command> commands;

    public HelpCommand(List<Command> commands) {
        this.commands = commands;
        this.commands.add(this);
    }

    @Override
    public void execute(String[] args)  {
        System.out.println("Принятый аргументы команды: " + Arrays.asList(args));
        System.out.println("Доступные команды:");
        commands.forEach(command -> System.out.printf("\t%s - %s\n", command.getName(), command.getDescription()));
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "выводит списоĸ доступных ĸоманд с их описанием";
    }
}
