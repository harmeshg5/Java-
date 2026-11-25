import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(101, "Amit", "IT", 60000));
        employees.add(new Employee(102, "Priya", "HR", 45000));
        employees.add(new Employee(103, "Rahul", "IT", 75000));
        employees.add(new Employee(104, "Neha", "Finance", 55000));
        employees.add(new Employee(105, "Arjun", "IT", 90000));
        employees.add(new Employee(106, "Sneha", "HR", 50000));
        employees.add(new Employee(107, "Vikas", "Finance", 80000));
        employees.add(new Employee(108, "Karan", "IT", 40000));
    }

    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }
}
