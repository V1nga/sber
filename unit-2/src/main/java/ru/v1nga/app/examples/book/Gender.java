package ru.v1nga.app.examples.book;

public enum Gender {

    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
