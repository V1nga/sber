package ru.v1nga.shell.commands;

import ru.v1nga.shell.Command;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Выход из программы...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершает работу приложения";
    }
}
