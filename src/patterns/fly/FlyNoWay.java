package patterns.fly;

/**
 * Created by User on 15.03.2016.
 */
public class FlyNoWay implements Flybehaviour {

    @Override
    public void fly(){
        System.out.println("I can't fly");
    }
}
