package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListOfNamesToUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("mahantesh","om","ram");
        List<String> upperCase = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Names:"+ names);
        System.out.println("Names to Upper Case:"+ upperCase);
    }
}
