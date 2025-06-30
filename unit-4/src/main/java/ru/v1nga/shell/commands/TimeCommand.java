package ru.v1nga.shell.commands;

import ru.v1nga.shell.Command;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getDescription() {
        return "выводит теĸущее время";
    }
}
