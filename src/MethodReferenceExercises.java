import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExercises {

    private static void printEmployee(Employee employee) {
        System.out.println(employee);
    }

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = new ArrayList<>(repository.findAll());

        System.out.println("=== Method Reference Exercises ===");

        System.out.println("\nPrint employees using static method reference:");
        employees.forEach(MethodReferenceExercises::printEmployee);

        System.out.println("\nEmployee names using instance method reference:");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("\nEmployees sorted by salary using Comparator.comparingDouble:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);

        Function<Employee, String> departmentMapper = Employee::getDepartment;
        System.out.println("\nDepartments using method reference:");
        employees.stream()
                .map(departmentMapper)
                .distinct()
                .forEach(System.out::println);

        Supplier<List<Employee>> employeeSupplier = ArrayList::new;
        List<Employee> copiedEmployees = employeeSupplier.get();
        copiedEmployees.addAll(employees);
        System.out.println("\nCopied employees count: " + copiedEmployees.size());
    }
}
