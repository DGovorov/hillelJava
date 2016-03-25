package patterns.strategy;

import patterns.strategy.fly.FlyNoWay;
import patterns.strategy.quack.Quack;

/**
 * Created by User on 15.03.2016.
 */
public class Decoy extends Duck{

    public Decoy() {
        quackbehaviour = new Quack();
        flybehaviour = new FlyNoWay();
    }

    @Override
    public void display(){
        System.out.println("decoy");
    }

    @Override
    public void swim() {
        System.out.println("I can't swim");
    }
}
