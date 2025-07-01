package ru.v1nga.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new CustomLinkedList<>();
    }

    @Test
    void testIsEmptyInitially() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddAndSize() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
    }

    @Test
    void testGetValidIndex() {
        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    void testGetInvalidIndex() {
        list.add("x");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testContains() {
        list.add("apple");
        list.add("banana");

        assertTrue(list.contains("apple"));
        assertFalse(list.contains("orange"));
        assertFalse(list.contains(null));

        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    void testRemoveExisting() {
        list.add("1");
        list.add("2");
        list.add("3");

        list.remove("2");

        assertEquals(2, list.size());
        assertFalse(list.contains("2"));
        assertEquals("1", list.get(0));
        assertEquals("3", list.get(1));
    }

    @Test
    void testRemoveHead() {
        list.add("head");
        list.add("next");

        list.remove("head");

        assertEquals(1, list.size());
        assertEquals("next", list.get(0));
        assertFalse(list.contains("head"));
    }

    @Test
    void testRemoveNonExisting() {
        list.add("a");
        list.add("b");

        list.remove("z");  // nothing should happen

        assertEquals(2, list.size());
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
    }

    @Test
    void testRemoveNullElement() {
        list.add("x");
        list.add(null);
        list.add("y");

        assertTrue(list.contains(null));
        list.remove(null);
        assertFalse(list.contains(null));
        assertEquals(2, list.size());
    }
}
