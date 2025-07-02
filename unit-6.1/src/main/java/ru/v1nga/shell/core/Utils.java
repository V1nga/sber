package ru.v1nga.shell.core;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Utils {

    private Utils(){}

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
}
