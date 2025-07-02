package ru.v1nga.shell.commands;

import ru.v1nga.shell.core.Command;
import ru.v1nga.shell.core.CommandInfo;

import java.nio.file.Paths;

@CommandInfo(name = "pwd", description = "выводит теĸущий рабочий ĸаталог.")
public class PwdCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println(Paths.get("").toAbsolutePath());
    }
}
