package ru.v1nga.app.core;

public abstract class Figure implements Drawable {

    protected final Point point;

    public Figure(Point point) {
        this.point = point;
    }

    abstract public double area();
    abstract public double perimeter();
}
