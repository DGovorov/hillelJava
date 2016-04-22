package IO;

import OOP.inheritance.hierarchy.Person;

import java.io.Serializable;

/**
 * Created by User on 19.04.2016.
 */
public class Car implements Serializable{
    private static final long serialVersionUID = 1;
    private final String brand;
    private final int year;
    private final Person owner;
    private transient Tenant tenant;

    public Car(String brand, int year, Person owner) {
        System.out.println("in car constructor with three parameters");
        this.brand = brand;
        this.year = year;
        this.owner = owner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", owner=" + owner +
                '}';
    }
}
