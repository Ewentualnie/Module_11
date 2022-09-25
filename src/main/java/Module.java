import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Module {

    // Task 1
    public String getOddNames(String... names) {
        return Stream.iterate(1, n -> n + 2)
                .limit(names.length / 2)
                .map(x -> x + ". " + names[x])
                .reduce((acc, val) -> acc + ", " + val)
                .orElse("no elements");
    }

    // Task 2
    public List<String> upperCase(String... names) {
        return Arrays.stream(names)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // Task 3
    public String intSort(String... ints) {
        return Arrays.stream(Arrays.stream(ints)
                        .reduce((acc, val) -> acc + ", " + val)
                        .get()
                        .split(","))
                .map(x -> Integer.parseInt(x.strip()))
                .sorted()
                .toList()
                .toString()
                .replaceAll("[]\\[]", "");
    }

    // Task 4
    public Stream<Long> congruentGenerator(long a, int c, long m) {
        return Stream.iterate(0, n -> n + 1)
                .limit(10000000)
                .map(x -> (a * x + c) % m);
    }

    // Task 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return Stream.concat(first, second).sorted();
    }
}
