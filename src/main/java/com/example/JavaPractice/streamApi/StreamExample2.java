package com.example.JavaPractice.streamApi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class StreamExample2 {

    public static void main(String[] args) {

        String sentence = "I  love Java and I Love Coding in Java";

        // Normalize input
        String[] words = sentence.toLowerCase().split("\\s+");

        // 1. Frequency of each word
        Map<String, Long> freq = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("Frequency: " + freq);

        // 2. First repeating word
        String firstRepeat = freq.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First Repeating: " + firstRepeat);

        // 3. First non-repeating word
        String firstUnique = freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First Non-Repeating: " + firstUnique);

        // 4. Sort words by frequency (descending)
        System.out.println("Sorted by Frequency:");
        freq.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(System.out::println);

        // 5. Top 2 frequent words
        List<String> top2 = freq.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Top 2: " + top2);

        // 6. Count words starting with vowel
        long vowelCount = Arrays.stream(words)
                .filter(w -> "aeiou".indexOf(w.charAt(0)) != -1)
                .count();
        System.out.println("Words starting with vowel: " + vowelCount);

        // 7. Longest word
        String longest = Arrays.stream(words)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest word: " + longest);

        // 8. Reverse each word
        String reversedWords = Arrays.stream(words)
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Reverse each word: " + reversedWords);

        // 9. Remove duplicate words (preserve order)
        String distinct = Arrays.stream(words)
                .distinct()
                .collect(Collectors.joining(" "));
        System.out.println("Distinct words: " + distinct);

        // 10. Group words by length
        Map<Integer, List<String>> groupByLength = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Group by length: " + groupByLength);

        // 11. Count total characters (excluding spaces)
        long charCount = sentence.chars()
                .filter(c -> c != ' ')
                .count();
        System.out.println("Character count (no spaces): " + charCount);
    }
}
