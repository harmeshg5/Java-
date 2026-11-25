import java.util.Optional;

public class OptionalExercises {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        System.out.println("=== Optional Exercises ===");

        int existingId = 101;
        int missingId = 999;

        System.out.println("\nExercise O-1 - User Search:");
        Optional<Employee> foundEmployee = service.findEmployeeById(existingId);
        foundEmployee.ifPresentOrElse(
                employee -> System.out.println("Employee found: " + employee),
                () -> System.out.println("User Not Found"));

        Optional<Employee> missingEmployee = service.findEmployeeById(missingId);
        missingEmployee.ifPresentOrElse(
                employee -> System.out.println("Employee found: " + employee),
                () -> System.out.println("User Not Found"));

        System.out.println("\nExercise O-2 - Employee Search:");
        Employee employeeByOrElse = service.findEmployeeById(missingId)
                .orElse(new Employee(0, "Default Employee", "NA", 0));
        System.out.println("orElse result: " + employeeByOrElse);

        try {
            Employee employeeByOrElseThrow = service.findEmployeeById(existingId)
                    .orElseThrow(() -> new EmployeeNotFoundException(existingId));
            System.out.println("orElseThrow result: " + employeeByOrElseThrow);

            Optional<Employee> filteredEmployee = service.findEmployeeById(existingId)
                    .filter(employee -> employee.getSalary() > 50000);
            System.out.println("filter(salary > 50000): " + filteredEmployee.orElse(null));
        } catch (EmployeeNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\nExercise O-3 - Optional Pipeline:");
        System.out.println("Uppercase name: " + getEmployeeNameInUpperCase(service.getEmployeeById(existingId)));
        System.out.println("Default name: " + getEmployeeNameInUpperCase(new Employee(200, "Al", "IT", 30000)));
        System.out.println("Null employee: " + getEmployeeNameInUpperCase(null));
    }

    public static String getEmployeeNameInUpperCase(Employee employee) {
        return Optional.ofNullable(employee)
                .map(Employee::getName)
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase)
                .orElse("Default Name");
    }
}
