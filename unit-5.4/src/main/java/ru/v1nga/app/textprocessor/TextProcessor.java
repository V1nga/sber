package ru.v1nga.app.textprocessor;

import ru.v1nga.app.textprocessor.core.TextReader;
import ru.v1nga.app.textprocessor.core.TextWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code TextProcessor} отвечает за подсчёт частоты слов в тексте.
 * Использует {@link TextReader} для чтения текста и {@link TextWriter} для вывода результатов.
 *
 * <p>После инициализации считывает слова из текста, подсчитывает количество вхождений
 * каждого слова и сохраняет их в Map {@code wordFrequencies}.</p>
 *
 * <p>Поддерживает вывод этих данных с помощью метода {@link #printWordFrequencies()}.</p>
 */
public class TextProcessor {

    /** Объект для чтения текста (например, из файла). */
    private final TextReader textReader;

    /** Объект для вывода результатов (например, в консоль или файл). */
    private final TextWriter textWriter;

    /** Частота вхождения каждого слова. */
    private final Map<String, Integer> wordFrequencies = new HashMap<>();

    /**
     * Создаёт новый {@code TextProcessor} с указанными реализациями чтения и записи.
     * Считывает данные с помощью {@code textReader} и формирует статистику слов.
     *
     * @param textReader источник текста для анализа
     * @param textWriter вывод данных (статистики)
     */
    public TextProcessor(TextReader textReader, TextWriter textWriter) {
        this.textReader = textReader;
        this.textWriter = textWriter;

        this.textReader
            .read()
            .forEach(word -> this.wordFrequencies.put(word, this.wordFrequencies.getOrDefault(word, 0) + 1));
    }

    /**
     * Выводит частоту вхождения слов, используя {@code textWriter}.
     */
    public void printWordFrequencies() {
        this.textWriter.write(this.wordFrequencies);
    }
}
