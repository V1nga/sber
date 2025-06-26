package ru.v1nga.app.examples;

import java.util.Arrays;
import java.util.List;

public class Phone {

    private String number;
    private String model;
    private double weight;

    public Phone() {

    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public String getNumber() {
        return this.number;
    }

    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.printf("Звонит %s (%s)\n", callerNumber, callerName);
    }

    public void sendMessage() {
        List<String> contacts = Arrays.asList(
            "+7 (901) 123-45-67",
            "+7 (915) 234-56-78",
            "+7 (926) 345-67-89",
            "+7 (937) 456-78-90",
            "+7 (948) 567-89-01",
            "+7 (960) 678-90-12",
            "+7 (971) 789-01-23",
            "+7 (982) 890-12-34",
            "+7 (993) 901-23-45",
            "+7 (904) 012-34-56"
        );
        contacts.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return String.format(
            "Модель: %s, Вес: %s, Номер: %s",
            this.model != null ? this.model : "n/a",
            this.weight != 0 ? this.weight + "г." : "n/a",
            this.number != null ? this.number : "n/a"
        );
    }
}
