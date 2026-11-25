import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmployeeMain {
        // For Class Employee1
    static List<Employee1> employees = new ArrayList<>();
static {
        employees.add(new Employee1(101, "Amit", "IT", 60000));
        employees.add(new Employee1(102, "Priya", "HR", 45000));
        employees.add(new Employee1(103, "Rahul", "IT", 75000));
        employees.add(new Employee1(104, "Neha", "Finance", 55000));
        employees.add(new Employee1(105, "Arjun", "IT", 90000));
        employees.add(new Employee1(106, "Sneha", "HR", 50000));
        employees.add(new Employee1(107, "Vikas", "Finance", 80000));
        employees.add(new Employee1(108, "Karan", "IT", 40000));
    }   

    public static void main(String[] args) {
                
        // Find employees from Employee1 with salary greater than 50,000
        System.out.println("Employees with salary greater than 50,000:");
        for (Employee1 emp : employees) {
            Employee1 emp1 = new Employee1(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            if (emp1.getSalary() > 50000) {
                System.out.println(emp);
            }
        }

        // Find all employees in IT department
        System.out.println("\nEmployees in IT department:");
        for (Employee1 emp : employees) {
            Employee1 emp1 = new Employee1(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            if (emp1.getDepartment().equalsIgnoreCase("IT")) {
                System.out.println(emp);
            }

            // Find employees whose names start with A
            if(emp1.getName().startsWith("A"))
            {
                System.out.println("A - " +emp);
            }

            // Find employees earning between 40,000 and 70,000
            if(emp1.getSalary() >= 40000 && emp1.getSalary() <= 70000)
            {
                System.out.println("Salary between 40,000 and 70,000 - " +emp);
            }

            // Convert all employee names to uppercase
            String upperCaseName = emp1.getName().toUpperCase();
            System.out.println("Uppercase Name: " + upperCaseName);
        }

        // Extract employee names, into separate List<String>
        // Create a list of names with department appended
        List<String> employeeNames = new ArrayList<>();
        List<Double> employeeSalaries = new ArrayList<>();
        List<String> employeeDepartments = new ArrayList<>();
        for (Employee1 emp : employees) {
            Employee1 emp1 = new Employee1(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            employeeNames.add(emp1.getName());
            employeeSalaries.add(emp1.getSalary());
            employeeDepartments.add(emp1.getDepartment());
        }
        System.out.println("\nEmployee Names: " + employeeNames);
        System.out.println("Employee Salaries: " + employeeSalaries);
        System.out.println("Employee Departments: " + employeeDepartments);

        // Sort employees by name
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("\nEmployees sorted by name:");
        for (Employee1 emp : employees) {
            System.out.println(emp);
        }

        // Sort employees by salary ascending
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("\nEmployees sorted by salary (ascending):");
        for (Employee1 emp : employees) {
            System.out.println(emp);
        }

        // Remove duplicate numbers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6));
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        System.out.println("\nUnique Numbers: " + uniqueNumbers);   

        // Find unique department names
        List<String> uniqueDepartments = new ArrayList<>();
        for (Employee1 emp : employees) {
            Employee1 emp1 = new Employee1(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            if (!uniqueDepartments.contains(emp1.getDepartment())) {
                uniqueDepartments.add(emp1.getDepartment());
            }
        }
        System.out.println("\nUnique Departments: " + uniqueDepartments);

        // Remove duplicate names from a list
        List<String> names = new ArrayList<>(Arrays.asList("Amit", "Priya", "Rahul", "Neha", "Amit", "Arjun", "Priya"));
        List<String> uniqueNames = new ArrayList<>();
        for (String name : names) {
            if (!uniqueNames.contains(name)) {
                uniqueNames.add(name);
            }
        }
        System.out.println("\nUnique Names: " + uniqueNames);


        //Collect IT employees into a new list 
        //Collect employee names into a list 
        //Collect salaries into a new collection 
        //Convert filtered stream output into a List
        List<Double> salaries = employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .map(Employee1::getSalary)
                .toList();
        System.out.println("\nSalaries of IT employees: " + salaries);



        //Count IT employees
        //Count employees with salary above 60,000
        //Find minimum salary
        //Find maximum salary
        long countITEmployees = employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .count();
        System.out.println("\nCount of IT employees: " + countITEmployees);

        long countHighSalaryEmployees = employees.stream()
                .filter(emp -> emp.getSalary() > 60000)
                .count();
        System.out.println("Count of employees with salary above 60,000: " + countHighSalaryEmployees);

        double minSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .min()
                .orElse(0);
        System.out.println("Minimum salary: " + minSalary);

        double maxSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .max()
                .orElse(0);
        System.out.println("Maximum salary: " + maxSalary);


        // Calculate sum of numbers using reduce 
        // Calculate total employee salary 
        // Find maximum number using reduce
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfNumbers = numbersList.stream()
                .reduce(0, Integer::sum);   
            
        System.out.println("\nSum of numbers: " + sumOfNumbers);
        double totalEmployeeSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .sum();
        System.out.println("Total employee salary: " + totalEmployeeSalary);
        int maxNumber = numbersList.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Maximum number: " + maxNumber);

        // Check whether any employee earns more than 100,000 
        // Check whether all employees have salary greater than 30,000 
        // Find the first employee in IT 
        // Find the first employee earning above 70,000

        boolean anyEmployeeAbove100k = employees.stream()
                .anyMatch(emp -> emp.getSalary() > 100000);
        System.out.println("\nAny employee earning more than 100,000: " + anyEmployeeAbove100k);
        boolean allEmployeesAbove30k = employees.stream()
                .allMatch(emp -> emp.getSalary() > 30000);  
        System.out.println("All employees earning more than 30,000: " + allEmployeesAbove30k);

        // Find the first employee in IT 
        // Find the first employee earning above 70,000
        Optional<Employee1> firstITEmployee = employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .findFirst();
        System.out.println("\nFirst IT employee: " + firstITEmployee.orElse(null));

        Optional<Employee1> firstHighSalaryEmployee = employees.stream()
                .filter(emp -> emp.getSalary() > 70000)
                .findFirst();
        System.out.println("First employee earning above 70,000: " + firstHighSalaryEmployee.orElse(null));

        // Top 3 Employees Filter IT employees, Sort salary descending, Limit results to 3, Print employees
        System.out.println("\nTop 3 IT employees by salary:");
        employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .forEach(System.out::println);


        // Exercise S-10 — Salary Report: Calculate total salary, Calculate average salary, Find highest salary, Find lowest salary, Count employees
        double totalSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .sum();        
        double averageSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .average()
                .orElse(0.0);
        double highestSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .max()
                .orElse(0.0);
        double lowestSalary = employees.stream()
                .mapToDouble(Employee1::getSalary)
                .min()
                .orElse(0.0);
        long employeeCount = employees.stream()
                .count();

        System.out.println("\nSalary Report:");
        System.out.println("Total salary: " + totalSalary);
        System.out.println("Average salary: " + averageSalary);
        System.out.println("Highest salary: " + highestSalary);
        System.out.println("Lowest salary: " + lowestSalary);
        System.out.println("Employee count: " + employeeCount); 

        // Exercise S-11 — Department Report: Get unique departments, Count employees by department, Find average salary by department, Find highest-paid employee per department (bonus);

        List<String> uniqueDepartments1 = employees.stream()
                .map(Employee1::getDepartment)
                .distinct()
                .toList();

        System.out.println("\nDepartment Report:");
        for (String department : uniqueDepartments1) {   
            long countByDepartment = employees.stream()
                    .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                    .count();
            double averageSalaryByDepartment = employees.stream()
                    .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                    .mapToDouble(Employee1::getSalary)
                    .average()
                    .orElse(0.0);
            Optional<Employee1> highestPaidEmployeeByDepartment = employees.stream()
                    .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                    .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

            System.out.println("Department: " + department);
            System.out.println("Employee count: " + countByDepartment);
            System.out.println("Average salary: " + averageSalaryByDepartment);
            System.out.println("Highest-paid employee: " + highestPaidEmployeeByDepartment.orElse(null));
        }




    }


}

