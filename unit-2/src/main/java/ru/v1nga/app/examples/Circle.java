package ru.v1nga.app.examples;

public class Circle {

    public final double radius;
    public final String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return String.format("Радиус: %.2f, Цвет: %s, Плошадь: %.2f, Периметр: %.2f", this.radius, this.color, this.area(), this.perimeter());
    }
}
