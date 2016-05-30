package patterns.factory;

import enums.PizzaType;
import patterns.factory.factory.ChPizzaFactory;
import patterns.factory.factory.NyPizzaFactory;
import patterns.factory.factory.PizzaComponentsFactory;

/**
 * Created by User on 30.05.2016.
 */
public class PizzaMain {

    public static void main(String[] args) {

        String pizzaType = args[0];
        PizzaType truePizzaType = PizzaType.of(pizzaType);

        System.out.println(PizzaType.CHEESE.getName());
        System.out.println(truePizzaType.getName());


        PizzaComponentsFactory nyComponentFactory = new NyPizzaComponentsFactory();
        PizzaStore nyPizzaStore = new PizzaStore(new NyPizzaFactory(nyComponentFactory));
        nyPizzaStore.order(PizzaType.CHEESE);

        PizzaComponentsFactory chComponentFactory = new ChPizzaComponentsFactory();
        PizzaStore chPizzaStore = new PizzaStore(new ChPizzaFactory(chComponentFactory));
        chPizzaStore.order(PizzaType.MEAT);


    }

}
