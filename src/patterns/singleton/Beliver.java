package patterns.singleton;

/**
 * Created by User on 03.06.2016.
 */
public class Beliver {

    static God god;
    String name;

    //don't do that
/*    public Beliver(God god){
        this.god = god;
        //Beliver.god = god;
    }*/

    @Override
    public String toString(){
        return "my name is " + name + "I believe in " + god.getName();
    }


}
