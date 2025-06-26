package ru.v1nga.app.figures;

import ru.v1nga.app.core.Color;
import ru.v1nga.app.core.Point;

public class Square extends Rectangle {

    public Square(Point point, double sideLength) {
        super(point, sideLength, sideLength);
    }

    @Override
    public void draw(Color color) {
        System.out.printf(
            "Нарисован %s квадрат, с длинной сторон %.2f на координатах %s.\n",
            color,
            this.width,
            this.point
        );
    }
}
