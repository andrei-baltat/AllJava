package com.example.myPackage.javaSpilca.example2;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Example2 {
    public static void main(String[] args) {
        // better to return an empty list than null
        Stream<Integer> s1 = Stream.empty();

        Stream<Integer> s2 = Stream.of(1,2,3,4,5);
        s2.forEach(System.out::println);

        Supplier<Integer> sup = () -> new Random().nextInt();
        Stream<Integer> s3 = Stream.generate(sup);
        s3.limit(10)
          .forEach(System.out::println);
    }

    public List<Integer> m1(){
        // good pattern
        return Collections.emptyList();
    }
}
