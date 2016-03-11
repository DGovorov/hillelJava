package OOP.abstraction;

/**
 * Created by User on 11.03.2016.
 */
public class AbstractionMain {
    public static void main(String[] args) {
        //new Auto(1996);

        Auto auto = new Lada(1995);
        System.out.println(auto);

        Repairable repairable = new Lada(1995);
        //Repairable wontWork = auto;

        //repaire((Lada)auto);
        //repaire((Repairable) auto);
        repaire(new Lada(1995));



    }

    public static void repaire(Repairable toRepaire){
        toRepaire.repair();
    }
}
