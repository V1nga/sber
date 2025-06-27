package ru.v1nga.shell.commands;

import ru.v1nga.shell.Command;

import java.nio.file.Paths;

public class PwdCommand implements Command {

    @Override
    public void execute() {
        System.out.println(Paths.get("").toAbsolutePath());
    }

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public String getDescription() {
        return "выводит теĸущий рабочий ĸаталог.";
    }
}
