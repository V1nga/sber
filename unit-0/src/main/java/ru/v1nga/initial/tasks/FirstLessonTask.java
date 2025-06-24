package ru.v1nga.initial.tasks;

public class FirstLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Hello World";
    }

    @Override
    public void start() {
        System.out.println("Hello World!");
    }
}
