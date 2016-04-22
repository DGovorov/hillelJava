package IO;

/**
 * Created by User on 19.04.2016.
 */
public class Tenant {
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "name='" + name + '\'' +
                '}';
    }
}
