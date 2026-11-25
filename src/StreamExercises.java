import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamExercises {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = repository.findAll();

        System.out.println("=== Stream Exercises ===");

        System.out.println("\nEmployees with salary greater than 50,000:");
        employees.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .forEach(System.out::println);

        System.out.println("\nEmployees in IT department:");
        employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .forEach(System.out::println);

        System.out.println("\nEmployees whose names start with A:");
        employees.stream()
                .filter(employee -> employee.getName().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("\nEmployees earning between 40,000 and 70,000:");
        employees.stream()
                .filter(employee -> employee.getSalary() >= 40000 && employee.getSalary() <= 70000)
                .forEach(System.out::println);

        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
        List<Double> employeeSalaries = employees.stream().map(Employee::getSalary).toList();
        List<String> employeeDepartments = employees.stream().map(Employee::getDepartment).toList();
        System.out.println("\nEmployee Names: " + employeeNames);
        System.out.println("Employee Salaries: " + employeeSalaries);
        System.out.println("Employee Departments: " + employeeDepartments);

        System.out.println("\nEmployees sorted by name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("\nEmployees sorted by salary (ascending):");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6));
        List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
        System.out.println("\nUnique Numbers: " + uniqueNumbers);

        List<String> uniqueDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();
        System.out.println("Unique Departments: " + uniqueDepartments);

        List<String> names = new ArrayList<>(Arrays.asList("Amit", "Priya", "Rahul", "Neha", "Amit", "Arjun", "Priya"));
        List<String> uniqueNames = names.stream().distinct().toList();
        System.out.println("Unique Names: " + uniqueNames);

        List<Double> itSalaries = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .map(Employee::getSalary)
                .toList();
        System.out.println("\nSalaries of IT employees: " + itSalaries);

        long countITEmployees = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .count();
        System.out.println("Count of IT employees: " + countITEmployees);

        long countHighSalaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() > 60000)
                .count();
        System.out.println("Count of employees with salary above 60,000: " + countHighSalaryEmployees);

        double minSalary = employees.stream().mapToDouble(Employee::getSalary).min().orElse(0.0);
        double maxSalary = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
        System.out.println("Minimum salary: " + minSalary);
        System.out.println("Maximum salary: " + maxSalary);

        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfNumbers = numbersList.stream().reduce(0, Integer::sum);
        double totalEmployeeSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        int maxNumber = numbersList.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("\nSum of numbers: " + sumOfNumbers);
        System.out.println("Total employee salary: " + totalEmployeeSalary);
        System.out.println("Maximum number: " + maxNumber);

        boolean anyEmployeeAbove100k = employees.stream().anyMatch(employee -> employee.getSalary() > 100000);
        boolean allEmployeesAbove30k = employees.stream().allMatch(employee -> employee.getSalary() > 30000);
        System.out.println("\nAny employee earning more than 100,000: " + anyEmployeeAbove100k);
        System.out.println("All employees earning more than 30,000: " + allEmployeesAbove30k);

        Optional<Employee> firstITEmployee = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .findFirst();
        Optional<Employee> firstHighSalaryEmployee = employees.stream()
                .filter(employee -> employee.getSalary() > 70000)
                .findFirst();
        System.out.println("First IT employee: " + firstITEmployee.orElse(null));
        System.out.println("First employee earning above 70,000: " + firstHighSalaryEmployee.orElse(null));

        System.out.println("\nTop 3 IT employees by salary:");
        employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        EmployeeAnalytics analytics = new EmployeeAnalytics(new ArrayList<>(employees));
        System.out.println();
        analytics.printSalaryReport();
        System.out.println();
        analytics.printDepartmentReport();
    }
}
