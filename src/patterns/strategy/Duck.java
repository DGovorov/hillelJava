package patterns.strategy;

import patterns.strategy.fly.Flybehaviour;
import patterns.strategy.quack.Quackbehaviour;

/**
 * Created by User on 15.03.2016.
 */
public abstract class Duck {

    Quackbehaviour quackbehaviour;

    Flybehaviour flybehaviour;

    public void fly() {
        System.out.println("I'm flying");
    }

    public void swim() {
        flybehaviour.fly();
    }

    public void quack() {
        quackbehaviour.quack();
    }

    public abstract void display();
}
