package OOP.inheritance;

import OOP.inheritance.hierarchy.Employee;
import OOP.inheritance.hierarchy.Manager;
import OOP.inheritance.hierarchy.Person;

import java.util.Objects;

/**
 * Created by User on 04.03.2016.
 */
public class InheritanceMain {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Ivan");

        Employee employee = new Employee();
        employee.setPosition("programmer");
        employee.setName("Denis");

        Manager manager = new Manager();
        manager.setPosition("director");
        manager.setName("Igor");
        manager.fire(employee);

        person.getName();

        Person employeeAsPerson = employee;
        Person managerAsPerson = manager;

        employeeAsPerson.getName();
        //employeeAsPerson.getPosition();

        //Manager personAsManager = person;

        //Employee employee1 = (Employee) employeeAsPerson;
        // System.out.println(employee1.getPosition());

        if (employeeAsPerson instanceof Employee) {
            System.out.println("he is employee");
        } else {
            System.out.println("he is not employee");
        }

        /*person.greeting();
        employee.greeting();
        manager.greeting();*/

        Person somebody = employee;
        somebody.greeting();
        //POLYMORPHISM!!!!

        speak(person);
        speak(employeeAsPerson);
        speak(manager);
        //AGAIN! POLY!

        System.out.println(person.getName());
        System.out.println(employee.getName());
        System.out.println(manager.getName());

        Object o = new Employee();


    }
    //POLYMORPHISM!!!
    public static void speak(Person person){
        person.greeting();
    }

    public static void printName(Person person){
        System.out.println("name is " + person.getName());
    }


}
