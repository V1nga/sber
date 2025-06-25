package ru.v1nga.initial.tasks;

import java.util.Scanner;

public class SeventhLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Последовательность Фибоначчи";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Введите количество чисел Фибоначчи (от 3 до 99): ");
            number = scanner.nextInt();
        } while (number <= 2 || number >= 100);

        int a = 0;
        int b = 1;

        System.out.printf("Последовательность Фибоначчи: %d %d\n", a, b);

        for (int i = 3; i <= number; i++) {
            int prev = b;
            int next = a + prev;
            System.out.print(" " + next);
            a = prev;
            b = next;
        }
        System.out.println();
    }
}
