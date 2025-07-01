package ru.v1nga.app.textprocessor.core;

import java.util.Map;

/**
 * Интерфейс {@code TextWriter} определяет контракт для классов,
 * которые отвечают за вывод статистики частоты слов.
 */
public interface TextWriter {

    /**
     * Выводит или сохраняет отображение частоты слов.
     *
     * @param wordFrequencies отображение, где ключ — слово,
     * а значение — количество его вхождений
     */
    void write(Map<String, Integer> wordFrequencies);
}
