package ru.v1nga.initial.tasks;

import java.util.Random;
import java.util.Scanner;

public class EighthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Угадай букву";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char secretLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(26));

        System.out.println("Секретная буква (для теста): " + secretLetter);;
        System.out.println("Угадайте букву от A до Z!");

        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toUpperCase();

            char userLetter = input.charAt(0);

            if (userLetter == secretLetter) {
                System.out.println("Right!");
                break;
            } else if (userLetter < secretLetter) {
                System.out.println("You're too low");
            } else {
                System.out.println("You're too high");
            }
        }
    }
}
