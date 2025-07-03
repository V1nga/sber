package ru.v1nga.todo.core.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, содержащая метаинформацию о команде.
 */
@Target(value = ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CommandInfo {

    /**
     * Имя команды.
     *
     * @return строка имени
     */
    String name();

    /**
     * Описание команды.
     *
     * @return строка описания
     */
    String description();

    /**
     * Обязательные аргументы команды.
     *
     * @return массив строк с именами аргументов
     */
    String[] requiredArgs() default {};
}
