import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Module {

    // Task 1
    public String getOddNames(String... names) {
        StringBuilder oddNames = new StringBuilder();
        IntStream.range(0, names.length)
                .filter(x -> x % 2 != 0)
                .forEach(x -> oddNames
                        .append(x)
                        .append(". ")
                        .append(names[x])
                        .append(", "));
        return oddNames.substring(0, oddNames.length() - 2);
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


//        StringBuilder r = new StringBuilder();
//
//        Arrays.stream(ints)
//                .forEach(x -> Arrays.stream(x.split(","))
//                        .forEach(y -> r.append(y.strip()).append(",")));
//        return Arrays.stream(r.toString().split(","))
//                .map(Integer::parseInt)
//                .sorted()
//                .toList()
//                .toString()
//                .replaceAll("[]\\[]", "");
    }

    // Task 4
    public Stream<Long> congruentGenerator(long a, int c, long m) {
        return Stream.iterate(0, n -> n+1).limit(10000000).map(x -> (a * x + c) % m);
    }

    // Task 5
//    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//
//    }
}
