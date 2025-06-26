package ru.v1nga.app.examples.pizza;

public enum PizzaSize {

    SMALL("Маленькая"),
    MEDIUM("Средняя"),
    BIG("Большая");

    private final String name;

    PizzaSize(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
