package org.wq.algorithm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDebuger {

    public static void main(String[] args) {
        List<String> s0 = Stream.of("C", "B", "A") // "C", "A", "B"
            .sorted() // "A", "B", "C"
            .collect(Collectors.toList()); // [“A”, “B”, “C”]

        System.out.println(s0);
    }
}
