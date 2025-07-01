package ru.v1nga.app.textprocessor.readers;

import ru.v1nga.app.textprocessor.core.TextReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code FileTextReader} реализует интерфейс {@link TextReader}
 * и считывает текст из указанного файла, разбивая его на слова.
 *
 * <p>Каждое слово очищается от знаков препинания и приводится к нижнему регистру.
 * Разделение текста происходит по пробелам и другим пробельным символам.</p>
 */
public class FileTextReader implements TextReader {

    /** Файл, из которого читается текст. */
    private final File file;

    /**
     * Создаёт новый {@code FileTextReader} для указанного файла.
     *
     * @param file файл, содержащий текст для анализа
     */
    public FileTextReader(File file) {
        this.file = file;
    }

    /**
     * Считывает содержимое файла, разбивает строки на слова,
     * очищает их и возвращает список слов.
     *
     * @return список очищенных слов из файла
     */
    @Override
    public List<String> read() {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                List<String> lineWords = Arrays
                    .stream(line.split("\\s+"))
                    .map(this::cleanWord)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());

                words.addAll(lineWords);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return words;
    }

    /**
     * Очищает слово от всех символов, кроме букв и цифр, и приводит его к нижнему регистру.
     *
     * @param word исходное слово
     * @return очищенное слово в нижнем регистре
     */
    private String cleanWord(String word) {
        return word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
    }
}
