import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> words = Arrays.asList("hi", "hello", "dog", "book", "apple");

        // P1
        words.stream().forEach((word) -> System.out.println(" " + word));

        // P2
        words.stream().forEach(System.out::println);

        // P3
        List<String> excitingWords = words.stream().map((word) -> word + "!").toList();
        List<String> eyeWords = words.stream().map((word) -> word.replace("i", "eye")).toList();
        List<String> uppercaseWords = words.stream().map((word) -> word.toUpperCase()).toList();

        for (var word : excitingWords) {
            System.out.println(word);
        }

        eyeWords.stream().forEach(System.out::println);
        uppercaseWords.stream().forEach((word) -> System.out.println(word));

        // P4
        List<String> shortWords = words.stream().filter((word) -> word.length() < 4).toList();
        List<String> wordsWithB = words.stream().filter((word) -> word.contains("b")).toList();
        List<String> evenLengthWords = words.stream().filter((word) -> (word.length() % 2) == 0).toList();

        shortWords.stream().forEach(System.out::println);
        wordsWithB.stream().forEach(System.out::println);
        evenLengthWords.stream().forEach(System.out::println);

        // P5
        words.stream().filter((word) -> word.length() < 4).filter((word) -> word.contains("e")).findFirst()
                .ifPresent((word) -> System.out.println(word.toUpperCase()));

        words.stream().filter((word) -> word.length() < 4).filter((word) -> word.contains("q")).findFirst()
                .ifPresent((word) -> System.out.println(word.toUpperCase()));

        filterByLetter("q", words);

        // P6
        String result = words.stream().reduce("", (acc, word) -> acc + word.toUpperCase());
        System.out.println(result);

        // P7
        String sameString = words.stream().map(String::toUpperCase).reduce("", (acc, word) -> acc + word);
        System.out.println(sameString);

        // P8
        words.stream().reduce((word1, word2) -> word1 + "," + word2).ifPresent(System.out::println);

        String solution = words.stream().collect(Collectors.joining(","));
        System.out.println(solution);

        // P9
        System.out.println(words.stream().map(e -> e.length()).reduce(0, Integer::sum));
        System.out.println(words.stream().mapToInt(String::length).sum());

        long filteredWords = words.stream().filter(word -> word.contains("h")).count();
        System.out.println(filteredWords);

    }

    public static void filterByLetter(String letter, List<String> list) {
        list.stream().filter((word) -> word.length() < 4).filter((word) -> word.contains(letter)).findFirst()
                .ifPresent((word) -> System.out.println(word.toUpperCase()));
    }
}
