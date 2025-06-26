package ru.v1nga.app.figures;

import ru.v1nga.app.core.Color;
import ru.v1nga.app.core.Figure;
import ru.v1nga.app.core.Point;

public class Rectangle extends Figure {

    protected final double width;
    protected final double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }

    @Override
    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public void draw() {
        this.draw(Color.Black);
    }

    @Override
    public void draw(Color color) {
        System.out.printf(
            "Нарисован %s прямоугольник, шириной %.2f и высотой %.2f на координатах %s.\n",
            color,
            this.width,
            this.height,
            this.point
        );
    }
}
