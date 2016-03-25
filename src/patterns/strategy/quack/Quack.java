package patterns.strategy.quack;

/**
 * Created by User on 15.03.2016.
 */
public class Quack implements Quackbehaviour {

    @Override
    public void quack() {
        System.out.println("quack");
    }
}
