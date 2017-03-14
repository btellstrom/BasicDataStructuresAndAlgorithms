package com.saiu.language.labmdas.coreservletsExers.less2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;

/**
 * @author Artem Karnov @date 31.01.2017.
 *         artem.karnov@t-systems.com
 */

public class ArraySortWithReferences {

    public static void main(String[] args) {
        ArraySortWithReferences arraySortWithReferences = new ArraySortWithReferences();
        arraySortWithReferences.sortArrayReference();
        arraySortWithReferences.consumerReference();
    }

    public void sortArrayReference() {
        String[] words = {"a", "dsf", "df"};
        System.out.println(words);

        Arrays.sort(words, (s1, s2) -> {
            return s1.length() > s2.length() ? 1 : 2;
        });
        System.out.println(words);

        Arrays.sort(words, ArraySortWithReferences::customComparator);
        System.out.println(words);

        Arrays.sort(words, String::compareTo);
        System.out.println(words);


    }

    private static int customComparator(String s, String s1) {
        return s.length() > s1.length() ? 1 : 0;
    }

    public void consumerReference() {
        consume("Hello", System.out::println);
    }

    public static void consume(String str, Consumer consumer) {
        consumer.accept(str);
    }

    public void changeForMethodReference() {
        double a, b, c, x = 0, y = 0;
        method1(x, y, d -> Math.cos(2));
//        someList.forEach(entry -> System.out.println(entry));
//        method2(a, b, c, (d1,d2) -> Math.pow(d1,d2));
//        someStream.reduce(0, (i1,i2) -> Integer.sum(i1, i2));
//        method3(foo, bar, (a,b,c) -> Utils.doSomethingWith(a,b,c));
//        method4(() -> Math.random());
    }

    public static void method1(double x, double y, DoubleFunction op) {
        System.out.println(op.apply(x + y));
    }


}

