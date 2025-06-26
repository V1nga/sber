package ru.v1nga.app.figures;

import ru.v1nga.app.core.Color;
import ru.v1nga.app.core.Figure;
import ru.v1nga.app.core.Point;

public class Circle extends Figure {

    protected final double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI) * this.radius;
    }

    @Override
    public void draw() {
        this.draw(Color.Black);
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s круг, с радиусом %.2f на координатах %s.\n", color, this.radius, this.point);
    }
}
