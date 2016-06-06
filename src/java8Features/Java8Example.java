package java8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by User on 06.06.2016.
 */
public class Java8Example {

    public static void main(String[] args) {
        /*God god = TheGod.getInstance();
        god.resurrect();*/

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(200, "Red", 15));
        apples.add(new Apple(250, "Green", 16));
        apples.add(new Apple(100, "Green", 11));
        apples.add(new Apple(250, "Yellow", 15));
        //defaultSortExample(apples);
        //functionalInterfaces(apples);
        //methodReferenceExample(apples);

        print(apples, apple -> String.valueOf(apple.getPrice()));

        Function<Apple, String> function = apple -> apple.getColor();

    }

    private static void print(List<Apple> apples, Function<Apple, String> appleToString) {
        for (Apple apple : apples) {
            System.out.println(appleToString.apply(apple));
        }
    }

    private static void methodReferenceExample(List<Apple> apples) {
        //Consumer<Apple> applePrinter = apple -> System.out.println(apple)
        Consumer<Apple> applePrinter = System.out::println;
        apples.forEach(applePrinter);
    }

    private static void functionalInterfaces(List<Apple> apples) {
        Predicate<Apple> isGreen = apple -> apple.getColor().equals("Green");
        List<Apple> greenApples = select(apples, isGreen);


        Predicate<Apple> isHeavy = apple -> apple.getWeight() > 200;
        List<Apple> heavyApples = select(apples, isGreen);

        Predicate<Apple> heavyAndGreen = isHeavy.and(isGreen);
        System.out.println(select(apples, heavyAndGreen));
    }


    public static List<Apple> select(List<Apple> apples, Predicate<Apple> tester) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (tester.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static void defaultSortExample(List<Apple> apples) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        //Collections.sort(apples, byColor);
        apples.sort(byColor);
        System.out.println(apples);

    }

}
