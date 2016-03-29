package OOP.inheritance.hierarchy;

/**
 * Created by User on 04.03.2016.
 */
public class Person {
    private String name;


    @Deprecated
    public Person(){

    }

    /**
     * this constructor creates person with name
     * @param name person's name
     */
    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void greeting (){
        System.out.println("Hi, I'm person, My name is " + getName());
    }

    @Override
    public boolean equals (Object o){
        if (!(o instanceof Person)){
            return false;
        }

        Person other = (Person) o;

        return this.getName().equals(other.getName());
    }

    @Override
    public String toString(){
        return "Im Person, my name is " + getName();
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
