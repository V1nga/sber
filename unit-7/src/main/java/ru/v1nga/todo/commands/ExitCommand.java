package ru.v1nga.todo.commands;

import ru.v1nga.todo.core.command.Command;
import ru.v1nga.todo.core.command.CommandInfo;

import java.util.Map;

@CommandInfo(name = "exit", description = "завершает работу приложения")
public class ExitCommand implements Command {

    @Override
    public void execute(Map<String, String> args) {
        System.out.println("Выход из программы...");
        System.exit(0);
    }
}
