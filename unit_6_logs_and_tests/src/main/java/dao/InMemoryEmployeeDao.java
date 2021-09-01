package dao;


import entity.Employee;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryEmployeeDao {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private Employee[] employees;
    private int SIZE = 1;
    private int countOfEmployees = 0;

    public InMemoryEmployeeDao() {
        employees = new Employee[SIZE];
    }

    public Employee create(Employee employee) {
        SIZE = employees.length;
        if (employee != null) {
            employee.setId(generateId());
            if (countOfEmployees > SIZE - 1) {
                System.out.println("Upgrading of array");
                upgradeArray();
            }
            employees[countOfEmployees] = employee;
            LOGGER_INFO.info("Added new employee:\t" + employees[countOfEmployees].toString());
            countOfEmployees++;
            return employees[countOfEmployees - 1];
        }
        LOGGER_WARN.warn("Incorrect employee-data");
        return null;
    }

    public void upgradeArray() {
        SIZE = employees.length * 2;
        Employee[] newEmployee = new Employee[SIZE];
        for (int i = 0; i < employees.length; i++)
            newEmployee[i] = employees[i];
        employees = newEmployee;
    }

    public void update(String fullname, String newPosition, String newSalary) {
        LOGGER_INFO.info("Updating employee:\t" + fullname);
        int num = employees.length + 1;
        for (int i = 0; i < countOfEmployees; i++)
            if (fullname.equals(employees[i].getFullname())) num = i;
        if (num != employees.length + 1) {
            employees[num].setPosition(newPosition);
            employees[num].setSalary(newSalary);
        } else
            LOGGER_WARN.warn("EMPLOYEE WITH THAT NAME NOT FOUNDED");
    }

    public void delete(String name) {
        try {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getFullname().contains(name)) {
                    employees = ArrayUtils.remove(employees, i);
                    break;
                }
            }
            countOfEmployees--;
            SIZE = employees.length;
            LOGGER_INFO.info("Deleted employee:\t" + name);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Employee doesn`t exist");
        }
    }

    public Employee findEmployeeByName(String name) {
        try {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getFullname().equals(name))
                    return employees[i];
            }
            LOGGER_WARN.warn("employee:\t" + name + " not founded");
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("EMPLOYEES DOESN`T EXIST");
        }
        return null;
    }

    public Employee[] findAllemployees() {
        removeNulls();
        return employees;
    }

    public void removeNulls() {
        int count = 0;
        for (int i = 0; i < employees.length; i++)
            if (employees[i] != null) count++;

        if (count != 0) {
            SIZE = count;
            Employee[] newEmployee = new Employee[SIZE];
            for (int i = 0; i < SIZE; i++) {
                newEmployee[i] = employees[i];
            }
            employees = newEmployee;
        }
    }

    private String generateId() {
        return ("" + 1 + (int) (Math.random() * 13));
    }
}

