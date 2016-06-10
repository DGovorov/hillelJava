package java8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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
        //functionalInterfaces(apples);
        //methodReferenceExample(apples);
        //functionsExample(apples);
        //defaultSortExample(apples);
        //functionsComposition();

        //Optional.empty().get(); - leads to exception

        Optional<String> someString = generate();
        if (someString.isPresent()) {
            System.out.println(someString.get().toCharArray());
        }

        String message = "this is closure"; //final or effectively final
        //message = "";
        someString.ifPresent(s -> System.out.println(s + message));

        //List<String> strings = new ArrayList<>();
        //someString.ifPresent(strings::add);

        someString.ifPresent(System.out::println);
        //someString.flatMap(); - погуглить. манада

        House house = new House();
        Optional<Pasport> mightBePassport =
                house.getFlat()
                .flatMap(Flat::getCitizen)
                .flatMap(Citizen::getPaspot);

    }


    static Optional<String> generate() {
        if (Math.random() < 0.65) {
            return Optional.of("Asd");
        } else {
            return Optional.empty();
            //return null;
        }
    }

    private static void functionsComposition() {
        String message = "My name is Max, I use java";
        /*UnaryOperator<String> header = m -> "Hello, " + m;
        UnaryOperator<String> corrector = m -> m.replace("java", "Java 8");
        UnaryOperator<String> footer = m -> m + ". Bye";*/

        Function<String, String> header = m -> "Hello, " + m;
        Function<String, String> corrector = m -> m.replace("java", "Java 8");
        Function<String, String> footer = m -> m + ". Bye";

        /*message = header.apply(message);
        message = corrector.apply(message);
        message = footer.apply(message);*/

        Function<String, String> textProcessor = header.andThen(corrector).andThen(footer);
        Function<String, String> sameAsTextProcessor = footer.compose(corrector).compose(header); //compose for reversed apply
        message = textProcessor.apply(message);

        System.out.println(message);
    }

    private static void functionsExample(List<Apple> apples) {
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
        Comparator<Apple> byColor = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        byColor = Comparator.comparing(Apple::getColor);

        Comparator<Apple> byColorReversed = byColor.reversed();

        Comparator<Apple> byWeight = (o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight());
        byWeight = Comparator.comparingInt(Apple::getWeight);

        Comparator<Apple> byColorDescAndWeight = byColorReversed.thenComparing(byWeight);


        //Collections.sort(apples, byColor);
        apples.sort(byColorDescAndWeight);
        System.out.println(apples);

    }

}
