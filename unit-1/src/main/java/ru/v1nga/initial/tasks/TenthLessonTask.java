package ru.v1nga.initial.tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TenthLessonTask implements LessonTask {

    @Override
    public String getTitle() {
        return "Перевод в римские цифры";
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число от 1 до 100: ");
        int number = scanner.nextInt();

        if (number < 1 || number > 100) {
            System.out.println("Число должно быть от 1 до 100!");
            return;
        }

        String romanNumber = convertToRoman(number);
        System.out.println("Римская запись: " + romanNumber);
    }

    private String convertToRoman(int number) {
        Map<Integer, String> romanDictionary = new LinkedHashMap<>();
        romanDictionary.put(100, "C");
        romanDictionary.put(90, "XC");
        romanDictionary.put(50, "L");
        romanDictionary.put(40, "XL");
        romanDictionary.put(10, "X");
        romanDictionary.put(9, "IX");
        romanDictionary.put(5, "V");
        romanDictionary.put(4, "IV");
        romanDictionary.put(1, "I");

        StringBuilder romanNumber = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanDictionary.entrySet()) {
            int arabicValue = entry.getKey();
            String romanSymbol = entry.getValue();

            while (number >= arabicValue) {
                romanNumber.append(romanSymbol);
                number -= arabicValue;
            }
        }

        return romanNumber.toString();
    }
}
