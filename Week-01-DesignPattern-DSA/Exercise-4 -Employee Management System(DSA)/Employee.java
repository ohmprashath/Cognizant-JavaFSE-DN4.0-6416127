class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + name + 
                           ", Position: " + position + ", Salary: " + salary);
    }
}
