package ru.v1nga.todo.commands;

import ru.v1nga.todo.core.database.Database;
import ru.v1nga.todo.core.command.Command;
import ru.v1nga.todo.core.command.CommandInfo;
import ru.v1nga.todo.entities.TaskEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@CommandInfo(name = "show", description = "отображает список задач")
public class ShowTasksCommand implements Command {

    @Override
    public void execute(Map<String, String> args) {
        try {
            Database database = Database.getInstance();
            List<TaskEntity> tasks = database.taskRepository.findAll();

            if(!tasks.isEmpty()) {
                for (int i = 0; i < tasks.size(); i++) {
                    TaskEntity taskEntity = tasks.get(i);
                    System.out.printf("%d. Задача %s, Описание %s\n", (i + 1), taskEntity.getTitle(), taskEntity.getDescription());
                }
            } else {
                System.out.println("Список задач пуст");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
