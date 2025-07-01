package ru.v1nga.app.textprocessor.core;

import java.util.List;

/**
 * Интерфейс {@code TextReader} определяет контракт для классов,
 * которые отвечают за чтение текста и возвращают список слов.
 */
public interface TextReader {

    /**
     * Читает текст и возвращает список слов.
     *
     * @return список слов, прочитанных из источника
     */
    List<String> read();
}
