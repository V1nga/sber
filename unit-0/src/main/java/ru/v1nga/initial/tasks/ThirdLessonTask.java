package ru.v1nga.initial.tasks;

import java.util.Scanner;

public class ThirdLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Проверка на палиндром";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String input = scanner.nextLine();

        String reversedInput = new StringBuilder(input).reverse().toString();

        System.out.println(input.equals(reversedInput) ? "Число является палиндромом." : "Число не является палиндромом.");
    }
}
