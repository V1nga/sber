package ru.v1nga.todo.core.command;

import java.util.Map;

/**
 * Интерфейс для команды, которую можно выполнить с аргументами.
 */
public interface Command {

    /**
     * Выполняет команду с указанными аргументами.
     *
     * @param args аргументы команды в виде карты ключ-значение
     */
    void execute(Map<String, String> args);
}
