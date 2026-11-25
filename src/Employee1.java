import java.util.*;

class Employee1 {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee1(int id, String name,
            String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " +
                department + " " + salary;
    }


    // Exercise O-1 — User Search: Create a method findUserById(), Return Optional<User>, 
    // Return Optional.empty() if not found, Display user if present, Display User Not Found if absent
    public Optional<Employee1> findUserById(int id) {
        Optional<Employee1> employee = Optional.empty();
        if (employee.get().getId() == id) {
            System.out.println("Employee found: " + employee.get());
        } else {
            System.out.println("Employee not found");
        }
        return employee;
    }

    // Exercise O-2 — Employee Search: Search employee by ID, Return Optional<Employee>, Use orElse(), Use orElseThrow(), Use filter() on Optional
    public Optional<Employee1> searchEmployeeById(int id) {
        Optional<Employee1> employee = Optional.empty();
        if (employee.get().getId() == id) {
            System.out.println("Employee found: " + employee.get());
        } else {
            System.out.println("Employee not found");
        }
        return employee;
    }

    //Exercise O-3 — Optional Pipeline: Wrap employee name in Optional, Convert name to uppercase using map(),Filter name based on length, Return default value when empty
    public String getEmployeeNameInUpperCase(Employee1 employee) {
        return Optional.ofNullable(employee)
                .map(Employee1::getName)
                .filter(name -> name.length() > 3)
                .orElse("Default Name");
    }



}