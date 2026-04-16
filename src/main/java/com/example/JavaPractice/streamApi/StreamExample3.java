package com.example.JavaPractice.streamApi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample3 {
    static class UserScore {
        private final String name;
        private final int score;
        public String getName() {
            return this.name;
        }
        public int getScore() {
            return this.score;
        }
        public UserScore(String name, int score) {
            this.name =  name;
            this.score = score;
        }
        @Override
        public String toString() {
            return "UserScore{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    static class Competition {
        private final List<UserScore> scores;
        private Competition (UserScore... scores) {
            this.scores = List.of(scores);
        }
        public List<UserScore> getScores() {
            return this.scores;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Competition round1 = new Competition(
                new UserScore("Harish", 2),
                new UserScore("Ruby", 4),
                new UserScore("Alexa", 9),
                new UserScore("Mary", 10),
                new UserScore("Bella", 2),
                new UserScore("John", 1)
        );
        Competition round2 = new Competition(
                new UserScore("Terry", 10),
                new UserScore("Mark", 8),
                new UserScore("Angela", 3)
        );
        Competition round3 = new Competition(
                new UserScore("Catty", 5),
                new UserScore("Raymond", 2),
                new UserScore("Bella", 8)
        );

        //Sum of all scores in int
        int sumInInt = round1
                .getScores()
                .stream()
                .map(UserScore::getScore)
                .reduce(Integer::sum)
                .get();
        System.out.println("Sum of all scores in int: " + sumInInt);

        //Sum of all scores in double
        double sumInDouble = round1
                .getScores()
                .stream()
                .mapToDouble(UserScore::getScore)
                .reduce(Double::sum)
                .getAsDouble();
        System.out.println("Sum of all scores in double: " + sumInDouble);

        //sort by scores
        System.out.println("Sort by scores::");
        round1.getScores().stream()
                .sorted(Comparator.comparing(UserScore::getScore))
                .toList()
                .forEach(System.out::println);

        //sort by scores, if scores are same then sort by name
        System.out.println("Sort by scores, if scores are same then sort by name::");
        round1.getScores()
                .stream()
                .sorted(Comparator.comparing(UserScore::getScore).thenComparing(UserScore::getName))
                .toList()
                .forEach(System.out::println);

        //User with maximum score
        System.out.println("User with maximum score::");
        UserScore userScore
                = round1.getScores().stream()
                .max(Comparator.comparing(UserScore::getScore).thenComparing(UserScore::getName))
                .get();
        System.out.println(userScore);

        //Users with Unique Scores
        Map<Integer, List<UserScore>> map
                = round1
                .getScores()
                .stream()
                .collect(Collectors.groupingBy(UserScore::getScore));
        map.entrySet().removeIf(entry -> entry.getValue().size() > 1);
        System.out.println("Users with Unique Scores:" + map);

        //Calculate averageScore for all rounds, do not use list concatenation
        Double averageScore = Stream.of(round1.getScores(), round2.getScores(), round3.getScores())
                .flatMap(List::stream)
                .collect(Collectors.averagingInt(UserScore::getScore));
        System.out.println("Average Score:" +averageScore);

        //Only users with score more than 4 passed round. Find all user names for those who passed the round.
        System.out.println("Users who scored more than 4:");
        Stream.of(round1.getScores(), round2.getScores(), round3.getScores())
                .flatMap(List::stream)
                .filter(userScore1 -> userScore1.getScore() > 4)
                .collect(Collectors.toList()).forEach(System.out::println);

        //Find count of users scored between 2 (inclusive) and 6 (inclusive) for each round using stream call.
        System.out.println("Users who scored between 2 & 6::");
        Stream.of(round1.getScores(), round2.getScores(), round3.getScores())
                .flatMap(List::stream)
                .filter(userScore1 -> userScore1.getScore() >= 2 && userScore1.getScore() <= 6)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}