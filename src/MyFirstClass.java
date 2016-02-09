/**
 * Created by User on 09.02.2016.
 */
public class MyFirstClass {
    public static void main(String args[]) {
        String message = "Hello World!";
        int birthday;
        birthday = 1984;
        int age = 2016 - birthday;

        message = "Hello, " + "world, I'm " + age;

        System.out.println(message);

        long millisecondsfromBC = 2016L * 365L * 24L * 3600L * 1000L;
        long millisecondsfromBC = (long) 2016 * 365 * 24 * 3600 * 1000;
        System.out.println(millisecondsfromBC);


    }
}
