public class ExceptionExercises {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        System.out.println("=== Exception Exercises ===");

        try {
            System.out.println("\nFetching existing employee:");
            Employee employee = service.getEmployeeById(101);
            System.out.println("Found: " + employee);

            System.out.println("\nFetching missing employee:");
            service.getEmployeeById(999);
        } catch (EmployeeNotFoundException exception) {
            System.out.println("Handled EmployeeNotFoundException: " + exception.getMessage());
        }

        try {
            System.out.println("\nUpdating salary with invalid value:");
            service.updateEmployeeSalary(101, -5000);
        } catch (InvalidSalaryException exception) {
            System.out.println("Handled InvalidSalaryException: " + exception.getMessage());
        }

        try {
            System.out.println("\nCreating employee with invalid salary:");
            new Employee(201, "Test", "QA", -1);
        } catch (InvalidSalaryException exception) {
            System.out.println("Handled InvalidSalaryException: " + exception.getMessage());
        } finally {
            System.out.println("Validation complete.");
        }

        try {
            System.out.println("\nSafe salary update:");
            service.updateEmployeeSalary(102, 52000);
            System.out.println("Updated employee: " + service.getEmployeeById(102));
        } catch (RuntimeException exception) {
            System.out.println("Unexpected error: " + exception.getMessage());
        }
    }
}
