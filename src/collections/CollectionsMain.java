package collections;

import OOP.Cat;

import java.util.ArrayList;

/**
 * Created by User on 18.03.2016.
 */
public class CollectionsMain {

    public static void main(String[] args) {
        ArrayList<Cat> list = new ArrayList<>();

        list.add(new Cat("tom", "grey", 2015));
        list.add(new Cat("tom", "grey", 2015));
        list.add(new Cat("tom", "grey", 2015));
        // list.add("String");

        System.out.println(list);

        //Object tom = list.get(1);
        Cat tom = list.get(1);

    }
}
