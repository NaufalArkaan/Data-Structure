// Employee.java
public class Employee implements Comparable<Employee> {

    int employeeId;
    String name;
    String department;

    public Employee(int employeeId,
                    String name,
                    String department) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    @Override
    public int compareTo(Employee other) {

        return Integer.compare(
                this.employeeId,
                other.employeeId
        );
    }

    @Override
    public String toString() {

        return employeeId
                + " - "
                + name
                + " ("
                + department
                + ")";
    }
}