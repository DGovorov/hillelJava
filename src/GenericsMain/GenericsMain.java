package GenericsMain;

import OOP.inheritance.hierarchy.Employee;
import OOP.inheritance.hierarchy.Manager;
import OOP.inheritance.hierarchy.Person;

import java.util.*;

/**
 * Created by User on 06.05.2016.
 */
public class GenericsMain {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ivan"));
        employees.add(new Manager());

        Employee employee = employees.get(0);
        employee.getPosition();

        Manager manager = new Manager();
        Employee employee1 = new Employee("Vasya");

        employee1 = manager;
        //employee1.greeting();

        List<Manager> managers = new ArrayList<Manager>();
        //employees = managers; not working

        employees.add(new Employee("Ivan"));
        employee = employees.get(0);

        managers.add(new Manager());
        Manager manager1 = managers.get(0);

        //employees = managers;
        employees.add(new Manager("Vasya"));

        fire(employees);
        fire(managers);

        Pair<Person, Person> personPair = new Pair<Person, Person>(new Person(), new Person());
        Person first = personPair.getFirst();
        Person second = personPair.getSecond();

        Pair<String, String> stringPair = new Pair<String, String>("wqeqwe", "weqwe");

        Map<Person, String> personStringMap = new HashMap<>();
        personStringMap.put(manager, "some string");

        copy(employees, new ArrayList<>());

        List<Employee> employees1 = copy(managers);
        employee = new Employee();

        //SINGLETON !!! List of one element, used if you have one element but method expects List
        fire(Collections.singletonList(employee));
        //EMPTY LIST, size = 0; can be passed as variable. empty List
        fire(Collections.emptyList());
        //version with generic!
        fire(Collections.<Employee>emptyList());


    }

    public static void fire (List<? extends Employee> employees){
        for (Employee employee: employees) {
            System.out.println(employee.getName() + " is fired!");
        }

        //employees.add(new Employee()); cant add objects to collections with ?extends generics
    }

    /*public static void fire (List<Manager> managers){
        for (Manager manager: managers) {
            System.out.println(manager.getName() + " is fired!");
        }
    } */

    public static void addEmployee(List<? super Employee> employees){
        employees.add(new Employee());
        //Employee employee = employees.get(0); cant get anything from such list, only Object
        Object obj = employees.get(0);
    }

    public static <T> void copy(List<? extends T> source, List<T> target){
        target.addAll(source);

    }

    public static <T> List<T> copy(List<? extends T> source){
        List<T> target = new ArrayList<>();
        target.addAll(source);
        return target;

    }

}
