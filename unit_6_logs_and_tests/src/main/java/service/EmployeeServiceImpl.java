package service;

import dao.InMemoryEmployeeDao;
import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeServiceImpl implements EmployeeServices {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Scanner IN = new Scanner(System.in);
    InMemoryEmployeeDao employeeDao = new InMemoryEmployeeDao();


    @Override
    public void create(Employee employee) {
        LOGGER_INFO.info("Settled new employee: " + employee.getFullname());
        if (!checkName(employee.getFullname())) LOGGER_WARN.warn("invalid name: " + employee.getFullname());
        else employeeDao.create(employee);
    }

    @Override
    public void update() {
        try {
            System.out.println("Enter fullname for employee which should be updated: ");
            String name = IN.nextLine();
            System.out.println("Enter new position and salary for employee:" + name);
            String newPosition = IN.nextLine();
            String newSalary = IN.nextLine();
            if (checkSalary(newSalary)) {
                if (checkName(newPosition)) {
                    LOGGER_INFO.info("update employee: " + name);
                    employeeDao.update(name, newPosition, newSalary);
                } else LOGGER_WARN.warn("new position" + newPosition + "  is incorrect");
            } else LOGGER_WARN.warn("New salary for: " + name + "  is incorrect");
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Employee dosn`t exist");
        }
    }

    @Override
    public void deleteByName(String name) {
        LOGGER_INFO.info("delete employee by name: " + name);
        employeeDao.delete(name);
    }

    @Override
    public Employee findByName(String name) {
        LOGGER_INFO.info("finding employee by name: " + name);
        return employeeDao.findEmployeeByName(name);
    }

    @Override
    public Employee[] findAll() {
        LOGGER_INFO.info("finding all employees ");
        return employeeDao.findAllemployees();
    }

    @Override
    public boolean checkAge(int age) {
        return (age > 15 && age < 90);
    }

    @Override
    public boolean checkSalary(String salary) {
        return Pattern.matches("^[0-9]*", salary);
    }

    @Override
    public boolean checkName(String name) {
        return Pattern.matches("^[\\p{L} .'-]*$", name);
    }

    @Override
    public boolean checkDepartmentId(String departmentId) {
        return Pattern.matches("^[0-9]*", departmentId);
    }
}
