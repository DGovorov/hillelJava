package patterns.strategy;

import patterns.strategy.fly.FlyNoWay;
import patterns.strategy.quack.Squick;

/**
 * Created by User on 15.03.2016.
 */
public class RubberDuck extends Duck{

    public RubberDuck() {
        quackbehaviour = new Squick();
        flybehaviour = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("rubber duck");
    }

}
