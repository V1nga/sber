package ru.v1nga.todo.core;

import ru.v1nga.todo.core.exceptions.InvalidCommandException;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Утилитарный класс со вспомогательными методами.
 */
public final class Utils {

    private Utils(){}

    /**
     * Загружает все классы из указанного пакета.
     *
     * @param packageName имя пакета
     * @return коллекция классов
     * @throws Exception при ошибке загрузки классов
     */
    public static Collection<Class<?>> getClassesFromPackage(String packageName) throws Exception {
        StandardJavaFileManager fileManager = ToolProvider
            .getSystemJavaCompiler()
            .getStandardFileManager(null, null, null);

        return StreamSupport
            .stream(fileManager.list(StandardLocation.CLASS_PATH, packageName, Collections.singleton(JavaFileObject.Kind.CLASS), false).spliterator(), false)
            .map(javaFileObject -> {
                try {
                    String[] split = javaFileObject.getName()
                        .replace(".class", "")
                        .replace(")", "")
                        .split(Pattern.quote(File.separator));

                    String fullClassName = packageName + "." + split[split.length - 1];

                    return Class.forName(fullClassName);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            })
            .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Парсит аргументы командной строки в карту.
     *
     * @param args массив аргументов
     * @return карта ключ-значение аргументов
     * @throws InvalidCommandException если аргументы заданы некорректно
     */
    public static Map<String, String> parseArgs(String[] args) throws InvalidCommandException {
        Map<String, String> argMap = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String key = args[i];

            if (key.startsWith("-")) {
                if (i + 1 < args.length) {
                    String value = args[++i];

                    if (value.startsWith("\"")) {
                        StringBuilder sb = new StringBuilder(value);
                        while (!value.endsWith("\"") && i + 1 < args.length) {
                            value = args[++i];
                            sb.append(" ").append(value);
                        }
                        value = sb.toString().replaceAll("^\"|\"$", "");
                    }

                    argMap.put(key.substring(1), value);
                } else {
                    throw new InvalidCommandException("Ошибка: ключ " + key + " без значения");
                }
            } else {
                throw new InvalidCommandException("Пропущен ключ перед " + key);
            }
        }

        return argMap;
    }
}
