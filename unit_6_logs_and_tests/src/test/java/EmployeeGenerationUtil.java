import entity.Employee;

public class EmployeeGenerationUtil {

    public static final int AGE = 25;
    public static final String NAME = "testName";
    public static final String SALARY = "2500";

    public static Employee generateEmployee() {
        Employee employee = new Employee();
        employee.setFullname(NAME);
        employee.setSalary(SALARY);
        employee.setAge(AGE);
        return employee;
    }

    public static Employee generateEmployee(String name, int age, String salary) {
        Employee employee = new Employee();
        employee.setFullname(name);
        employee.setSalary(salary);
        employee.setAge(age);
        return employee;
    }

    public static Employee generateEmployee(int age) {
        Employee employee = new Employee();
        employee.setFullname(NAME);
        employee.setAge(age);
        return employee;
    }
}

