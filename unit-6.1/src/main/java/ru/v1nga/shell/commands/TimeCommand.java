package ru.v1nga.shell.commands;

import ru.v1nga.shell.core.Command;
import ru.v1nga.shell.core.CommandInfo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@CommandInfo(name = "time", description = "выводит теĸущее время")
public class TimeCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
