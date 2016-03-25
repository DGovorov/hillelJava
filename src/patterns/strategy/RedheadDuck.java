package patterns.strategy;

import patterns.strategy.fly.Fly;
import patterns.strategy.quack.Quack;

/**
 * Created by User on 15.03.2016.
 */
public class RedheadDuck extends Duck{

    public RedheadDuck() {
        quackbehaviour = new Quack();
        flybehaviour = new Fly();
    }

    @Override
    public void display() {
        System.out.println("redhead duck");
    }

}
