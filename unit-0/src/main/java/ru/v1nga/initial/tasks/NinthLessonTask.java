package ru.v1nga.initial.tasks;

import java.util.Scanner;

public class NinthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Квадратное уравнение";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффициенты a, b и c квадратного уравнения ax² + bx + c = 0:");

        System.out.print("a = ");
        double a = scanner.nextDouble();

        System.out.print("b = ");
        double b = scanner.nextDouble();

        System.out.print("c = ");
        double c = scanner.nextDouble();

        double discriminant = Math.pow(b, 2) - (4 * a * c);

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("Уравнение имеет два корня: x1 = %.2f и x2 = %.2f\n", x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.printf("Уравнение имеет один корень: x = %.2f\n", x);
        } else {
            System.out.println("Уравнение не имеет вещественных корней.");
        }
    }
}
