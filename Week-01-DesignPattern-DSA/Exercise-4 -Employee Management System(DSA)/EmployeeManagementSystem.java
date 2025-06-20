class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    
    public Employee searchEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                employees[i].displayInfo();
            }
        }
    }

    // Delete Employee by ID
    public boolean deleteEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return true;
            }
        }
        System.out.println("Employee not found.");
        return false;
    }
}
