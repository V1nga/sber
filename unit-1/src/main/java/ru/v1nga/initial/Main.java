package ru.v1nga.initial;

import ru.v1nga.initial.tasks.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    private static final List<LessonTask> lessonTasks = Arrays.asList(
            new FirstLessonTask(),
            new SecondLessonTask(),
            new ThirdLessonTask(),
            new FourthLessonTask(),
            new FifthLessonTask(),
            new SixthLessonTask(),
            new SeventhLessonTask(),
            new EighthLessonTask(),
            new NinthLessonTask(),
            new TenthLessonTask()
    );

    public static void main(String[] args) {
        showMenu();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int taskId = scanner.nextInt() - 1;

            if(taskId == -1) {
                break;
            } else if (taskId < 0 || taskId > (lessonTasks.size() - 1)) {
                System.out.println("Задача с таким id не найдена!");
            } else {
                clearConsole();

                LessonTask lessonTask = lessonTasks.get(taskId);
                System.out.printf("Программа \"%s\"\n", lessonTask.getTitle());
                System.out.println();
                lessonTask.start();

                System.out.println();
                System.out.println("Чтобы открыть меню введите - 1, если хотите выйти введите любое другое число");

                if (scanner.nextInt() != 1) {
                    break;
                } else {
                    clearConsole();
                    showMenu();
                }
            }
            System.out.println();
        }
    }

    private static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("Выберите задание (введите номер): ");
        IntStream.range(0, lessonTasks.size())
                .mapToObj(index -> (index + 1) + " - " + lessonTasks.get(index).getTitle())
                .forEach(System.out::println);
        System.out.println("0 - Выйти");
        System.out.println();
    }
}
