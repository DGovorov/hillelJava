package patterns.strategy;

import patterns.strategy.fly.Fly;
import patterns.strategy.quack.Quack;

/**
 * Created by User on 15.03.2016.
 */
public class MallardDuck extends Duck{

    public MallardDuck() {
        quackbehaviour = new Quack();
        flybehaviour = new Fly();
    }

    @Override
    public void display() {
        System.out.println("mallard duck");
    }
}
