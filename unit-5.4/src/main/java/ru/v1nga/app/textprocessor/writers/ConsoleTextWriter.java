package ru.v1nga.app.textprocessor.writers;

import ru.v1nga.app.textprocessor.core.TextWriter;

import java.util.Map;

/**
 * Класс {@code ConsoleTextWriter} реализует интерфейс {@link TextWriter}
 * и отвечает за вывод частоты слов в консоль.
 *
 * <p>Каждая пара "слово — количество" выводится в формате:
 * {@code слово: число} на отдельной строке.</p>
 */
public class ConsoleTextWriter implements TextWriter {

    /**
     * Выводит частоту слов в консоль.
     *
     * @param wordFrequencies отображение, где ключ — слово, а значение — количество его вхождений
     */
    @Override
    public void write(Map<String, Integer> wordFrequencies) {
        wordFrequencies
            .forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
