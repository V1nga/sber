package ru.v1nga.initial.tasks;

public class SecondLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Деление с остатком";
    }

    @Override
    public void start() {
        int a = 21;
        int b = 8;
        int c = a / b;
        int d = a % b;

        System.out.printf("%d / %d = %d и %d в остатке\n", a, b, c, d);
    }
}
