package org.example.ex3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        String filename = "./ex3/words.txt";
        Map<String, Long> wordFrequency = countWordFrequency(filename);
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public static Map<String, Long> countWordFrequency(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(word -> word.toLowerCase().replaceAll("[^a-z]", ""))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
