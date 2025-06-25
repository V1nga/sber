package ru.v1nga.initial.tasks;

import java.util.Scanner;

public class FifthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Вес на Луне";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваш вес на Земле (в килограммах): ");
        double earthWeight = scanner.nextDouble();

        double moonWeight = earthWeight * 0.17;

        System.out.printf("Ваш вес на Луне составляет примерно %.2f кг.\n", moonWeight);
    }
}
