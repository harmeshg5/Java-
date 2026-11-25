import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeAnalytics {

    private final List<Employee> employees;

    public EmployeeAnalytics(List<Employee> employees) {
        this.employees = employees;
    }

    public long countByDepartment(String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .count();
    }

    public long countBySalaryGreaterThan(double threshold) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > threshold)
                .count();
    }

    public double getTotalSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public double getMinimumSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0.0);
    }

    public double getMaximumSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
    }

    public DoubleSummaryStatistics getSalaryStatistics() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
    }

    public Map<String, Long> countEmployeesByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public Map<String, Double> averageSalaryByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public Map<String, Optional<Employee>> highestPaidEmployeeByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    public List<Employee> getTopNEmployeesByDepartment(String department, int n) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(n)
                .toList();
    }

    public void printSalaryReport() {
        DoubleSummaryStatistics stats = getSalaryStatistics();
        System.out.println("Salary Report:");
        System.out.println("Total salary: " + stats.getSum());
        System.out.println("Average salary: " + stats.getAverage());
        System.out.println("Highest salary: " + stats.getMax());
        System.out.println("Lowest salary: " + stats.getMin());
        System.out.println("Employee count: " + stats.getCount());
    }

    public void printDepartmentReport() {
        System.out.println("Department Report:");
        for (String department : countEmployeesByDepartment().keySet()) {
            long count = countByDepartment(department);
            double averageSalary = averageSalaryByDepartment().getOrDefault(department, 0.0);
            Optional<Employee> highestPaid = highestPaidEmployeeByDepartment().get(department);

            System.out.println("Department: " + department);
            System.out.println("Employee count: " + count);
            System.out.println("Average salary: " + averageSalary);
            System.out.println("Highest-paid employee: " + highestPaid.orElse(null));
            System.out.println();
        }
    }
}
