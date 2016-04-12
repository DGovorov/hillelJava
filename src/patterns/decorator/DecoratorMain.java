package patterns.decorator;

/**
 * Created by User on 12.04.2016.
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage robusta = new Robusta();
        Beverage arabica = new Arabica();

        arabica = new Milk(arabica);
        arabica = new Milk(arabica);

        robusta = new Cream(new Milk(robusta));

        printBeverage(arabica);
        printBeverage(robusta);
    }

    public static void printBeverage(Beverage beverage){
        System.out.println("price is: " + beverage.cost() + ", " + beverage.description());
    }
}
