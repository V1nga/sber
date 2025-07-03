package ru.v1nga.todo.repositories;

import ru.v1nga.todo.core.database.CrudRepository;
import ru.v1nga.todo.entities.TaskEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements CrudRepository<TaskEntity, Long> {

    private final Connection connection;

    public TaskRepository(Connection connection) {
        this.connection = connection;

        String sql = """
             CREATE TABLE IF NOT EXISTS tasks (
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(50),
                description VARCHAR(255)
             )
         """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        long entityId = taskEntity.getId();

        if(taskEntity.getId() > 0 && existsById(taskEntity.getId())) {
            String sql = "MERGE INTO tasks (id, title, description) KEY(id) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setLong(1, taskEntity.getId());
                statement.setString(2, taskEntity.getTitle());
                statement.setString(3, taskEntity.getDescription());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            String sql = "INSERT INTO tasks (title, description) VALUES (?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, taskEntity.getTitle());
                statement.setString(2, taskEntity.getDescription());
                statement.executeUpdate();

                ResultSet keys = statement.getGeneratedKeys();
                keys.first();

                entityId = keys.getLong(1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return new TaskEntity(entityId, taskEntity.getTitle(), taskEntity.getDescription());
    }

    @Override
    public List<TaskEntity> saveAll(List<TaskEntity> entities) {
        List<TaskEntity> saved = new ArrayList<>();

        for (TaskEntity entity : entities) {
            saved.add(save(entity));
        }

        return saved;
    }

    @Override
    public Optional<TaskEntity> findById(Long id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(
                    new TaskEntity(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                    )
                );
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT 1 FROM tasks WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaskEntity> findAll() {
        String sql = "SELECT * FROM tasks";
        List<TaskEntity> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result.add(
                    new TaskEntity(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                    )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM tasks";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet.next() ? resultSet.getLong(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(TaskEntity entity) {
        deleteById(entity.getId());
    }

    public Optional<TaskEntity> findByTitle(String title) {
        String sql = "SELECT * FROM tasks WHERE title = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(
                    new TaskEntity(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                    )
                );
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
