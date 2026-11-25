import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExercises {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = new ArrayList<>(repository.findAll());

        System.out.println("=== Lambda Exercises ===");

        Predicate<Employee> highSalary = employee -> employee.getSalary() > 50000;
        System.out.println("\nEmployees with salary greater than 50,000:");
        employees.stream().filter(highSalary).forEach(System.out::println);

        Predicate<Employee> inItDepartment = employee -> employee.getDepartment().equalsIgnoreCase("IT");
        System.out.println("\nEmployees in IT department:");
        employees.stream().filter(inItDepartment).forEach(System.out::println);

        Predicate<Employee> nameStartsWithA = employee -> employee.getName().startsWith("A");
        System.out.println("\nEmployees whose names start with A:");
        employees.stream().filter(nameStartsWithA).forEach(System.out::println);

        Predicate<Employee> salaryBetween40kAnd70k = employee -> employee.getSalary() >= 40000 && employee.getSalary() <= 70000;
        System.out.println("\nEmployees earning between 40,000 and 70,000:");
        employees.stream().filter(salaryBetween40kAnd70k).forEach(System.out::println);

        Function<Employee, String> toUpperCaseName = employee -> employee.getName().toUpperCase();
        System.out.println("\nEmployee names in uppercase:");
        employees.stream().map(toUpperCaseName).forEach(name -> System.out.println("Uppercase Name: " + name));

        Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
        employees.sort(byName);
        System.out.println("\nEmployees sorted by name:");
        employees.forEach(System.out::println);

        Comparator<Employee> bySalaryAscending = Comparator.comparingDouble(Employee::getSalary);
        employees.sort(bySalaryAscending);
        System.out.println("\nEmployees sorted by salary (ascending):");
        employees.forEach(System.out::println);

        Consumer<List<Integer>> printUniqueNumbers = numbers -> {
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                if (!uniqueNumbers.contains(number)) {
                    uniqueNumbers.add(number);
                }
            }
            System.out.println("\nUnique Numbers: " + uniqueNumbers);
        };
        printUniqueNumbers.accept(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6)));

        Runnable greeting = () -> System.out.println("\nLambda exercise completed.");
        greeting.run();
    }
}
