package com.example.myPackage;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Example2 {

    public static void main(String[] args) {


    //################INTERFACES################
    // Consumer - it consumes the value
    Consumer<String> consumer = s -> System.out.println(s);
    consumer.accept("Hello");
    List<Integer> list = List.of(10,20,30,40);
    list.forEach(x -> System.out.println(x));

    // BiConsumer
        BiConsumer<String, String> consumer2 = ((s, s2) -> System.out.println(s + s2));
        consumer2.accept("hello","bunny");

        Map<Integer, String> map = Map.of(
                10,"a",
                20,"b"
        );
        map.forEach((k,v) -> System.out.println(k + " " + v));
    // Supplier - it only return one value, the max that you can
        Supplier<Integer> s = () -> 10;
        s.get();

    // Function
        Function<Integer, String> consumeIntegerReturnString = o -> s.toString();
        consumeIntegerReturnString.apply(10);

    // BiFunction
        BiFunction<Integer,Integer,String> consumes2IntegersAndReturnsAString = (i1,i2) ->
            i1.toString().concat(i2.toString());
        consumes2IntegersAndReturnsAString.apply(10,9);

    // Predicate
        Predicate<String> consumesSomethingReturnsBoolean = s2 -> s2.equals("bla");
        consumesSomethingReturnsBoolean.test("Andrei");

    // BiPredicate
        BiPredicate<String, Integer> p = (s2, i) -> s2.length() == i;
        p.test("Hello", 5);

    // UnaryOperator - more particular of function. Argument type returned has the same type with the one received
        UnaryOperator<String> s3 = myString -> myString.toUpperCase();
        s3.apply("aaa");

    // BinaryOperator
        BinaryOperator<Integer> binaryOperator = (i1, i2) -> i1 + i2;
    }
}
