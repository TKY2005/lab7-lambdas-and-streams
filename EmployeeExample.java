/*
 * Name: Youssef Mohamed Torki Ahmed
 * ID: 445820246
 * Lab7- Streams and lambda expressions.
 */
import java.util.*;

class Employee implements Comparable<Employee>{
    String name;
    double salary;

    public Employee(String name, double salary){this.name = name; this.salary = salary;}
    public void displayInfo(){
        System.out.printf("%s------%s\n", name, salary);
    }
    public double getSalary(){return salary;}
    public String getName(){return name;}

    public int compareTo(Employee emp){
        return Double.compare(this.salary, emp.salary);
    }
}

public class EmployeeExample {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("Shaheer", 15_000));
        empList.add(new Employee("Baheer", 140_000));
        empList.add(new Employee("Ahmed", 5_000));
        empList.add(new Employee("Khalid", 250_000));
        empList.add(new Employee("Sobhy", 50_000));
        empList.add(new Employee("Mohamed", 125_000));

        System.out.println("Before processing....");
        empList.stream().forEach(Employee::displayInfo);
        System.out.println("After processing....");
        empList.stream().
        filter(employee -> employee.getSalary() < 50_000).
        sorted(Comparator.reverseOrder()).
        forEach(Employee::displayInfo);
    }
}
