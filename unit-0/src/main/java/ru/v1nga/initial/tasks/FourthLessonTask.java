package ru.v1nga.initial.tasks;

public class FourthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Сумма цифр числа";
    }

    @Override
    public void start() {
        int number = 374;
        int sum = Integer.toString(number)
            .chars()
            .map(digitChar -> Character.getNumericValue((char)digitChar))
            .sum();

        System.out.printf("Сумма цифр числа %d равна %d\n", number, sum);
    }
}
