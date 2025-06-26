package ru.v1nga.app;

import ru.v1nga.app.examples.Circle;
import ru.v1nga.app.examples.Matrix;
import ru.v1nga.app.examples.Phone;
import ru.v1nga.app.examples.book.Author;
import ru.v1nga.app.examples.book.Book;
import ru.v1nga.app.examples.book.Gender;
import ru.v1nga.app.examples.pizza.PizzaOrder;
import ru.v1nga.app.examples.pizza.PizzaSize;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Phone> phones = Arrays.asList(
            new Phone("+7 (921) 235-05-79", "IPhone XR", 194),
            new Phone("+7 (921) 231-28-18", "Xiaomi 10c"),
            new Phone()
        );
        phones.forEach(phone -> {
            System.out.println("Номер телефона: " + phone.getNumber());
            System.out.println(phone);
            phone.receiveCall("Александр");
            phone.receiveCall("Александр", "+7 (921) 234-05-79");
            phone.sendMessage();
            System.out.println();
        });



        System.out.println();
        System.out.println();
        System.out.println();



        Circle circle = new Circle(7, "Красный");
        System.out.println(circle);



        System.out.println();
        System.out.println();
        System.out.println();



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



        System.out.println();
        System.out.println();
        System.out.println();



        Author golyginaElena = new Author("Голыгина Елена", "golygina@email.com", Gender.FEMALE);
        System.out.println(golyginaElena);

        Author shitovAlexandr = new Author(null, null, null);
        shitovAlexandr.setName("Шитов Александр");
        shitovAlexandr.setGender(Gender.MALE);
        System.out.println(shitovAlexandr);

        System.out.println();

        Book javaSeBook = new Book("Java SE", 2024, golyginaElena);
        System.out.println(javaSeBook);

        Book springBootBook = new Book(null, 0, null);
        springBootBook.setName("Spring Booot");
        springBootBook.setAuthor(shitovAlexandr);
        System.out.println(springBootBook);



        System.out.println();
        System.out.println();
        System.out.println();



        PizzaOrder pizzaOrder = new PizzaOrder("С копчёностями", PizzaSize.BIG, true, "Козленская 113");

        pizzaOrder.order();
        pizzaOrder.order();

        System.out.println(pizzaOrder);

        pizzaOrder.cancel();
        pizzaOrder.cancel();

        pizzaOrder.setName("Маргарита");
        pizzaOrder.setSize(PizzaSize.MEDIUM);
        pizzaOrder.setWithSauce(false);
        pizzaOrder.setAddress("Ленина 5");

        pizzaOrder.order();
        System.out.println(pizzaOrder);
    }
}
