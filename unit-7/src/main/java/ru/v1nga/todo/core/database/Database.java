package ru.v1nga.todo.core.database;

import ru.v1nga.todo.repositories.TaskRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton класс для доступа к базе данных и репозиториям.
 */
public class Database {

    private static final String URL = "jdbc:h2:mem:taskmanager";
    private static final String USER = "v1nga";
    private static final String PASSWORD = "";
    private static Database instance;

    public TaskRepository taskRepository;


    /**
     * Приватный конструктор с инициализацией репозиториев.
     *
     * @param taskRepository репозиторий задач
     */
    private Database(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Получает экземпляр базы данных. При первом вызове инициализирует соединение.
     *
     * @return экземпляр {@link Database}
     * @throws SQLException если не удаётся установить соединение
     */
    public static Database getInstance() throws SQLException {
        if(instance == null) {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return instance = new Database(new TaskRepository(connection));
        }

        return instance;
    }
}
