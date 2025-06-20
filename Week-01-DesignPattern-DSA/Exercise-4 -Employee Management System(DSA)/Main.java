public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee(101, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(103, "Charlie", "Tester", 50000));

        System.out.println("\nAll Employees:");
        ems.displayAllEmployees();

        System.out.println("\nSearching Employee with ID 102:");
        Employee emp = ems.searchEmployee(102);
        if (emp != null) emp.displayInfo();
        else System.out.println("Employee not found.");

        System.out.println("\nDeleting Employee with ID 102:");
        ems.deleteEmployee(102);

        System.out.println("\nAll Employees after Deletion:");
        ems.displayAllEmployees();
    }
}
