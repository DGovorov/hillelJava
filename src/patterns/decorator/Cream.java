package patterns.decorator;

/**
 * Created by User on 12.04.2016.
 */
public class Cream extends BeverageDecorator {

    public Cream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return 4 + super.cost();
    }

    @Override
    public String description() {
        return super.description() + ", cream";
    }
}
