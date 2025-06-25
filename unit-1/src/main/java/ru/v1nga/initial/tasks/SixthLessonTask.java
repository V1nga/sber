package ru.v1nga.initial.tasks;

import java.util.Scanner;

public class SixthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Проверка на простое число";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int number = scanner.nextInt();

        System.out.println(isPrime(number) ? "Число является простым." : "Число не является простым.");
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
