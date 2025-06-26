package ru.v1nga.app;

import ru.v1nga.app.core.Color;
import ru.v1nga.app.core.Figure;
import ru.v1nga.app.core.Point;
import ru.v1nga.app.figures.Circle;
import ru.v1nga.app.figures.Rectangle;
import ru.v1nga.app.figures.Square;
import ru.v1nga.app.figures.Triangle;
import ru.v1nga.app.utils.FigureUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PaintExample {

    public static void main(String[] args) {
        List<Figure> figures = Arrays.asList(
            new Circle(new Point(1, 1), 5),
            new Rectangle(new Point(0, 0), 10, 4),
            new Square(new Point(3, 3), 6),
            new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, 3))
        );
        figures.forEach(figure -> {
            FigureUtil.draw(figure);
            System.out.println("Площадь: " + FigureUtil.area(figure));
            System.out.println("Периметр: " + FigureUtil.perimeter(figure));
            System.out.println();
        });

        System.out.println("Отрисовка фигур случайными цветами:");
        Random random = new Random();

        figures.forEach(figure -> {
            Color[] colors = Color.class.getEnumConstants();
            Color randomColor = colors[random.nextInt(colors.length)];

            FigureUtil.draw(figure, randomColor);
        });
    }
}
