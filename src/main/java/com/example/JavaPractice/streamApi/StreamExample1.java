package com.example.JavaPractice.streamApi;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample1 {
    public static void main(String[] args) {

        String str = "Tuesday";

        // 1. Frequency of characters
        Map<Character, Long> freq = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(freq);

        // 2. First non-repeating character
        Character firstNonRepeat = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(firstNonRepeat);

        // 3. Reverse string
        String reversed = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(reversed); // yadseuT

        // 4. Uppercase using stream
        String upper = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(String::toUpperCase)
                .collect(Collectors.joining());
        System.out.println(upper);

        // 5. Count vowels
        long vowels = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count();
        System.out.println(vowels);

        // 6. Remove duplicates
        String distinct = str.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(distinct);

        // 7. Sort characters
        String sorted = str.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println(sorted);

        // 8. Max occurring character
        Character maxChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println(maxChar);

        // 9. Check all characters unique
        boolean isUnique = str.chars()
                .distinct()
                .count() == str.length();
        System.out.println(isUnique);

        // 10. ASCII sum
        int asciiSum = str.chars().sum();
        System.out.println(asciiSum);
    }
}
