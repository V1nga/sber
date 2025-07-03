package ru.v1nga.todo.core.command;

import ru.v1nga.todo.commands.HelpCommand;
import ru.v1nga.todo.core.Utils;
import ru.v1nga.todo.core.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс для регистрации и выполнения команд на основе пользовательского ввода.
 */
public class CommandExecutor  {

    private final Map<String, Command> commandsMap = new LinkedHashMap<>();

    /**
     * Создает новый объект и инициализирует команды из пакета.
     * Загружает классы, аннотированные {@link CommandInfo}, и добавляет их в карту команд.
     */
    public CommandExecutor() {
        try {
            List<Class<?>> classes = Utils.getClassesFromPackage("ru.v1nga.todo.commands")
                .stream()
                .sorted((a, b) -> Boolean.compare(HelpCommand.class.isAssignableFrom(a), HelpCommand.class.isAssignableFrom(b)))
                .collect(Collectors.toList());

            for(Class<?> clazz : classes) {
                if(clazz.isAnnotationPresent(CommandInfo.class)) {
                    String commandName = clazz.getAnnotation(CommandInfo.class).name();
                    Command command;

                    if(CommandHelp.class.isAssignableFrom(clazz)) {
                        command = (Command) clazz.getConstructor(Map.class).newInstance(commandsMap);
                    } else {
                        command = (Command) clazz.getConstructor().newInstance();
                    }

                    commandsMap.put(commandName, command);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Выполняет команду на основе пользовательского ввода.
     *
     * @param input строка с именем команды и аргументами
     */
    public void executeCommand(String input) {
        try {
            String[] inputSplit = input.split(" ");

            String commandName = inputSplit[0];
            Map<String, String> commandArgs = Utils.parseArgs(Arrays.copyOfRange(inputSplit, 1, inputSplit.length));

            if(commandsMap.containsKey(commandName)) {
                Command command = commandsMap.get(commandName);
                String[] requiredCommandArgs = command.getClass().getAnnotation(CommandInfo.class).requiredArgs();

                for(String requiredArg : requiredCommandArgs) {
                    if(commandArgs.get(requiredArg) == null) {
                        throw new InvalidCommandException("Обязательный аргумент -" + requiredArg + " не найден");
                    }
                }

                command.execute(commandArgs);
            } else {
                System.out.printf("Команда \"%s\" не найдена\n", commandName);
            }
        } catch(InvalidCommandException e) {
            System.out.printf("Ошибка: %s\n", e.getMessage());
        }
    }
}
