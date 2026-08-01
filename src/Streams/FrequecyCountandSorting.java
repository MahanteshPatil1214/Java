package Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class FrequecyCountandSorting {
    public static void main(String[] args) {
        List<String> words = List.of("apple","banana","apple","cherry","banana");
        List<Map.Entry<String,Long>> top2Words = words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(2)
                .collect(Collectors.toList());;
    }
}
