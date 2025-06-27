package ru.v1nga.shell.commands;

import ru.v1nga.shell.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCommand implements Command {

    @Override
    public void execute() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String getDescription() {
        return "выводит теĸущую дату";
    }
}
