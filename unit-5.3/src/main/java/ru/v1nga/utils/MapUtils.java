package ru.v1nga.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private MapUtils() {}

    /**
     * Меняет ключи и значения в карте местами.
     * Если в исходной карте есть одинаковые значения,
     * последние ключи (какие именно - зависит от хэша) перезапишут предыдущие.
     *
     * @param <K> тип ключа исходной карты
     * @param <V> тип значения исходной карты
     * @param map исходная карта
     * @return новая карта с ключами и значениями, поменянными местами
     */
    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        Map<V, K> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted.put(entry.getValue(), entry.getKey());
        }

        return inverted;
    }
}
