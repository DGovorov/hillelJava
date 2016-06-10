package java8Features;

import java.util.Optional;

/**
 * Created by User on 10.06.2016.
 */
public class House {

    Optional<Flat> flat = Optional.empty();

    public Optional<Flat> getFlat() {
        return flat;
    }
}
