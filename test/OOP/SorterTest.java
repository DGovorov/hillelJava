package OOP;

import collections.CatComparator;
import collections.ReversedComparator;
/*import junit.framework.Assert;*/
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * Created by User on 18.03.2016.
 */
public class SorterTest {
    @Test
    public void yearShouldBeInAscendingOrder() {
        //Assert.fail();
        //Assert.assertEquals(2, 2);

        Sorter sorter = new Sorter();


        Cat tom = new Cat("Tom", "White", 2013);
        Cat murzik = new Cat("Murzik", "Black", 2015);
        Cat barsik = new Cat("Barsik", "Grey", 2014);

        Cat[] cats = new Cat[3];

        cats[0] = tom;
        cats[1] = murzik;
        cats[2] = barsik;

        //tom = new Cat("Tom", "White", 2013);

        sorter.sort(cats, new CatComparator());

        Cat[] expected = {tom, murzik, barsik};

        Assert.assertArrayEquals("Cats are in wrong order", expected, cats);
    }

    @Test
    public void yearShouldBeInDescendOrder(){
        //Assert.fail();
        //Assert.assertEquals(2, 2);

        Sorter sorter = new Sorter();


        Cat tom = new Cat("Tom", "White", 2013);
        Cat murzik = new Cat("Murzik", "Black", 2015);
        Cat barsik = new Cat("Barsik", "Grey", 2014);

        Cat[] cats = {tom, murzik, barsik};

        //tom = new Cat("Tom", "White", 2013);

        sorter.sort(cats, new ReversedComparator(new CatComparator()));

        Cat[] expected = {barsik, murzik, tom};


        Assert.assertArrayEquals("Cats are in wrong order", expected, cats);

    }
}
