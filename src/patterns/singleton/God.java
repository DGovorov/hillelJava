package patterns.singleton;

/**
 * Created by User on 03.06.2016.
 */
public interface God {

    void create();
    void heal();

    String getName();

    default void resurrect(){
        System.out.println("Ressurected");
    }

}
