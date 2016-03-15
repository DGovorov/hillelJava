package patterns;

import patterns.fly.Fly;
import patterns.quack.Quack;

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
