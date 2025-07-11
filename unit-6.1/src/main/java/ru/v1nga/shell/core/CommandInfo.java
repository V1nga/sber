package ru.v1nga.shell.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    String name();
    String description();
}
