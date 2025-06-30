package ru.v1nga.shell;

public interface Command {
    void execute(String[] args);
    String getName();
    String getDescription();
}
