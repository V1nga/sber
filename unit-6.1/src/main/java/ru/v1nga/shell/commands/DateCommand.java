package ru.v1nga.shell.commands;

import ru.v1nga.shell.core.Command;
import ru.v1nga.shell.core.CommandInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@CommandInfo(name = "date", description = "выводит теĸущую дату")
public class DateCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
