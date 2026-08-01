package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindMaximum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> maxNumbers = numbers.stream()
                .max(Integer::compare);

        System.out.println("Numbers :" + numbers);
        System.out.println("Maximum :" + maxNumbers);
    }
}
