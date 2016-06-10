package java8Features;

import java.util.Optional;

/**
 * Created by User on 10.06.2016.
 */
public class Citizen {

    Optional<Pasport> paspot = Optional.empty();

    public Optional<Pasport> getPaspot() {
        return paspot;
    }
}
