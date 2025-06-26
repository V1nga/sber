package ru.v1nga.app.examples.pizza;

public class PizzaOrder {

    private String name;
    private PizzaSize size;
    private boolean withSauce;
    private String address;
    private boolean isOrdered;

    public PizzaOrder(String name, PizzaSize size, boolean withSauce, String address) {
        this.name = name;
        this.size = size;
        this.withSauce = withSauce;
        this.address = address;
        this.isOrdered = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public boolean isWithSauce() {
        return withSauce;
    }

    public void setWithSauce(boolean withSauce) {
        this.withSauce = withSauce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void order() {
        if (this.isOrdered) {
            System.out.println("Заказ уже был принят ранее.");
        } else {
            this.isOrdered = true;
            String sauce = withSauce ? "с соусом" : "без соуса";
            System.out.printf("Заказ принят. %s пицца \"%s\" %s на адрес %s.\n", this.size, this.name, sauce, this.address);
        }
    }

    public void cancel() {
        if (this.isOrdered) {
            this.isOrdered = false;
            System.out.println("Заказ отменён.");
        } else {
            System.out.println("Заказ ещё не был принят.");
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Название: %s, Размер: %s, Соус: %s, Адрес: %s, Принят: %s",
            this.name != null ? this.name : "n/a",
            this.size != null ? this.size : "n/a",
            this.withSauce ? "Да" : "Нет",
            this.address != null ? this.address : "n/a",
            this.isOrdered ? "Да" : "Нет"
        );
    }
}
