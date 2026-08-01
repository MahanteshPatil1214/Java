package Streams;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Mahantesh Patil","Sonaji","Omkar","Aditya");

        String result = names.stream()
                .filter(name ->{
                    System.out.println("Filter:" + name);
                    return name.startsWith("A");
                })
                .map(name->{
                    System.out.println("Map:" + name);
                    return name.toUpperCase();
                })
                .findFirst()
                .orElse("");

        }
}
