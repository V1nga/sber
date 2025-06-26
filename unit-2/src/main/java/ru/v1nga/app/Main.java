package ru.v1nga.app;

import ru.v1nga.app.examples.Circle;
import ru.v1nga.app.examples.Matrix;
import ru.v1nga.app.examples.Phone;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List<Phone> phones = Arrays.asList(
//            new Phone("+7 (921) 235-05-79", "IPhone XR", 194),
//            new Phone("+7 (921) 231-28-18", "Xiaomi 10c"),
//            new Phone()
//        );
//        phones.forEach(phone -> {
//            System.out.println("Номер телефона: " + phone.getNumber());
//            System.out.println(phone);
//            phone.receiveCall("Александр");
//            phone.receiveCall("Александр", "+7 (921) 234-05-79");
//            phone.sendMessage();
//            System.out.println();
//        });

//        Circle circle = new Circle(7, "Красный");
//        System.out.println(circle);

        // Создание двух матриц 2x2
        Matrix matrixFirst = new Matrix(2, 2);
        matrixFirst.setValue(0, 0, 1);
        matrixFirst.setValue(0, 1, 2);
        matrixFirst.setValue(1, 0, 3);
        matrixFirst.setValue(1, 1, 4);

        Matrix matrixSecond = new Matrix(2, 2);
        matrixSecond.setValue(0, 0, 5);
        matrixSecond.setValue(0, 1, 6);
        matrixSecond.setValue(1, 0, 7);
        matrixSecond.setValue(1, 1, 8);

        System.out.println("Матрица 1:");
        matrixFirst.print();

        System.out.println("Матрица 2:");
        matrixSecond.print();

        Matrix sum = matrixFirst.add(matrixSecond);
        System.out.println("Сумма:");
        if (sum != null) {
            sum.print();
        }

        Matrix scaled = matrixFirst.multiplyByScalar(2);
        System.out.println("Матрица 1, умноженная на 2:");
        scaled.print();

        Matrix product = matrixFirst.multiply(matrixSecond);
        System.out.println("Произведение матриц:");
        if (product != null) {
            product.print();
        }
    }
}
