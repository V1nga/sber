package ru.v1nga.app.examples.book;

public class Book {

    private String name;
    private int year;
    private Author author;

    public Book(String name, int year, Author author) {
        this.name = name;
        this.year = year;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
            "Название: %s, Год: %s, Автор: %s",
            this.name != null ? this.name : "n/a",
            this.year != 0 ? this.year : "n/a",
            this.author != null && this.author.getName() != null ? this.author.getName() : "n/a"
        );
    }
}
