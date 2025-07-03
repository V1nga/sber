package ru.v1nga.todo.entities;

public class TaskEntity {

    private final long id;
    private final String title;
    private final String description;

    public TaskEntity(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }
}
