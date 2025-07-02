package ru.v1nga.shell.commands;

import ru.v1nga.shell.core.Command;
import ru.v1nga.shell.core.CommandInfo;

@CommandInfo(name = "exit", description = "завершает работу приложения")
public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Выход из программы...");
        System.exit(0);
    }
}
