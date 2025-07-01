package ru.v1nga.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapUtilsTest {

    @Test
    void testInvertMapWithUniqueValues() {
        Map<String, Integer> original = new HashMap<>();
        original.put("one", 1);
        original.put("two", 2);
        original.put("three", 3);

        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "one");
        expected.put(2, "two");
        expected.put(3, "three");

        Map<Integer, String> result = MapUtils.invertMap(original);

        assertEquals(expected, result);
    }

    @Test
    void testInvertMapWithEmptyMap() {
        Map<String, Integer> original = new HashMap<>();
        Map<Integer, String> result = MapUtils.invertMap(original);

        assertTrue(result.isEmpty());
    }

    @Test
    void testInvertMapWithNullValues() {
        Map<String, Integer> original = new HashMap<>();
        original.put("a", null);
        original.put("b", 1);

        Map<Integer, String> expected = new HashMap<>();
        expected.put(null, "a");
        expected.put(1, "b");

        Map<Integer, String> result = MapUtils.invertMap(original);

        assertEquals(expected, result);
    }

    @Test
    void testInvertMapWithNullKeys() {
        Map<String, Integer> original = new HashMap<>();
        original.put(null, 100);
        original.put("z", 200);

        Map<Integer, String> expected = new HashMap<>();
        expected.put(100, null);
        expected.put(200, "z");

        Map<Integer, String> result = MapUtils.invertMap(original);

        assertEquals(expected, result);
    }
}
