package OOP;

import java.util.Arrays;

/**
 * Created by MBCNEWMAIN on 11.03.2016.
 */
public class Sorter {
    public void sort(Comparable[] unsorted) {
        boolean swap = false;
        do {
            swap = false;
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i].compareTo(unsorted[i + 1]) > 0) {
                    Comparable temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
    }

    public static void main(String[] args) {
        int[] a = {9, 5, 8, 4, 3, 7};
        String[] s = {"a", "b", "e", "c"};
        Cat[] cats = new Cat[0];
        Cat cat1 = new Cat("asd", "dfdf", 10);
        Cat cat2 = new Cat("dfd", "df", 4);
        cat1.compareTo(cat2);
        new Sorter().sort(cats);
        System.out.println(Arrays.toString(s));



    }

}