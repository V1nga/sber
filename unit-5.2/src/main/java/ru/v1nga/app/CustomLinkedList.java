package ru.v1nga.app;

import java.util.Objects;

/**
 * Класс {@code CustomLinkedList} представляет собой простую реализацию
 * односвязного списка, хранящего объекты типа {@code T}.
 */
public class CustomLinkedList<T> {

    /**
     * Внутренний класс, представляющий узел списка.
     */
    private class Node {
        T currentNode;
        Node nextNode;

        Node(T t) {
            this.currentNode = t;
            this.nextNode = null;
        }
    }

    /** Ссылка на первый элемент списка (голову) */
    private Node headNode;

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов
     */
    public int size() {
        int count = 0;
        Node current = headNode;

        while (current != null) {
            count++;
            current = current.nextNode;
        }

        return count;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return {@code true}, если список пуст, иначе {@code false}
     */
    public boolean isEmpty() {
        return headNode == null;
    }

    /**
     * Проверяет, содержит ли список указанный объект.
     *
     * @param object объект для поиска
     * @return {@code true}, если объект найден, иначе {@code false}
     */
    public boolean contains(Object object) {
        Node current = headNode;

        while (current != null) {
            if (Objects.equals(object, current.currentNode)) {
                return true;
            }

            current = current.nextNode;
        }

        return false;
    }

    /**
     * Добавляет объект в конец списка.
     *
     * @param t объект для добавления
     */
    public void add(T t) {
        Node newNode = new Node(t);

        if (headNode == null) {
            headNode = newNode;
            return;
        }

        Node current = headNode;

        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = newNode;
    }

    /**
     * Удаляет первое вхождение указанного объекта из списка.
     * Если объект не найден — метод ничего не делает.
     *
     * @param t объект для удаления
     */
    public void remove(T t) {
        if (headNode == null) {
            return;
        }

        if (Objects.equals(t, headNode.currentNode)) {
            headNode = headNode.nextNode;
            return;
        }

        Node current = headNode;

        while (current.nextNode != null) {
            if (Objects.equals(t, current.nextNode.currentNode)) {
                current.nextNode = current.nextNode.nextNode;
                return;
            }
            current = current.nextNode;
        }
    }

    /**
     * Возвращает объект по указанному индексу.
     *
     * @param index индекс элемента (начинается с 0)
     * @return объект по индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be non-negative");
        }

        Node current = headNode;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.currentNode;
            }

            current = current.nextNode;
            count++;
        }

        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
}
