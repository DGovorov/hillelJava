package java8Features;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.stream.Collectors.*;

/**
 * Created by User on 13.06.2016.
 */
public class MainStream {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(200, "Red", 15));
        apples.add(new Apple(250, "Green", 16));
        apples.add(new Apple(100, "Green", 11));
        apples.add(new Apple(250, "Yellow", 15));
        apples.add(new Apple(230, "Green", 15));

        //foreachExample(apples);
        //List<Apple> greenApples = limitExample(apples);
        //mapExample(apples);
        //parallelSortedStreamExample(apples);

        Random random = new Random();
        Supplier<Integer> integerSupplier = random::nextInt;
        Stream.generate(integerSupplier)
                .filter(integer -> integer % 2 == 0)
                .limit(10)
                .forEach(System.out::println);

        Supplier<Apple> appleSupplier = Apple::new;




    }

    private static void parallelSortedStreamExample(List<Apple> apples) {
        boolean areThereExpensiveApples = apples.stream()
                .anyMatch(apple -> apple.getPrice() > 10);
        System.out.println(areThereExpensiveApples);

        Optional<Apple> expensiveApple = apples.stream()
        //Optional<Apple> expensiveApple = apples.parallelStream()
                .filter(apple -> apple.getPrice() > 10)
                .sorted(Comparator.comparing(Apple::getColor))
                .findAny();
        expensiveApple.ifPresent(System.out::println);
    }

    private static void mapExample(List<Apple> apples) {
    /*Function<Apple, String> toString = apple -> apple.getColor();*/
        Predicate<String> isYellow = letter -> letter.equals("Y");
        Predicate<String> notYellow = isYellow.negate();
        List<String> colors = apples.stream()
                .map(Apple::getColor)
                .map(MainStream::extractFirst)
                .filter(notYellow)
                .collect(Collectors.toList());
        System.out.println(colors);

        /*List<String> colorsList = new ArrayList<>();
        apples.stream()
                .map(Apple::getColor)
                .forEach(colorsList::add);
        System.out.println(colorsList);*/
    }

    private static String extractFirst(String string) {
        return string.substring(0, 1);
    }

    private static List<Apple> limitExample(List<Apple> apples) {
        // all Stream operations are called "pipe"
        return apples.stream()
                .filter(Apple::isGreen)
                .filter(Apple::isHeavy)
                .limit(2)
                .collect(Collectors.toList());
    }

    private static void foreachExample(List<Apple> apples) {
        apples.stream()
                .filter(Apple::isGreen)
                .filter(Apple::isHeavy)
                .forEach(System.out::println); //forEach = terminal operation
    }

}
