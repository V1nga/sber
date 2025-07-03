package ru.v1nga.todo.commands;

import ru.v1nga.todo.core.database.Database;
import ru.v1nga.todo.core.command.Command;
import ru.v1nga.todo.core.command.CommandInfo;
import ru.v1nga.todo.entities.TaskEntity;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@CommandInfo(
    name = "done",
    description = "завершает задачу",
    requiredArgs = { "title" }
)
public class DoneTaskCommand implements Command {

    @Override
    public void execute(Map<String, String> args) {
        try {
            String title = args.get("title");
            Database database = Database.getInstance();
            Optional<TaskEntity> taskEntityOptional = database.taskRepository.findByTitle(title);

            if(taskEntityOptional.isPresent()) {
                database.taskRepository.deleteById(taskEntityOptional.get().getId());
                System.out.println("Задача успешно закрыта");
            } else {
                System.out.printf("Запись \"%s\" не найдена", title);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
