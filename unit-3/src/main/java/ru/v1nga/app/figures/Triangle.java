package ru.v1nga.app.figures;

import ru.v1nga.app.core.Color;
import ru.v1nga.app.core.Figure;
import ru.v1nga.app.core.Point;

public class Triangle extends Figure {

    protected final Point secondPoint;
    protected final Point thirdPoint;

    public Triangle(Point point, Point secondPoint, Point thirdPoint) {
        super(point);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double area() {
        return Math.abs(
            (
                (this.point.getX() * (this.secondPoint.getY() - this.thirdPoint.getY())) +
                (this.secondPoint.getX() * (this.thirdPoint.getY() - this.point.getY())) +
                (this.thirdPoint.getX() * (point.getY() - this.secondPoint.getY()))
            ) / 2.0
        );
    }

    @Override
    public double perimeter() {
        double abSide = calcDistance(this.point, this.secondPoint);
        double bcSide = calcDistance(this.secondPoint, this.thirdPoint);
        double caSide = calcDistance(this.thirdPoint, this.point);

        return abSide + bcSide + caSide;
    }

    @Override
    public void draw() {
        this.draw(Color.Black);
    }

    @Override
    public void draw(Color color) {
        System.out.printf(
            "Нарисован %s треугольник с точками (%s), (%s), (%s).\n",
            color,
            this.point,
            this.secondPoint,
            this.thirdPoint
        );
    }

    private double calcDistance(Point firstPoint, Point secondPoint) {
        return Math.hypot(firstPoint.getX() - secondPoint.getX(), firstPoint.getY() - secondPoint.getY());
    }
}
