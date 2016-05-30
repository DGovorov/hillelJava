package patterns.factory.factory;

import enums.PizzaType;
import patterns.factory.pizza.Pizza;

/**
 * Created by User on 30.05.2016.
 */
public interface PizzaFactory {

    Pizza createPizza(PizzaType type);

}
