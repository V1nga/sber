package ru.v1nga.todo.commands;

import ru.v1nga.todo.core.database.Database;
import ru.v1nga.todo.core.command.Command;
import ru.v1nga.todo.core.command.CommandInfo;
import ru.v1nga.todo.entities.TaskEntity;

import java.sql.SQLException;
import java.util.Map;

@CommandInfo(
    name = "add",
    description = "добавляет новую задачу",
    requiredArgs = { "title", "description" }
)
public class AddTaskCommand implements Command {

    @Override
    public void execute(Map<String, String> args) {
        try {
            Database database = Database.getInstance();
            TaskEntity taskEntity = database.taskRepository.save(
                new TaskEntity(0, args.get("title"), args.get("description"))
            );

            System.out.printf("Успешно добавлена задача: \"%s\"\n", taskEntity.getTitle());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
