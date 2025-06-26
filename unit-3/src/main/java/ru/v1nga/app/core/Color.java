package ru.v1nga.app.core;

public enum Color {

    Red("красный"),
    Green("зелёный"),
    Blue("синий"),
    White("белый"),
    Black("чёрный");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
