package ru.v1nga.app;

import ru.v1nga.app.textprocessor.TextProcessor;
import ru.v1nga.app.textprocessor.core.TextReader;
import ru.v1nga.app.textprocessor.core.TextWriter;
import ru.v1nga.app.textprocessor.readers.FileTextReader;
import ru.v1nga.app.textprocessor.writers.ConsoleTextWriter;

import java.io.File;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        File textFile = new File(
    Paths.get("").toAbsolutePath()
            + File.separator + "unit-5.4"
            + File.separator + "text.txt"
        );

        TextReader textReader = new FileTextReader(textFile);
        TextWriter textWriter = new ConsoleTextWriter();

        TextProcessor textProcessor = new TextProcessor(textReader, textWriter);
        textProcessor.printWordFrequencies();
    }
}
