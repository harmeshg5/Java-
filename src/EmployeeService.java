import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> findEmployeeById(int id) {
        return repository.findById(id);
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee getEmployeeByIdOrDefault(int id, Employee defaultEmployee) {
        return repository.findById(id).orElse(defaultEmployee);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findAll().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }

    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
        return repository.findAll().stream()
                .filter(employee -> employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary)
                .toList();
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        if (newSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + newSalary);
        }
        Employee employee = getEmployeeById(id);
        employee.setSalary(newSalary);
    }
}
