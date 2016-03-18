package patterns;

import patterns.fly.Rocket;

/**
 * Created by User on 15.03.2016.
 */
public class DucksMain {

    public static void main(String[] args) {
        Duck duck = new RubberDuck();

        duck.display();
        duck.quack();
    }
}
