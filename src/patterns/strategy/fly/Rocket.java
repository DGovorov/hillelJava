package patterns.strategy.fly;

/**
 * Created by User on 15.03.2016.
 */
public class Rocket implements Flybehaviour{

    @Override
    public void fly(){
        System.out.println("I'm flyin on rocket!!!");
    }
}
