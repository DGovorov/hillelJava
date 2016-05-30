package patterns.factory.factory;

import patterns.factory.pizza.ingredients.cheese.Cheese;
import patterns.factory.pizza.ingredients.dough.Dough;
import patterns.factory.pizza.ingredients.proteins.Proteins;

/**
 * Created by User on 30.05.2016.
 */
public interface PizzaComponentsFactory {
    Dough createDough();

    Cheese createCheese();

    Proteins createProteins();
}
