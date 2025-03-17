import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kamal", 85));
        students.add(new Student("Rahul", 65));
        students.add(new Student("Mayank", 90));
        students.add(new Student("Dipesh", 75));

        List<String> filteredAndSortedNames = students.stream()
                .filter(student -> student.marks >= 75)
                .sorted(Comparator.comparingDouble(student -> student.marks))
                .map(student -> student.name)
                .collect(Collectors.toList());

        filteredAndSortedNames.forEach(System.out::println);
    }
}
