import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Kamal", 30, 70000));
        employees.add(new Employee("Rahul", 25, 50000));
        employees.add(new Employee("Chirag", 35, 80000));
        employees.add(new Employee("Mayank", 40, 90000));
        employees.add(new Employee("Harman", 45, 10000));

        employees.sort(Comparator.comparingDouble(emp -> emp.salary));

        employees.forEach(System.out::println);
    }
}
