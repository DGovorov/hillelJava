package OOP.inheritance.hierarchy;

/**
 * Created by User on 04.03.2016.
 */
public class Employee extends Person{
    String position;

    public Employee(){
        super();
    }

    public Employee(String name){
        super(name);
    }

    public void greeting(){
        System.out.println("Hello, I'm employee, my name is " + getName());
    }

    public void setPosition(String position){
        this.position = position;
    }

    @Override
    public String getName(){
        return super.getName().toUpperCase() + "!";
    }

    public String getPosition(){
        return position;
    }
}
