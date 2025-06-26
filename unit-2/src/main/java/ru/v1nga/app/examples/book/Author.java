package ru.v1nga.app.examples.book;

public class Author {

    private String name;
    private String email;
    private Gender gender;

    public Author(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format(
            "Имя: %s, Пол: %s, Email: %s",
            this.name != null ? this.name : "n/a",
            this.gender != null ? this.gender : "n/a",
            this.email != null ? this.email : "n/a"
        );
    }
}
