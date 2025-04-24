package Projects;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String designation;
    private String department;
    private double salary;

    public Employee(int id, String name, int age, String designation, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDesignation() { return designation; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Designation: %s, Department: %s, Salary: %.2f",
                id, name, age, designation, department, salary);
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("\nEnter Employee Details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Employee employee = new Employee(id, name, age, designation, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("\nNo employees found!");
            return;
        }

        System.out.println("\nAll Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void searchEmployee() {
        System.out.print("\nEnter Employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("\nEmployee Found:");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void updateEmployee() {
        System.out.print("\nEnter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("\nEnter new details:");
                System.out.print("Name: ");
                employee.setName(scanner.nextLine());

                System.out.print("Age: ");
                employee.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline

                System.out.print("Designation: ");
                employee.setDesignation(scanner.nextLine());

                System.out.print("Department: ");
                employee.setDepartment(scanner.nextLine());

                System.out.print("Salary: ");
                employee.setSalary(scanner.nextDouble());
                scanner.nextLine(); // Consume newline

                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee() {
        System.out.print("\nEnter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void displayMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            system.displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.viewAllEmployees();
                    break;
                case 3:
                    system.searchEmployee();
                    break;
                case 4:
                    system.updateEmployee();
                    break;
                case 5:
                    system.deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
