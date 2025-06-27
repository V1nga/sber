package ru.v1nga.shell;

public interface Command {
    void execute();
    String getName();
    String getDescription();
}
