package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfElements {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                        .mapToInt(Integer::intValue)
                                .sum();
        System.out.println("Numbers :" + numbers);
        System.out.println("Sum :" + sum);
    }
}
